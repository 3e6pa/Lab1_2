/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_2;

import vectors.Vectors;
import vectors.Vector;
import vectors.LinkedListVector;
import vectors.ArrayVector;

/**
 *
 * @author User
 */
public class Lab1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {

     
     System.out.println("add value = 0.0, index = 5 ");
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double value = 0.5;
        int index = 8;
        Vector instance = new ArrayVector();
        instance.addArray(m);
        instance.show();
        int size = instance.size();
        instance.addLast(value);
        instance.show();
        System.out.println(" size = "+size+" instance.size = "+instance.size());
      //  System.out.println("instance.getValue(0) = "+ instance.getValue(0)+ ", value = " +value);
    }
}
