import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: nullzine
 * Date: 2014/03/29
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(new BigInteger("3").pow(2001).toString().substring(new BigInteger("3").pow(2001).toString().length()-5));
    }
}

//3^2001の10進数での下位5桁を求めよ