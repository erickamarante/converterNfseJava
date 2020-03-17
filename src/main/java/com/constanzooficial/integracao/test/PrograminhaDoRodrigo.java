package com.constanzooficial.integracao.test;

import java.util.Scanner;

/**
 *
 * @author Yuri Fernandes de Oliveira
 */
public class PrograminhaDoRodrigo {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("RA: ");
        double ra = s.nextDouble();
        System.out.print("RB: ");
        double rb = s.nextDouble();

        double c = 10 * Math.pow(10, -9);

        //double th = 0.693 * c * (ra + rb);
        double th = 0.693 * c * ra;
        double tl = 0.693 * rb * c;
        double t = th + tl;
        double f = 1 / t;
        //double dc = th/tl;
        double dc = (th / (th + tl)) * 100;

        System.out.println("TH: " + th);
        System.out.println("TL: " + tl);
        System.out.println("D: " + dc);
        System.out.println("T: " + t);
        System.out.println("f: " + f);
    }

}
