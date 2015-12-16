/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;

/**
 *
 * @author User
 */
public class Vectors {

    public static Vector sumVetors(Vector m, Vector n) {
        Vector vect = new ArrayVector(maxSize(m, n));
        Vector buf1 = new ArrayVector(maxSize(m, n));
        Vector buf2 = new ArrayVector(maxSize(m, n));
        buf1.addArray(n);
        buf2.addArray(m);
        for (int i = 0; i < maxSize(n, m); i++) {
            vect.add((buf1.getValue(i) + buf2.getValue(i)), i);
        }
        buf1 = null;
        buf2 = null;
        return vect;

    }

    public static double scalar(Vector m, Vector n) {
        Vector buf = new ArrayVector(maxSize(m, n));
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
