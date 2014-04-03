import java.math.BigInteger;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: nullzine
 * Date: 2014/02/11
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(new Execution(100).toString());
    }
}

class Execution{

    HashSet<Integer> hSet = new HashSet<Integer>();

    public Execution(int limit){
        calculation(limit);
    }

    private void calculation(int limit){
        for(int i=1;i<=limit;i++){
            char[] strc = new BigInteger(Integer.toString(i)).pow(100).toString().toCharArray();
            if(!hSet.contains(Integer.parseInt(strc[strc.length-1]+""))){
                hSet.add(Integer.parseInt(strc[strc.length-1]+""));
                //System.out.println(strc[strc.length-1]);
            }
        }
    }

    public String toString(){
        String str = "";
        for(int i=0;i<10;i++){
            if(hSet.contains(i)){
                str=str+Integer.toString(i)+" ";
            }
        }
        return str;
    }

}

/*

nが自然数の全体を動くときn^100の1の位が取りうるすべての値を求めよ

answer:0 1 5 6

*/