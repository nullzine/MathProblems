import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: nullzine
 * Date: 2014/02/11
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(new Execution(157,68,3));
    }
}

class Execution{

    private ArrayList<Combination> aList = new ArrayList<Combination>();
    private int xa,yb,comp;

    public Execution(int xa,int yb,int comp){
        this.xa=xa;
        this.yb=yb;
        this.comp=comp;
        calculation();
    }

    private void calculation(){
        for(int i=0;i<1000;i++){
            for(int j=0;j<1000;j++){
                if(xa*i-yb*j==comp){
                    aList.add(new Combination(i,j));
                }
            }
        }
    }

    public String toString(){
        String str = "";
        for(int i=0;i<aList.size();i++){
            str=str+aList.get(i).toString()+getCRLF();
        }
        return str;
    }

    private String getCRLF() {
        String str = "\n";
        try {
            str = System.getProperty("line.separator");
        } catch (SecurityException e) {
        }
        return str;
    }

}

class Combination{

    private int a,b;

    public Combination(int a,int b){
        this.a=a;
        this.b=b;
    }

    public String toString(){
        return "{"+Integer.toString(a)+":"+Integer.toString(b)+"}";
    }
}