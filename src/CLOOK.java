import java.util.*;

public class CLOOK {
    // Variables
    List<Integer> requests = new ArrayList<>();
    int initPos;
    int trackSize;
    int currPos;

    List<Integer> greaterList = new ArrayList<>();
    List<Integer> lesserList = new ArrayList<>();
    List<Integer> order = new ArrayList<>();

    // Constructor
    // Integer Current Pos
    // Integer Track Size
    public CLOOK(List<Integer> requests, int initPos, int trackSize) {
        this.requests = requests;
        this.initPos = initPos;
        this.trackSize = trackSize;
    }

    public void scheduleCLOOK() {
        System.out.println("=============== In C-LOOK ===============");
        System.out.println("Requests: " + requests);

        int totalRequest = requests.size();
        int totalHeadMove = 0;
        double seekTime = 0.0;

        List<Integer> lesserList = new ArrayList<>();
        List<Integer> greaterList = new ArrayList<>();

        // Divide requests into lesser and greater divisions based on current head
        // position
        for (int i = 0; i < totalRequest; i++) {
            if (requests.get(i) < initPos) {
                lesserList.add(requests.get(i));
            } else {
                greaterList.add(requests.get(i));
            }
        }
        System.out.println("LesserList: " + lesserList);
        System.out.println("GreaterList: " + greaterList);

        Collections.sort(greaterList);

        // Process requests greater than the current head position
        for (int i = 0; i < greaterList.size(); i++) {
            currPos = initPos;
            initPos = greaterList.get(i);
            order.add(initPos);
            totalHeadMove += Math.abs(initPos - currPos);
        }

        // Move the head back to the first request in the sorted list
        if (!greaterList.isEmpty()) {
            currPos = initPos;
            initPos = greaterList.get(0);
            totalHeadMove += Math.abs(initPos - currPos);
            order.add(initPos);
        }

        // Process requests in the lesser list
        for (int i = 0; i < lesserList.size(); i++) {
            currPos = initPos;
            initPos = lesserList.get(i);
            order.add(initPos);
            totalHeadMove += Math.abs(initPos - currPos);
        }

        // Get Seek time
        seekTime = totalHeadMove / requests.size();

        System.out.println("Total Head Movement: " + totalHeadMove);
        System.out.println("Average Seek Time: " + seekTime);
    }

}