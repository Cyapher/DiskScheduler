import java.util.*;
import java.util.Map.Entry;

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
        List<Map.Entry<String, Integer>> locations = (List<Entry<String, Integer>>) requests;
        System.out.println("=============== In SSTF ===============");
        System.out.println("Requests Order: " + locations);
        System.out.println("Request ID\tPosition");
        currPos = initPos;
        int totalHeadMove = 0;
        double seekTime = 0.0;

        for(Map.Entry<String, Integer> temp: locations){
            Map.Entry<String, Integer> nextRequest = findClosestRequest(currPos, locations);
            // System.out.println("Current Position: " + currPos);
            // System.out.println("Next Request: " + temp.getValue());
            totalHeadMove += Math.abs(currPos - temp.getValue());
            currPos = nextRequest.getValue();
            System.out.println("Total Head Movement: " + totalHeadMove);
            locations.remove(nextRequest);
            System.out.println(temp.getKey() + "\t\t" + temp.getValue());
        }
        System.out.println("Total Head Movement: " + totalHeadMove);

    }

    private static Map.Entry<String, Integer> findClosestRequest(int currentPos, List<Map.Entry<String, Integer>> requests){
        // Set<Map.Entry<String, Integer>> locations = requests.entrySet();
        int minDistance = Integer.MAX_VALUE;
        Map.Entry<String, Integer> closestRequest = null;
        
            for(Map.Entry<String, Integer> request: requests){
                int distance = Math.abs(currentPos - request.getValue());
                if(distance < minDistance){
                    minDistance = distance;
                    closestRequest = request;
                }
            }

        return closestRequest;
    }

}
