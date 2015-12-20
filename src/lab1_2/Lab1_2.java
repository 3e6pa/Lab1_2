/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_2;

import generics.*;

/**
 *
 * @author User
 */
public class Lab1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {

     
    JArrayListVector<Integer> test = new JArrayListVector(2);
    test.addLast(new Integer(19));
    test.addLast(new Integer(19));
    test.addLast(new Integer(19));
    test.show();
    }
}
