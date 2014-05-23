import java.math.BigInteger;
import java.util.ArrayList;
 
/**
 * Created by Develop on 14/02/17.
 */
public class Main {
    public static void main(String[] args){
        new Execution(100).print();
    }
}
 
class Execution{
 
    private FiboData fd;
    ArrayList<String> aList;
 
    public Execution(int limit){
        aList = new ArrayList<String>();
        fd = new FiboData(limit);
        calculation();
    }
 
    private void calculation(){
        for(int i=0;i<fd.getData().length;i++){
            if(validOwnDiv(fd.getData()[i])){
                aList.add(fd.getData()[i].toString()+"%"+bigIntegerSum(fd.getData()[i])+"==0");
            }
        }
    }
 
    private boolean validOwnDiv(BigInteger bi){
        int sum = bigIntegerSum(bi);
        if(bi.remainder(new BigInteger(Integer.toString(sum))).equals(BigInteger.ZERO)){
            return true;
        }else{
            return false;
        }
    }
 
    private int bigIntegerSum(BigInteger bi){
        char[] strc = bi.toString().toCharArray();
        int sum=0;
        for(int i=0;i<strc.length;i++){
            sum+=Integer.parseInt(strc[i]+"");
        }
        return sum;
    }
 
    public void print(){
        for(int i=0;i<aList.size();i++){
            System.out.println(aList.get(i));
        }
    }
 
}
 
class FiboData{
 
    private BigInteger[] data;
 
    public FiboData(int limit){
        data = new BigInteger[limit];
        calculation(limit);
    }
 
    private void calculation(int limit){
        data[0]=BigInteger.ONE;
        data[1]=BigInteger.ONE;
        for(int i=2;i<data.length;i++){
            data[i]=data[i-1].add(data[i-2]);
        }
    }
 
    public BigInteger[] getData(){
        return data;
    }
 
    public void print(){
        for(int i=0;i<data.length;i++){
            System.out.println(data[i].toString());
        }
    }
 
}
 
/*
 
フィボナッチ数列のうち、各桁の数字を足した数で割り切れる数を求めよ
 
 */
