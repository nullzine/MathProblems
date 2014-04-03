import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: nullzine
 * Date: 2014/02/11
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(new BigInteger("2").pow(1001).remainder(new BigInteger("100")).toString());
    }
}


/*

2^1001を100で割った値を求めよ

answer:52

*/