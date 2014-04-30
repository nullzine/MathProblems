import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by nullzine on 2014/04/30.
 */
public class Main {
    public static void main(String[] args){
        //System.out.println(new StraightExecution().getMagicSquareList().length);
        new Execution().print();
    }
}

class Execution{

    private ArrayList<String> magicSquareList;

    public Execution(){
        magicSquareList = new ArrayList<>();
        new Permutation("123456789").getList().parallelStream().filter(i -> validationSquare(i)).forEach(e -> add(e));
    }

    private boolean validationSquare(String data){
        char[] strc = data.toCharArray();
        int[] tmp = new int[strc.length];
        for(int i=0;i<tmp.length;i++){
            tmp[i]=Integer.parseInt(strc[i]+"");
        }
        return (((tmp[0]+tmp[4]+tmp[8])==(tmp[2]+tmp[4]+tmp[6]))
                &&((tmp[0]+tmp[1]+tmp[2])==(tmp[3]+tmp[4]+tmp[5])&&(tmp[0]+tmp[1]+tmp[2])==(tmp[6]+tmp[7]+tmp[8]))
                &&((tmp[0]+tmp[3]+tmp[6])==(tmp[1]+tmp[4]+tmp[7])&&(tmp[0]+tmp[3]+tmp[6])==(tmp[2]+tmp[5]+tmp[8])));
    }

    /*
    012
    345
    678
     */

    synchronized private void add(String num){
        magicSquareList.add(num);
    }

    public int size(){
        return magicSquareList.size();
    }

    public void print(){
        for(int i=0;i<magicSquareList.size();i++){
            //System.out.println(magicSquareList.get(i));
            System.out.println(magicSquareList.get(i).substring(0,3)+"\n"+magicSquareList.get(i).substring(3,3+3)+"\n"+magicSquareList.get(i).substring(6,3+3+3)+"\n");
        }
    }


    class Permutation {

        private ArrayList<String> pattern;

        public Permutation(String str){
            pattern = calculation(str);
        }

        public ArrayList<String> getList(){
            return pattern;
        }

        public int size(){
            return pattern.size();
        }

        public void print(){
            for(int i=0;i<pattern.size();i++){
                System.out.println(pattern.get(i));
            }
        }

        private ArrayList<String> calculation(String str){
            if(str==null){
                return null;
            }
            ArrayList<String> permutations = new ArrayList<String>();
            if(str.length()==0){
                permutations.add("");
                return permutations;
            }
            char first = str.charAt(0);
            String reminder = str.substring(1);
            ArrayList<String> words = calculation(reminder);
            for(String word : words){
                for(int j=0;j<=word.length();j++){
                    String s = insertCharAt(word,first,j);
                    permutations.add(s);
                }
            }
            return permutations;
        }

        private String insertCharAt(String word,char c,int i){
            String start = word.substring(0,i);
            String end = word.substring(i);
            return start + c + end;
        }

    }

}

class StraightExecution{

    private int[] magicSquareList;

    public StraightExecution(){
        calculation();
    }

    private void calculation(){
        magicSquareList = IntStream.range(100000000, 999999999).parallel().filter(i -> numberFilter(i)).filter(j -> validationSquare(j)).toArray();
    }

    private boolean numberFilter(int n){
        String numStr = Integer.toString(n);
        if(numStr.indexOf('0')!=-1){
            return false;
        }else{
            for(int i=1;i<=9;i++){
                if(numStr.indexOf(Integer.toString(i))==-1){
                    return false;
                }
            }
            return true;
        }
    }

    private boolean validationSquare(int data){
        char[] strc = Integer.toString(data).toCharArray();
        return (getSum(strc[0],strc[1],strc[2])==getSum(strc[3],strc[4],strc[5])
                &&getSum(strc[0],strc[1],strc[2])==getSum(strc[6],strc[7],strc[8]))
                &&(getSum(strc[0],strc[3],strc[6])==getSum(strc[1],strc[4],strc[7])
                &&getSum(strc[0],strc[3],strc[6])==getSum(strc[2],strc[5],strc[8]))
                &&(getSum(strc[0],strc[4],strc[8])==getSum(strc[2],strc[4],strc[8]));
    }

    private int getSum(char a,char b,char c){
        return Integer.parseInt(a+"")+Integer.parseInt(b+"")+Integer.parseInt(c+"");
    }

    public int[] getMagicSquareList(){
        return magicSquareList;
    }


}