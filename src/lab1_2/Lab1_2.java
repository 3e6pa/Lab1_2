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
        vect1.remove(9);
        vect1.show();
        vect1.add(11, 5);
        vect1.show();
        vect1.addLast(100);
        vect1.show();
        ArrayVector vect2 = new ArrayVector(12);
        double[] b = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
        vect2.addLast(20);
        vect2.addLast(25);
        vect2.addLast(30);
        vect2.addArray(b);
        double scalar = Vectors.scalar(vect2, vect1);
        System.out.println("Scalar = " + scalar);

        LinkedListVector vectList = new LinkedListVector();
        vectList.addLast(5);
        vectList.addLast(6);
        vectList.addLast(7);
        vectList.addLast(8);
        vectList.addLast(9);
        vectList.add(25, 3);
        vectList.addFirst(101);
        vectList.addLast(36);
        vectList.add(45, 4);
        vectList.show();
        double val = vectList.getValue(9);
        System.out.println("Element 4 = " + val);
        System.out.println("size vectList = " + vectList.size());
        vectList.removeLast();
        vectList.show();
        System.out.println("size vectList = " + vectList.size());
        vectList.removeLast();
        vectList.show();
        System.out.println("size vectList = " + vectList.size());
        vectList.addLast(229);
        System.out.println("size vectList = " + vectList.size());
        vectList.show();
        vectList.remove(1);
        System.out.println("size vectList ago remove= " + vectList.size());
        vectList.addLast(8);
        System.out.println("size vectList = " + vectList.size());
        vectList.addLast(9);
        vectList.addLast(9);
         vectList.show();
        vectList.removeFirst();
        vectList.show();
    }

}
