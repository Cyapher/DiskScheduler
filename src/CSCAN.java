import java.util.*;

public class CSCAN {
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
    public CSCAN(List<Integer> requests, int initPos, int trackSize) {
        this.requests = requests;
        this.initPos = initPos;
        this.trackSize = trackSize;
    }

    public void scheduleCSCAN(){
        
        System.out.println("=============== In CSCAN ===============");
        System.out.println("Requests: " + requests);

        int totalRequest = requests.size();
        int totalHeadMove = 0;
        double seekTime = 0.0;

        //put inputs into higher and lower division
        for(int i = 0; i < totalRequest; i++){
            if(requests.get(i) < initPos){
                lesserList.add(requests.get(i));
                
            } 
            else{
                greaterList.add(requests.get(i));
                
            }
        }
        System.out.println("LesserList: " + lesserList);
        System.out.println("GreaterList: " + greaterList);

        Collections.sort(lesserList);
        Collections.sort(greaterList);

        //process greater sequence
        for(int i = 0; i < greaterList.size(); i++){
            currPos = initPos;
            initPos = greaterList.get(i);
            order.add(initPos);
            totalHeadMove += Math.abs(initPos - currPos);
        }

        //Move to last position
        currPos = initPos;
        initPos = trackSize - 1;
        totalHeadMove += Math.abs(initPos - currPos);
        order.add(initPos);

        //Move back to 0th position
        currPos = initPos;
        initPos = 0; //back to 0th position
        totalHeadMove += Math.abs(initPos - currPos);
        order.add(currPos);

        //process lesser sequence
        for(int i = 0; i < lesserList.size(); i++){
            currPos = initPos;
            initPos = lesserList.get(i);
            order.add(initPos);
            totalHeadMove += Math.abs(initPos - currPos);
        }

        //Get Seek time
        seekTime = totalHeadMove / requests.size();

        System.out.println("Total Head Movement: " + totalHeadMove);
        System.out.println("Average Seek Time: " + seekTime);

    }
    

}
