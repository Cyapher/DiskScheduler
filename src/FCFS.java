import java.util.*;

public class FCFS {
    //Variables
    LinkedHashMap<String, Integer> requests = new LinkedHashMap<>();
    int initPos;
    int trackSize;
    int currPos;

    //Constructor
    //Hashmap of all requests
    //Integer Current Pos
    //Integer Track Size
    public FCFS(LinkedHashMap<String, Integer> requests, int initPos, int trackSize){
        this.requests = requests;
        this.initPos = initPos;
        this.trackSize = trackSize;
    }

    public void scheduleFCFS(){
        Set<Map.Entry<String, Integer>> locations = requests.entrySet();
        System.out.println("=============== In FCFS ===============");
        System.out.println("Requests Order: " + locations);
        System.out.println("Request ID\tPosition");
        currPos = initPos;
        int totalHeadMove = 0;
        double seekTime = 0.0;

        for(Map.Entry<String, Integer> temp: locations){
            int nextRequest = findClosestRequest(currPos, requests);
            // System.out.println("Current Position: " + currPos);
            // System.out.println("Next Request: " + temp.getValue());
            totalHeadMove += Math.abs(currPos - temp.getValue());
            currPos = nextRequest;
            // System.out.println("Total Head Movement: " + totalHeadMove);
            locations.remove(Integer.valueOf(nextRequest));
            System.out.println(temp.getKey() + "\t\t" + temp.getValue());
        }
        System.out.println("Total Head Movement: " + totalHeadMove);

    }

    private static int findClosestRequest(int currentPos, LinkedHashMap<String, Integer> requests){
        Set<Map.Entry<String, Integer>> locations = requests.entrySet();
        int minDistance = Integer.MAX_VALUE;
        int closestRequest = -1;
        
            for(Map.Entry<String, Integer> request: locations){
                int distance = Math.abs(currentPos - request.getValue());
                if(distance < minDistance){
                    minDistance = distance;
                    closestRequest = request.getValue();
                }
            }

        return closestRequest;
    }

}
