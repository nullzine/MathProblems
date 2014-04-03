import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nullzine
 * Date: 2014/02/11
 * Time: 12:57
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(new Execution(120).size());
    }
}

class Execution{

    ArrayList<Integer> aList = new ArrayList<Integer>();

    public Execution(int limit){
        calculation(limit);
    }

    private void calculation(int limit){
        for(int i=1;i<=limit;i++){
            if(validNum(i)){
                aList.add(i);
            }
        }
    }

    private boolean validNum(int num){
        return ((int)Math.pow(num,2))%120==1;
    }

    public int size(){
        return aList.size();
    }


}


/*

n^2を120で割ると1余るような120以下の正整数nはいくつあるか

answer:16

*/