import java.math.BigDecimal;
import java.util.ArrayList;
 
/**
 * Created by Develop on 14/02/12.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(new Execution(81,1995).toString());
    }
}
 
class Execution{
 
    private ArrayList<DataSet> aList = new ArrayList<DataSet>();
 
    public Execution(int target,int comp){
        calculation(target,comp,1000);
    }
 
    private void calculation(int target,int comp,int limit){
        for(int i=1;i<=limit;i++){
            String str = new BigDecimal(Integer.toString(target)).divide(new BigDecimal(Integer.toString(i)),100,BigDecimal.ROUND_HALF_UP).toString();
            if(str.indexOf(Integer.toString(comp))!=-1){
                aList.add(new DataSet(target,i));
            }
        }
    }
 
    public String toString(){
        String str = "";
        for(int i=0;i<aList.size();i++){
            str=str+aList.get(i).toString()+getCRLF();
        }
        str=str+"Answer:"+Integer.toString(aList.get(0).getNum());
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
 
class DataSet{
 
    private int target;
    private int num;
    private BigDecimal bd;
 
    public DataSet(int target,int num){
        this.target=target;
        this.num=num;
        bd = new BigDecimal(Integer.toString(target)).divide(new BigDecimal(Integer.toString(num)),20,BigDecimal.ROUND_HALF_UP);
    }
 
    public String toString(){
        return Integer.toString(target)+":"+Integer.toString(num)+" "+bd.toString().substring(0,20);
    }
 
    public int getNum(){
        return num;
    }
 
}
 
/*
 
81をある整数で割り算すると、小数部分のどこかに「1995」という数字が出てきます。
このような正の整数のうち最小のものを答えなさい。
 
answer:401
 
 */
