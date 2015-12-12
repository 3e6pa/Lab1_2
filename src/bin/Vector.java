/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

/**
 *
 * @author User
 */
 class Vector {

    private double[] mas;
    private int pos;

    public Vector(int size) { //Constructor
        mas = new double[size];
        pos = -1;
    }

    public void addElement(double val) { //add element array
        if (pos + 1 == mas.length) {
            incArray(pos + 2);
        }
        mas[++pos] = val;
    }

    public void addElement(double val, int index) { // add element array in index
        if (index > mas.length) {
            incArray(index);
        }
        mas[index] = val;
    }

    public void addArray(double m[]) { // add in array from other array
        if ((mas.length - pos) <= m.length) {
            incArray(mas.length + m.length);
        }
        int i;
        for (i = 0; i < m.length; i++) {
            mas[i + (pos + 1)] = m[i];
        }
        pos = pos + i;
    }

    public void addArray(Vector m) { //add in array from other method
        if ((mas.length - pos) <= m.mas.length) {
            incArray(mas.length + m.size());
        }
        int i;
        for (i = 0; i < m.mas.length; i++) {
            mas[i + (pos + 1)] = m.mas[i];
        }
        pos = pos + i;
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

    public int compare(Vector m) { // method for compare vectors
        if (mas.length <= m.mas.length) {
            return 0;
        } else {
            return 1;
        }
    }

    public double getElement(int index) { // method for access to element
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

    public int size() { // for length array
        return mas.length;
    }

    public int maxSize(Vector m) {
        if (compare(m) == 0) {
            return m.size();
        } else {
            return mas.length;
        }
    }

    public int minSize(Vector m) {
        if (compare(m) == 0) {
            return mas.length;
        } else {
            return m.size();
        }
    }

    public double max() {
        int max = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > mas[max]) {
                max = i;
            }
        }
        return mas[max];
    }

    public double min() {
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

    public void mul(double val) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = mas[i] * val;
        }
    }

    public Vector sum(Vector m) throws Throwable {
        Vector result = new Vector(maxSize(m));
        Vector buf1 = new Vector(maxSize(m));
        Vector buf2 = new Vector(maxSize(m));
        buf1.addArray(mas);
        buf2.addArray(m);
        for (int i = 0; i < maxSize(m); i++) {
            result.addElement((buf1.getElement(i) + buf2.getElement(i)), i);
        }
        buf1 = null;
        buf2 = null;
        return result;

    }

    public double scalar(Vector m) throws Throwable {
        Vector buf = new Vector(maxSize(m));
        for (int i = 0; i < minSize(m); i++) {
            buf.addElement(mas[i] * m.getElement(i), i);
        }
        if (maxSize(m) == mas.length) {
            for (int i = 0; i < maxSize(m) - minSize(m); i++) {
                buf.addElement(mas[i + minSize(m)], i + minSize(m));
            }
        } else {
            for (int i = 0; i < maxSize(m) - minSize(m); i++) {
                buf.addElement(m.getElement(i + minSize(m)), i + minSize(m));
            }
        }
        double scalar = 0;
        for (int i = 0; i < maxSize(m); i++) {
            scalar = buf.getElement(i) + scalar;
        }
        buf.finalize();
        return scalar;
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
