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

     
        System.out.println("clone");
        Vector clon = new LinkedListVector();
        Vector etalon = new LinkedListVector();
        double[] a = {1,2,3,4,5,6,7,8,9};
        etalon.addArray(a);
        Object  result = etalon.clone();
        clon = (LinkedListVector) result;
        clon.show();
        
        etalon.add(105, 5);
        clon.show();
        
      //  System.out.println("instance.getValue(0) = "+ instance.getValue(0)+ ", value = " +value);
    }
}
