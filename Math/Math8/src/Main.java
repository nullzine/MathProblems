import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nullzine
 * Date: 2014/03/29
 * Time: 8:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){

    }
}

class Calculation{

    private int limit;
    private Triangle[] tri;
    private ArrayList<Triangle> answerList;

    public Calculation(int limit){
        this.limit=limit;
        tri = new Triangle[(int)Math.pow(limit,3)];
        answerList = new ArrayList<Triangle>();
        calc();
    }

    private void calc(){

    }

}

class Point{

    private int x;
    private int y;

    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}

class Triangle{

    private int a;
    private int b;
    private int c;

    public Triangle(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

}

class Side{

    public Side(int a,int b){

    }

}

/*

x,y平面においてx座標y座標ともに整数であるような点を格子点と呼ぶ。
格子点に頂点を持つ三角形ABCを考える
辺AB,ACそれぞれの上に両端を除いて奇数個の格子点があるとすると
辺BC上にも両端を除いて奇数個の格子点があることを示せ

*/