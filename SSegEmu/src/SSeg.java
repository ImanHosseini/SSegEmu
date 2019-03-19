import Lib.StdDraw;

import java.util.Scanner;

/**
 * Created by ImanH on 3/16/2019.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class SSeg {
    /*
    ZERO is ON
    ---A---
    |     |
    F     B
    |     |
    ---G---
    |     |
    E     C
    |     |
    ---D---
    SIZE PARAMETERS
        ---- ... L ... ----
       /   H               \
       ----- ..     .. ------
    Display Layout
     */
    public boolean[] gfedcba = new boolean[]{false,false,false,false,false,false,false};
    static double L = 0.4;
    static double H = 0.05;
    static final double[] horx = new double[]{-L/2,-L/2+H/2,L/2-H/2,L/2,L/2-H/2,-L/2+H/2};
    static final double[] hory = new double[]{0,-H/2,-H/2,0,H/2,H/2};
    static final double[] xorgs = new double[]{0.5,0.3,0.3,0.5,0.7,0.7,0.5};
    static final double[] yorgs = new double[]{0.5,0.7,0.3,0.1,0.3,0.7,0.9};
    static final boolean[] pegHors = new boolean[]{true,false,false,true,false,false,true};
    public void drawDisp(){
            StdDraw.clear();
            for(int i=0;i<7;i++){
                drawPeg(xorgs[i],yorgs[i],pegHors[i],!gfedcba[i]);
            }
    }
    public static void main(String[] args){
        StdDraw.setCanvasSize(600,600);
        SSeg sseg = new SSeg();
//        StdDraw.setXscale(0.0,4.0);
//        StdDraw.setYscale(0.0,4.0);
        sseg.gfedcba[3] = true;
        sseg.drawDisp();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        StdDraw.filledCircle(0.5,0.5,0.8);
    }

    public void setFromHex(String hex){
        int num = Integer.parseInt(hex, 16);
        // System.out.println(num);
        int i=6;
        while(num>0){
            // System.out.println(num%2+"***"+num/2);
            gfedcba[i] = num%2!=0;
            i--;
            num = num/2;
        }
        for(int j=i;j>=0;j--){
            gfedcba[j] = false;
        }
    }

    public void drawPeg(double x_origin,double y_origin,boolean hor,boolean filled){
        StdDraw.setPenColor(StdDraw.RED);
        double[] xs = new double[6];
        double[] ys = new double[6];
        for(int i=0;i<6;i++){
            if(hor){
                xs[i] = x_origin + horx[i];
                ys[i] = y_origin + hory[i];
            }else{
                xs[i] = x_origin + hory[i];
                ys[i] = y_origin + horx[i];
            }

        }

            if(filled){
                StdDraw.filledPolygon(xs,ys);
            }else{
                StdDraw.polygon(xs,ys);
            }


    }

}
