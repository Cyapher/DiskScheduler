import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        //Variables
        // LinkedHashMap<String, Integer> requests = new LinkedHashMap<>(); //(RID, Location)
        List<Integer> requests = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        //Request Attributes
        int reqNum = 0; //number of requests
        int initPos = 0; //current position
        int trackSize = 0; //track size
        int tempLoc;
        String RID;

        //Other attributes
        String scheduler = "";
        String choice;
        boolean again = true;
        boolean outOfBounds = true;

        while (again == true) {

            System.out.println("=========== OS Disk Scheduler Project ===========");
            System.out.println("Made By:\n Anuma, Anica Kirstenjane\n Diaz, Carlos Gabriel");
            System.out.println("=================================================\n");

            System.out.print("Enter no. of requests: ");
            reqNum = scan.nextInt();

            System.out.println("Enter track size: ");
            trackSize = scan.nextInt();

            System.out.println("Enter Initial Head Position: ");
            while(outOfBounds){
                initPos = scan.nextInt();
                if(initPos >= trackSize || initPos < 0){
                    System.out.println("Initial Position must not be out of bounds");
                } else{
                    requests.add(initPos);
                    outOfBounds = false;
                }
            } outOfBounds = true;

            //RID will depend on for loop
            //input separate request location
            System.out.println("Enter individual request location");
            
            for(int i = 0; i < reqNum; i++){             
                while(outOfBounds){
                    System.out.println("R" + (i + 1) + ": ");
                    // RID = "R" + (i + 1);
                    tempLoc = scan.nextInt();

                    if(tempLoc >= trackSize || tempLoc < 0){
                        System.out.println("Location must not be out of bounds");
                    } else{
                        requests.add(tempLoc);
                        outOfBounds = false;
                    }
                }
                outOfBounds = true;
            }

            // Set<Map.Entry<String, Integer>> locations = requests.entrySet();

            System.out.println("\nList of requests:");
            for(int i = 0; i < reqNum; i++){
                System.out.println("R" + i + ": " + requests.get(i));     
            }
            System.out.println("hashmap: " + requests);

            System.out.println("\nEnter the letter of Disk Scheduler you want\n");
            System.out.println("A: First-Come-First-Serve \n");
            System.out.println("B: Shortest-Seek-Time-First \n");
            System.out.println("C: Circular SCAN \n");
            System.out.println("D: Circular LOOK \n");

            scheduler = scan.next();

            switch (scheduler.toUpperCase()) {
                case "A":
                    // System.out.println("Initial Pos: " + initPos);
                    FCFS fcfs = new FCFS(requests, initPos, trackSize);
                    fcfs.scheduleFCFS();
                    break;
                case "B":
                    SSTF sstf = new SSTF(requests, initPos, trackSize);
                    sstf.scheduleSSTF();
                    break;
                case "C":
                    CSCAN cscan = new CSCAN(requests, initPos, trackSize);
                    cscan.scheduleCSCAN();
                    break;
                case "D":
                    CLOOK clook = new CLOOK(requests, initPos, trackSize);
                    clook.scheduleCLOOK();
                    break;
                default: System.out.println("Incorrect Input, try again!");  
            }

            System.out.println("Do you want to continue (Y/N)?");
            choice = scan.next();

            if (choice.toUpperCase().equals("N")) {
                again = false;
                System.out.println("Thank You for using Disk Scheduler");
            } else{
                requests.clear();
            }
        }

    }
}
