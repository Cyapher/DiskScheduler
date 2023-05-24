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

    // public void scheduleSSTF() {

    // System.out.println("=============== In SSTF ===============");
    // System.out.println("Requests Order: " + requests);
    // // System.out.println("Request ID\tPosition");
    // List<Integer> seekTime = new ArrayList<>();
    // List<Integer> list = new ArrayList<>(requests);
    // int totalHeadMove = 0;

    // list.add(initPos);
    // Collections.sort(list);
    // int i = list.indexOf(initPos);

    // while (list.size() != 1) {
    // int pos = list.get(i);
    // // seq += pos + "-->";
    // if (i == 0) {
    // seekTime.add(list.get(1) - pos);
    // list.remove(0);
    // } else if (i == list.size() - 1) {
    // seekTime.add(pos - list.get(--i));
    // list.remove(i + 1);
    // } else {

    // int l = pos - list.get(i - 1);
    // int r = list.get(i + 1) - pos;
    // seekTime.add(Math.min(l, r));

    // list.remove(i);
    // if (r <= l)
    // i--;
    // }

    // }
    // totalHeadMove += Math.abs(currPos - requests.get(i));
    // currPos = requests.get(i);
    // System.out.println("Total Head Movement: " + totalHeadMove);
    // System.out.println("Average Seek Time: " + seekTime);
    // // System.out.println("Sequence:" + seq + "-->" + list.get(0));

    // }

    public void scheduleSSTF() {
        // List<Map.Entry<String, Integer>> locations = (List<Entry<String, Integer>>)
        // requests;
        List<Integer> remainingReqs = requests;

        System.out.println("=============== In SSTF ===============");
        System.out.println("Requests: " + requests);
        // System.out.println("Request ID\tPosition");
        currPos = initPos;
        int totalRequest = requests.size();
        int totalHeadMove = 0;
        double seekTime = 0.0;

        // for(int i = 0; i < requests.size(); i++){
        // int nextRequest = findClosestRequest(currPos, remainingReqs);
        // // System.out.println("Current Position: " + currPos);
        // // System.out.println("Next Request: " + temp.getValue());
        // totalHeadMove += Math.abs(currPos - nextRequest);
        // currPos = nextRequest;
        // // System.out.println("Total Head Movement: " + totalHeadMove);
        // remainingReqs.remove(Integer.valueOf(nextRequest));
        // System.out.println("R"+ i + "\t\t" + requests.get(i));
        // }

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
