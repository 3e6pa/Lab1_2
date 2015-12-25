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
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import vectors.*;

/**
 *
 * @author User
 */
public class Lab1_2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayVector vect = new ArrayVector(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
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
        
        LinkedListVector vectL = new LinkedListVector(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        System.out.println("*************Serialization**********(in file)");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vectObject.obj"));
        out.writeObject(vect);
        out.writeObject(vectL);
        out.close();
        
        try {
        System.out.println("*************Serialization**********(from file)");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("vectObject.obj"));
        ArrayVector myVector1 = (ArrayVector)in.readObject();
        LinkedListVector myVector2 = (LinkedListVector)in.readObject();
        myVector1.show();
        myVector2.show();
        } catch (InvalidObjectException e){
             System.out.println("Ваш object инвалид: "+e);
        }
        java.util.Vector<Double> test = new java.util.Vector<Double>();
        
        
        JVectorAdapter myAdapter = new JVectorAdapter (test);
        myAdapter.addLast(11);
        myAdapter.addLast(22);
        myAdapter.addLast(33);
        myAdapter.addLast(44);
        myAdapter.add(0, 2);
        myAdapter.show();
        
        Vector testProtect = new ProtectedVector(myAdapter);
        
        testProtect.addLast(2525);
        testProtect.show();
        myAdapter.addLast(55);
        testProtect.show();
    }
}
