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
        if (pos + 1 == mas.length) {
            buf = new double[pos + 1];
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

    public void addArray(double m[]) {
        if ((mas.length - pos) <= m.length) {
            buf = new double[mas.length];
            for (int i = 0; i < mas.length; i++) {
                buf[i] = mas[i];
            }
            mas = new double[mas.length + m.length];
            for (int i = 0; i < this.pos + 1; i++) {
                mas[i] = buf[i];
            }
        }
        int i;
        for (i = 0; i < m.length; i++) {
            mas[i + (pos + 1)] = m[i];
        }
        pos = pos + i;
    }

    public void addArray(Vector m) {
        if ((mas.length - pos) <= m.mas.length) {
            buf = new double[mas.length];
            for (int i = 0; i < mas.length; i++) {
                buf[i] = mas[i];
            }
            mas = new double[mas.length + m.mas.length];
            for (int i = 0; i < this.pos + 1; i++) {
                mas[i] = buf[i];
            }
        }
        int i;
        for (i = 0; i < m.mas.length; i++) {
            mas[i + (pos + 1)] = m.mas[i];
        }
        pos = pos + i;
    }

    public int compare(Vector m) {
        if (mas.length == m.mas.length) {
            return 0;
        } else if (mas.length > m.mas.length) {
            return 1;
        } else {
            return 2;
        }
    }

    public void showArray() {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        /*   for (int i = 0; i < buf.length; i++) {
       *     System.out.print(buf[i] + " ");
        }*/
    }
}
