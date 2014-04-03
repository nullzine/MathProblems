import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by labuser on 2014/04/03.
 */
public class Main {
    public static void main(String[] args){
        HashMap<String,String> definitionMap = new HashMap<String,String>();
        definitionMap.put("0","1");
        definitionMap.put("1","10");
        new Execution(1,definitionMap,13).print();
    }
}

class Execution{

    private HashMap<String,String> map;
    private String[] dataSet;

    public Execution(int seed,HashMap<String,String> map,int limit){
        this.map=map;
        dataSet = new String[limit];
        dataSet[0] = Integer.toString(seed);
        calculation();
    }

    private void calculation(){
        for(int i=1;i<dataSet.length;i++){
            dataSet[i] = genStr(dataSet[i-1]);
        }
    }

    private String genStr(String str){
        String tmp = "";
        StringBuilder sb = new StringBuilder();
        char[] strc = str.toCharArray();
        for(int i=0;i<strc.length;i++){
            sb.append(map.get(strc[i]+""));
        }
        return sb.toString();
    }

    public void print(){
        for(int i=0;i<dataSet.length;i++){
            System.out.println(dataSet[i]+":"+analysis(dataSet[i]));
        }
    }

    private int analysis(String str){
        Pattern p = Pattern.compile("01");
        Matcher m = p.matcher(str);
        int count = 0;
        int s = 0;
        while (m.find(s)) {
            count++;
            s = m.end();
        }
        return count;
    }

}

/*

各桁の数字が1か0であるような自然数の数列Xnを考える
X1=1
Xnの各桁の数字が0ならば1で置き換え、1ならば10で置き換える
このような置き換えを行っていき、得られる自然数をXn+1とする
最初の五項を書くと
X1=1;
X2=10;
X3=101;
X4=10110;
X5=10110101;
Xnの中に01という数字の配列が現れる回数を求めよ

 */