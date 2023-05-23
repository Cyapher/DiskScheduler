import java.util.*;

public class SSTF {
    
    //Variables
    LinkedHashMap<String, Integer> requests = new LinkedHashMap<>();
    int initPos;
    int trackSize;
    int currPos;

    //Constructor
    //Hashmap of all requests
    //Integer Current Pos
    //Integer Track Size
    public SSTF(LinkedHashMap<String, Integer> requests, int initPos, int trackSize){
        this.requests = requests;
        this.initPos = initPos;
        this.trackSize = trackSize;
    }

    public void scheduleSSTF(){
        Set<Map.Entry<String, Integer>> locations = requests.entrySet();
        System.out.println("=============== In SSTF ===============");
        System.out.println("Requests Order: " + locations);
        System.out.println("Request ID\tPosition");
        currPos = initPos;
        int totalHeadMove = 0;
        double seekTime = 0.0;

        for(Map.Entry<String, Integer> temp: locations){
            // System.out.println("Current Position: " + currPos);
            // System.out.println("Next Request: " + temp.getValue());
            totalHeadMove += Math.abs(currPos - temp.getValue());
            currPos = temp.getValue();
            System.out.println("Total Head Movement: " + totalHeadMove);
            System.out.println(temp.getKey() + "\t\t" + temp.getValue());
        }
        System.out.println("Total Head Movement: " + totalHeadMove);

    }

}
