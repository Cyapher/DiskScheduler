import java.util.*;
import java.util.Map.Entry;

public class SSTF {

    // Variables
    // LinkedHashMap<String, Integer> requests = new LinkedHashMap<>();
    List<Integer> requests = new ArrayList<>();
    int initPos;
    int trackSize;
    int currPos;

    // Constructor
    // Hashmap of all requests
    // Integer Current Pos
    // Integer Track Size
    public SSTF(List<Integer> requests, int initPos, int trackSize) {
        this.requests = requests;
        this.initPos = initPos;
        this.trackSize = trackSize;
    }


    public void scheduleSSTF() {
        List<Integer> remainingReqs = requests;

        System.out.println("=============== In SSTF ===============");
        System.out.println("Requests: " + requests);
        // System.out.println("Request ID\tPosition");
        currPos = initPos;
        int totalRequest = requests.size();
        int totalHeadMove = 0;
        double seekTime = 0.0;

        while (!remainingReqs.isEmpty()) {
            int nextRequest = findClosestRequest(currPos, remainingReqs);
            totalHeadMove += Math.abs(currPos - nextRequest);
            currPos = nextRequest;
            remainingReqs.remove(Integer.valueOf(nextRequest));
            seekTime = totalHeadMove / totalRequest;
        }

        System.out.println("Total Head Movement: " + totalHeadMove);
        System.out.println("Average Seek Time: " + seekTime);

    }

    private static int findClosestRequest(int currentPos, List<Integer> requests) {
        // Set<Map.Entry<String, Integer>> locations = requests.entrySet();
        int minDistance = Integer.MAX_VALUE;
        int closestRequest = -1;

        for (int request : requests) {
            int distance = Math.abs(currentPos - request);
            if (distance < minDistance) {
                minDistance = distance;
                closestRequest = request;
            }
        }

        return closestRequest;
    }

}
