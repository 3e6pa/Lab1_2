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
        Vector vect1 = new Vector(2);
        vect1.addElement(-10);
        vect1.addElement(-1);
        vect1.addElement(-100);
        vect1.showArray();

        double[] a = {5, 2, 3};
        Vector vect2 = new Vector(10);
        vect2.addArray(a);
        vect2.addArray(a);
        vect2.addArray(a);
        vect2.addArray(vect1);
        vect2.showArray();
        
        if (vect1.compare(vect2) == 0) {
            System.out.println("vectors are equals");
        } else if (vect1.compare(vect2) == 1){
            System.out.println("vector1 a lot than vector2");
        } else if (vect1.compare(vect2) == 2){
            System.out.println("vector1 a less than vector2");
        }
        double d = vect1.getElement(1);
        System.out.println("1 = "+d);
        
        int size = vect2.size();
        System.out.println("Size vector2 = "+size);
        
        double max = vect2.max();
        System.out.println("Max value vector2 = "+max);
        
        double min = vect2.min();
        System.out.println("Min value vector2 = "+min);
        
        double newMax = vect2.getElement(vect2.maxPos());
        System.out.println("Max value vector2 from pos = "+newMax);
        
        double newMin = vect2.getElement(vect2.minPos());
        System.out.println("Min value vector2 from pos = "+newMin);
        
        VectorsUtil.sort(vect2);
        vect2.showArray();
        
        vect1.mul(10);
        vect1.showArray();
        
       /* Vector vectorsSum = new Vector(10);
        vectorsSum = vect1.sum(vect2);*/
       
       double scalar = vect1.scalar(vect2);
    }

}
