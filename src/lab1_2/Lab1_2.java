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
    public static void main(String[] args) {
        Vector vect1 = new ArrayVector(10);
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        vect1.addArray(a);
        vect1.show();
        
        Vector vectList = new LinkedListVector();
        vectList.addArray(a);
        vectList.show();

        double scalar = Vectors.scalar(vectList, vect1);
        System.out.println("Scalar = " + scalar);

        Vector sum = Vectors.sumVetors(vect1, vectList);
        sum.show();
        
        
        //test
        System.out.println("List 0 = " + vectList.getValue(0));
        System.out.println("List 9 = " + vectList.getValue(9));
        
        StringBuffer str = new StringBuffer(vectList.toString());
        System.out.println(str);


        
    }
}
