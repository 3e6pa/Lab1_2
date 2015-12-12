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
class Vectors {

    public static ArrayVector sumVetors(ArrayVector m, ArrayVector n) {
        ArrayVector vect = new ArrayVector(m.maxSize(n));
        ArrayVector buf1 = new ArrayVector(m.maxSize(m));
        ArrayVector buf2 = new ArrayVector(m.maxSize(m));
        buf1.addArray(n);
        buf2.addArray(m);
        for (int i = 0; i < n.maxSize(m); i++) {
            vect.addElement((buf1.getElement(i) + buf2.getElement(i)), i);
        }
        buf1 = null;
        buf2 = null;
        return vect;

    }

    public static double scalar(ArrayVector m, ArrayVector n) {
        ArrayVector buf = new ArrayVector(n.maxSize(m));
        for (int i = 0; i < n.minSize(m); i++) {
            buf.addElement(n.getElement(i) * m.getElement(i), i);
        }
        if (n.maxSize(m) == n.size()) {
            for (int i = 0; i < n.maxSize(m) - n.minSize(m); i++) {
                buf.addElement(n.getElement(i + n.minSize(m)), i + n.minSize(m));
            }
        } else {
            for (int i = 0; i < n.maxSize(m) - n.minSize(m); i++) {
                buf.addElement(m.getElement(i + n.minSize(m)), i + n.minSize(m));
            }
        }
        double scalar = 0;
        for (int i = 0; i < n.maxSize(m); i++) {
            scalar = buf.getElement(i) + scalar;
        }
        buf = null;
        return scalar;
    }
    
    public static void mul(ArrayVector m, double val){
         for (int i = 0; i < m.size(); i++) {
            m.addElement((m.getElement(i))*val, i);
        }
    }
    
     public static int compare(ArrayVector m, ArrayVector n) { // method for compare vectors
        if (m.size() < n.size()) {
            return 1;
        } else  if (m.size() > n.size()){
            return 2;
        } else return 0;
    }

}
