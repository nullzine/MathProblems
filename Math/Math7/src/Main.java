import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nullzine
 * Date: 2014/02/11
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){

    }
}

class Execution{

    ArrayList<Integer> aList = new ArrayList<Integer>();

    public Execution(){
        calculation();
    }

    private void calculation(){
        for(int i=1;i<10000;i++){
            double tmp = Math.sqrt(Math.pow(i,2)+i+34);
            if(tmp-Math.floor(tmp)==0.0){
                aList.add((int)tmp);
            }
        }
    }

    public String toString(){
        String str = "";
        for(int i=0;i<aList.size();i++){
            str=str+Integer.toString(aList.get(i))+" ";
        }
        return str;
    }

}

/*
route(n^2+n+34)が整数となるような自然数nを全て求めよ
*/