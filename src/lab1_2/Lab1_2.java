/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_2;

import vector.*;

/**
 *
 * @author User
 */
public class Lab1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayVector vect1 = new ArrayVector(10);
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        vect1.addArray(a);
        vect1.del(9);
        vect1.showArray();
        vect1.addElement(11, 5);
        vect1.showArray();
        vect1.addElement(100);
        vect1.showArray();
        ArrayVector vect2 = new ArrayVector(12);
        double[] b = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
        vect2.addElement(20);
        vect2.addElement(25);
        vect2.addElement(30);
        vect2.addArray(b);
        double scalar = Vectors.scalar(vect2, vect1);
        System.out.println("Scalar = "+scalar);
    }

}
