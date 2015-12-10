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
public class Vector {

    double[] mas;
    double[] buf;
    int pos;

    public Vector(int size) {
        mas = new double[size];
        pos = -1;
    }

    public void addElement(double val) {
        if (pos+1 == mas.length) {
            buf = new double[pos+1];
            for (int i = 0; i < mas.length; i++) {
                buf[i] = mas[i];
            }
            mas = new double[pos + 2];
            for (int i = 0; i < buf.length; i++) {
                mas[i] = buf[i];
            }
        }
        mas[++pos] = val;
    }

    public void showArray() {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
     /*   for (int i = 0; i < buf.length; i++) {
       *     System.out.print(buf[i] + " ");
        }*/
    }
}
