import java.util.*;

public class CSCAN {
    // Variables
    List<Integer> requests = new ArrayList<>();
    int initPos;
    int trackSize;
    int currPos;

    List<Integer> greaterList = new ArrayList<>();
    List<Integer> lesserList = new ArrayList<>();

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

        //put inputs into higher and lower division
        for(int i = 0; i < requests.size(); i++){
            if(requests.get(i) < initPos){
                lesserList.add(requests.get(i));
                System.out.println("LesserList: " + lesserList);
            } 
            else{
                greaterList.add(requests.get(i));
                System.out.println("GreaterList: " + greaterList);
            }
        }

        Collections.sort(lesserList);
        Collections.sort(greaterList);

        //process greater sequence
        for(int i = 0; i < greaterList.size(); i++){
            currPos = initPos;

        }

    }
    

}
