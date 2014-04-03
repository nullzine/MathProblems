import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nullzine
 * Date: 2014/02/11
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(new Execution(21,13).toString());
    }
}

class Execution{

    private Prime prime;
    private ArrayList<DataSet> aList = new ArrayList<DataSet>();
    private int numSize;
    private int primeSize;

    public Execution(int numSize,int primeSize){
        this.numSize=numSize;
        this.primeSize=primeSize;
        prime = new Prime(primeSize);
        calculation();
    }

    private void calculation(){
        for(int i=2;i<100000;i++){
            if(validProb(i)){
                aList.add(new DataSet(i,numSize,primeSize));
            }
        }
    }

    private boolean validProb(int num){
        for(int i=num;i<num+numSize;i++){
            for(int j=0;j<prime.getList().size();j++){
                if(i%prime.getList().get(j)==0){
                    break;
                }
                if(j==prime.getList().size()-1){
                    return false;
                }
            }
        }
        return true;
    }

    public String toString(){
        String str = "";
        for(int i=0;i<aList.size();i++){
            str=str+aList.get(i).toString()+getCRLF();
        }
        str=str+validExistString();
        return str;
    }

    private String validExistString(){
        if(validExist()){
            return "存在する";
        }else{
            return "存在しない";
        }
    }

    private boolean validExist(){
        return aList.size()!=0;
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

class Prime{

    ArrayList<Integer> aList = new ArrayList<Integer>();

    public Prime(int primeLimit){
        makeList(primeLimit);
    }

    private void makeList(int limit){
        for(int i=1;i<=limit;i++){
            int count=0;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    count++;
                }
                if(count==3){
                    break;
                }
            }
            if(count==2){
                aList.add(i);
            }
        }
    }

    public ArrayList<Integer> getList(){
        return aList;
    }

}

class DataSet{

    private int num;
    private String[] answerList;
    private Prime prime;

    public DataSet(int num,int numSize,int primeSize){
        prime = new Prime(primeSize);
        answerList = new String[numSize];
        this.num=num;
        makeList(numSize);
    }

    private void makeList(int numSize){
        int count=0;
        for(int i=num;i<num+numSize;i++){
            for(int j=0;j<prime.getList().size();j++){
                if(i%prime.getList().get(j)==0){
                    answerList[count]=Integer.toString(i)+":TRUE";
                    break;
                }
                if(j==prime.getList().size()-1){
                    answerList[count]=Integer.toString(i)+":FALSE";
                    break;
                }
            }
            count++;
        }
    }

    public String toString(){
        String str = Integer.toString(num)+":{"+answerList[0];
        for(int i=1;i<answerList.length;i++){
            str=str+" "+answerList[i];
        }
        str=str+"}";
        return str;
    }

}

/*

21個の連続した自然数であって、どの数も13以下の一個以上の素数で割り切れるものは存在するか

answer:存在する

*/