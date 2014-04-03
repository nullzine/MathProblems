/**
 * Created with IntelliJ IDEA.
 * User: nullzine
 * Date: 2014/02/11
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(new Execution(6).getAnswer());
    }
}

class Execution{

    private int answer;

    public Execution(int num){
        int limit = makeNum(num);
        answer = calculation(limit);
    }

    private int calculation(int limit){
        for(int i=limit;i<limit*10;i++){
            if(validPalindromic(i)&&i%95==0){
                if(validPalindromic(i/95)){
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean validPalindromic(int num){
        char[] strc = Integer.toString(num).toCharArray();
        for(int i=0;i<strc.length/2;i++){
            if(!(strc[i] ==strc[strc.length-1-i])){
                return false;
            }
        }
        return true;
    }

    private int makeNum(int num){
        String str = "1";
        for(int i=1;i<num;i++){
            str=str+"0";
        }
        return Integer.parseInt(str);
    }

    public int getAnswer(){
        return answer;
    }

}

/*

6桁の回文数で95で割れ、割ったあとの数字も回文数となるものを求めなさい

answer:527725

*/