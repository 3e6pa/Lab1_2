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
public class ArrayVector {

    private double[] mas;
    private int pos;

    public ArrayVector(int size) {
        mas = new double[size];
        pos = -1;
    }

    public void addElement(double val) { //add element array
        if (pos + 1 == mas.length) {
            incArray(pos + 2);
        }
        mas[++pos] = val;
    }

    public void del( int index) {
        if ((index >= 0) && (index <= mas.length)) {
            bias(index, index);
        } else {
            System.out.println("Range of out array" + mas.length);
        }
    }

    public void del(int begin, int end) {
        if ((begin >= 0) && (end <= mas.length) && (end >= begin)) {
            bias(begin, end);
        } else {
            System.out.println("Range of out array" + mas.length + " or not correct begin and end");
        }
    }

    protected void bias(int a, int b) {
        if (b != mas.length) {
            for (int i = b ; i < mas.length; i++) {
                mas[i-(b-a)] = mas[i];
            }
        }
        pos = 0;
        double[] buf = new double[mas.length - (b-a)];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = mas[i];;
        }
        mas = new double[buf.length];
        for (int i = 0; i < buf.length; i++) {
            mas[i] = buf[i];;
        }
        buf = null;
    }

    public void addElement(double val, int index) { // add element array in index
        if (index > mas.length) {
            incArray(index);
        }
        mas[index] = val;
    }

    public int maxSize(ArrayVector m) {
        if (compare(m) == 0) {
            return m.size();
        } else {
            return mas.length;
        }
    }

    public int compare(ArrayVector m) { // method for compare vectors
        if (mas.length <= m.size()) {
            return 0;
        } else {
            return 1;
        }
    }

    public int size() { // for length array
        return mas.length;
    }

    public int minSize(ArrayVector m) {
        if (compare(m) == 0) {
            return mas.length;
        } else {
            return m.size();
        }
    }

    public double getElement(int index) {
        if (index > mas.length) {
            System.out.print("Out of range, last element");
            return mas[mas.length - 1];
        } else if (index < 0) {
            System.out.print("Out of range, first element");
            return mas[0];
        } else {
            return mas[index];
        }
    }

    private void incArray(int size) { // method for increase array
        double[] buf = new double[mas.length];
        for (int i = 0; i < mas.length; i++) {
            buf[i] = mas[i];
        }
        mas = new double[size];
        for (int i = 0; i < buf.length; i++) {
            mas[i] = buf[i];
        }
        buf = new double[0];
    }

    public void addArray(double m[]) {
        if ((mas.length - pos) <= m.length) {
            incArray(mas.length + m.length);
        }
        int i;
        for (i = 0; i < m.length; i++) {
            mas[i + (pos + 1)] = m[i];
        }
        pos = pos + i;
    }

    public void addArray(ArrayVector m) {
        if ((mas.length - pos) <= m.size()) {
            incArray(mas.length + m.size());
        }
        int i;
        for (i = 0; i < m.size(); i++) {
            mas[i + (pos + 1)] = m.getElement(i);
        }
        pos = pos + i;
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
