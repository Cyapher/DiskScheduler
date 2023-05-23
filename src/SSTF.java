import java.util.*;
import java.util.Map.Entry;

public class SSTF {
    
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
    public SSTF(List<Integer> requests, int initPos, int trackSize){
        this.requests = requests;
        this.initPos = initPos;
        this.trackSize = trackSize;
    }

    public void scheduleSSTF(){
        // List<Map.Entry<String, Integer>> locations = (List<Entry<String, Integer>>) requests;
        List<Integer> remainingReqs = requests;

        System.out.println("=============== In SSTF ===============");
        System.out.println("Requests Order: " + requests);
        System.out.println("Request ID\tPosition");
        currPos = initPos;
        int totalHeadMove = 0;
        double seekTime = 0.0;

        for(int i = 0; i < requests.size(); i++){
            int nextRequest = findClosestRequest(currPos, remainingReqs);
            // System.out.println("Current Position: " + currPos);
            // System.out.println("Next Request: " + temp.getValue());
            totalHeadMove += Math.abs(currPos - nextRequest);
            currPos = nextRequest;
            // System.out.println("Total Head Movement: " + totalHeadMove);
            remainingReqs.remove(Integer.valueOf(nextRequest));
            System.out.println("R"+ i + "\t\t" + requests.get(i));
        }
        System.out.println("Total Head Movement: " + totalHeadMove);

    }

    private static int findClosestRequest(int currentPos, List<Integer> requests){
        // Set<Map.Entry<String, Integer>> locations = requests.entrySet();
        int minDistance = Integer.MAX_VALUE;
        int closestRequest = 0;
        
            for(int request: requests){
                int distance = Math.abs(currentPos - request);
                if(distance < minDistance){
                    minDistance = distance;
                    closestRequest = request;
                }
            }

        return closestRequest;
    }

}
