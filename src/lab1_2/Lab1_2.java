/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_2;

import generics.*;
import vectors.*;

/**
 *
 * @author User
 */
public class Lab1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JArrayListVector<Integer> test = new JArrayListVector(2);
        test.addLast(new Integer(19));
        test.addLast(new Integer(19));
        test.addLast(new Integer(19));
        test.show();

        JVector<String> test2 = new JLinkedListVector();
        test2.addLast("lol");
        test2.show();

        Vector vectList = new ArrayVector(2);
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        vectList.addArray(a);
        vectList.show();
        
        Vector vectList1 = new LinkedListVector();
        vectList1.addArray(a);
        vectList1.show();
       
        
        for(double x : vectList){
            System.out.print(x+" ");
        }
        System.out.println();
        
        for(double x : vectList1){
            System.out.print(x+" ");
        }
        System.out.println();
        Vector vectList2 = new ArrayVector(1,2,3,4,5,6,7,8,9);
        vectList2.show();
        
        Vector vectList3 = new LinkedListVector(10,11,12,13,14,15,16,17,18,19);
        vectList3.show();
        
        JArrayListVector<Integer> vectList4 = new JArrayListVector(2,4,6,8,10,12,14,16,18,20);
        vectList4.show();
        
        JVector<String> vectList5 = new JLinkedListVector("Кто ","Cказал ", "Что?");
        vectList5.show();
    }
}
