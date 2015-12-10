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

    /**
     * class fields must be private!
     *
     */
    protected double[] mas;
    private double[] buf; // bad practice. if we have 5 millions elements, your Vector will use memory for 10 millions elements.
    private int pos;

    public Vector(int size) {
        mas = new double[size];
        pos = -1;
    }

    public void addElement(double val) {
        if (pos + 1 == mas.length) { // look at this part of code
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
        if ((mas.length - pos) <= m.length) { // and this. This are similar code. you can optimize it.
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
        if ((mas.length - pos) <= m.mas.length) { // third piece of similar code
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

    public double getElement(int index) {// what will be if i ask element with larger index than array size?
        if (index > mas.length) {
            System.out.print("Out of range");
            return mas.length;
        } else {
            return mas[index];
        }
    }

    public int size() {
        return mas.length;
    }

    public double max() { // try this code with array {-10,-1,-100}
        int max = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > mas[max]) {
                max = i;
            }
        }
        return mas[max];
    }

    public double min() { // try this code with array { 1,2,3 }
        int min = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < mas[min]) {
                min = i;
            }
        }
        return mas[min];
    }

    public int maxPos() {
        int max = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > mas[max]) {
                max = i;
            }
        }
        return max;
    }

    public int minPos() {
        int min = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < mas[min]) {
                min = i;
            }
        }
        return min;
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

