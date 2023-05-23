import java.util.*;

public class FCFS {
    //Variables
    // LinkedHashMap<String, Integer> requests = new LinkedHashMap<>();
    List<Integer> requests = new ArrayList<>();
    int initPos;
    int trackSize;
    int currPos;

    //Constructor
    //Hashmap of all requests
    //Integer Current Pos
    //Integer Track Size
    public FCFS(List<Integer> requests, int initPos, int trackSize){
        this.requests = requests;
        this.initPos = initPos;
        this.trackSize = trackSize;
    }

    public void scheduleFCFS(){
        // Set<Map.Entry<String, Integer>> locations = requests.entrySet();
        System.out.println("=============== In FCFS ===============");
        System.out.println("Requests Order: " + requests);
        System.out.println("Request ID\tPosition");
        currPos = initPos;
        int totalHeadMove = 0;
        double seekTime = 0.0;
        //System.out.println("Sequence:");

        for(int i = 0; i < requests.size(); i++){
            // System.out.println("Current Position: " + currPos);
            // System.out.println("Next Request: " + temp.getValue());
            totalHeadMove += Math.abs(currPos - requests.get(i));
            seekTime = totalHeadMove/requests.size();
            currPos = requests.get(i);
            // System.out.println("Total Head Movement: " + totalHeadMove);
            
            //System.out.println("R" + i + "\t\t" + requests.get(i));
        }

        System.out.println("Total Head Movement: " + totalHeadMove);
        System.out.println("Average Seek Time: " + seekTime);
    }

}
