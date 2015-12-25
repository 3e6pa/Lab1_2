/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.Writer;
import vectors.Vector;
import vectors.ArrayVector;

/**
 *
 * @author User
 */
public class Vectors {
    
    public static VectorFactory vectorFactory = new ArrayVectorFactory();
    public static void setVectorFactory(VectorFactory factory){
        vectorFactory = factory;
    }
    
    public static Vector createInstance(int size){
        return vectorFactory.newVector(size);
    }

    public static Vector sumVetors(Vector m, Vector n) {
        Vector vect = createInstance(maxSize(m, n));
        Vector buf1 = createInstance(maxSize(m, n));
        Vector buf2 = createInstance(maxSize(m, n));
        buf1.addArray(n);
        buf2.addArray(m);
        for (int i = 0; i < maxSize(n, m); i++) {
            vect.add((buf1.getValue(i) + buf2.getValue(i)), i);
        }
        buf1 = null;
        buf2 = null;
        return vect;

    }
    
    public static void outputVector(Vector m, OutputStream out){
        try {
        DataOutputStream streamOut = new DataOutputStream(out);
        streamOut.writeInt(m.size());
      //  m.show();
        for (double val : m){
           //System.out.print(val+" ");
           streamOut.writeDouble(val);
        }
        streamOut.close();
        } catch (IOException e){
            System.out.println("Error file: "+e);
        }
    }
    
    public static Vector inputVector(InputStream in) throws IOException{
     
        Vector result;
        try (DataInputStream streamIn = new DataInputStream(in)) {
            int size = streamIn.readInt();
            result = new ArrayVector(/*streamIn.readInt()*/);
          //  System.out.println(streamIn.readInt());
          
            for (int i = 0; i<size; i++){
                result.add(streamIn.readDouble(), i);
                //System.out.println(result.getValue(i));
                        
            }
            streamIn.close();
            }
        
        return result;
    }
    
    public static void writeVector(Vector m, Writer out){
        PrintWriter output = new PrintWriter( new BufferedWriter(out));
        for (double val : m){
            output.print(val+" ");
        }
        output.close();
    }
    
    public static Vector readVector(Reader in) throws IOException{
        
        BufferedReader bufRead = new BufferedReader(in);
        StreamTokenizer token = new StreamTokenizer(bufRead);     
        Vector buf = new LinkedListVector();
        while (token.nextToken() != token.TT_EOF){
             buf.addLast(token.nval);
        }
        Vector vect = new ArrayVector();
        for (double val : buf){
            vect.addLast(val);
        }
        return vect;
    }
    

    public static double scalar(Vector m, Vector n) {
        Vector buf = createInstance(maxSize(m, n));
        for (int i = 0; i < minSize(m, n); i++) {
            buf.add(n.getValue(i) * m.getValue(i), i);
        }
        if (maxSize(m, n) == n.size()) {
            for (int i = 0; i < maxSize(m, n) - minSize(m, n); i++) {
                buf.add(n.getValue(i + minSize(m, n)), i + minSize(m, n));
            }
        } else {
            for (int i = 0; i < maxSize(m, n) - minSize(m, n); i++) {
                buf.add(m.getValue(i + minSize(m, n)), i + minSize(m, n));
            }
        }
        double scalar = 0;
        for (int i = 0; i < maxSize(m, n); i++) {
            scalar = buf.getValue(i) + scalar;
        }
        buf = null;
        return scalar;
    }
    
    public static Vector rundom(int size, double min, double max ){
        Vector vect = createInstance(size);
        for (int i = 0; i<size; i++){
            vect.addLast(min + (int)(Math.random() * ((max - min) + 1))); // int, caz so good look it
        }
        return (Vector) vect;
    }
    
    public static void mul(Vector m, double val){
         for (int i = 0; i < m.size(); i++) {
            m.add((m.getValue(i))*val, i);
        }
    }
    
     public static int compare(Vector m, Vector n) { // method for compare vectors
        if (m.size() < n.size()) {
            return 1;
        } else  if (m.size() > n.size()){
            return 2;
        } else return 0;
    }
     
     public static int minSize(Vector m, Vector n) {
        if (compare(m, n) == 0) {
            return n.size();
        } else {
            return m.size();
        }
    }
     
     public static int maxSize(Vector m, Vector n ) {
        if (compare(m, n) == 0) {
            return m.size();
        } else {
            return n.size();
        }
    }

}
