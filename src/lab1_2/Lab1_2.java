/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_2;

import generics.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        Vector vect = new ArrayVector(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        try {
        FileOutputStream file = new FileOutputStream("vectByte.txt");
        Vectors.outputVector(vect, file);
        }catch (IOException e) {
            System.out.println("Error create file: "+e);
        }
        
       
        Vector vect1  ;
        
        try {
        FileInputStream vectByte = new FileInputStream("vectByte.txt");       
        vect1 = Vectors.inputVector(vectByte);
        vect1.show();
        }catch (IOException e) {
            System.out.println("Хрень какая то: "+e);
            
        }
        
        try{
        FileWriter file2 = new FileWriter("vectSymble.txt");
        Vectors.writeVector(vect, file2);
        }catch (IOException e) {
            System.out.println("Чет не то: "+e);     
        }
         Vector vect2  ;
        try {
        FileReader vectSymble= new FileReader("vectSymble.txt");       
        vect2 = Vectors.readVector(vectSymble);
        vect2.show();
        }catch (IOException e) {
            System.out.println("Хрень какая то: "+e);
            
        }
    }
}
