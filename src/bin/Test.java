/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import java.util.Scanner;

/**
 *
 * @author viktor
 */
public class Test {

    public static void main(String[] args) {
        String ss = " 52.0 97.0 3.0 50.0 44.0 85.0 26.0 68.0 3.0 94.0  ";
        String s;
           s = ss.replace(".", ",");
 
       System.out.println(s);
       Scanner scanner = new Scanner(s);
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                System.out.println(scanner.nextDouble()+" 0");
            } else {
                scanner.next();
            }
        }
    }
}
