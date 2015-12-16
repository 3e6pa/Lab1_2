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
    public static void main(String[] args) throws  CloneNotSupportedException {
        Vector vect1 = new ArrayVector(10);
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        vect1.addArray(a);
        vect1.show();

        Vector vectList1 = new LinkedListVector();
        vectList1.addArray(a);
        vectList1.show();

        double scalar = Vectors.scalar(vectList1, vect1);
        System.out.println("Scalar = " + scalar);

        Vector sum = Vectors.sumVetors(vect1, vectList1);
        sum.show();

        //test
        System.out.println("List 0 = " + vectList1.getValue(0));
        System.out.println("List 9 = " + vectList1.getValue(9));
        //test

        StringBuffer str = new StringBuffer(vectList1.toString());
        System.out.println(str);
        
        Vector vectList2 = new LinkedListVector();
        vectList2 = (Vector) vectList1.clone();

        if (vectList1.equals(vectList2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
        Vector vect2 = new ArrayVector();
        vect2 = (Vector) vect1.clone();

        if (vect1.equals(vect2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        vect1.addLast(scalar);
        vect2.show();
        vectList2.show();

    }
}
