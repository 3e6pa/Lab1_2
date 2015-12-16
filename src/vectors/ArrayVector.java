/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

/**
 *
 * @author User
 */
public class ArrayVector implements Vector{

    private double[] mas;
    private int pos;

    public ArrayVector(int size) {
        mas = new double[size];
        pos = -1;
    }

    @Override
    public void addLast(double value) { //add element array
        if (pos + 1 == mas.length) {
            incArray(pos + 2);
        }
        mas[++pos] = value;
    }

    @Override
    public void remove( int index) {
        if ((index >= 0) && (index <= mas.length-1)) {
            bias(index, index);
        } else {
            System.out.println("Range of out array" + mas.length);
        }
    }

    public void del(int begin, int end) {
        if ((begin >= 0) && (end <= mas.length-1) && (end >= begin)) {
            bias(begin, end);
        } else {
            System.out.println("Range of out array" + mas.length + " or not correct begin and end");
        }
    }

    protected void bias(int a, int b) {
        if (b != mas.length-1) {
            for (int i = b+1 ; i < mas.length; i++) {
                mas[i-(b-a)-1] = mas[i];
            }
        }
        double[] buf = mas;
        mas = new double [mas.length - (b-a)-1];
        for (int i = 0; i < mas.length ; i++) {
            mas[i] = buf[i];
        }
        pos = mas.length-1;
    }

    @Override
    public void add(double val, int index) { // add element array in index
        if (index > mas.length) {
            incArray(index);
        }
        mas[index] = val;
    }

    @Override
    public int maxSize(Vector m, Vector n ) {
        if (compare(m, n) == 0) {
            return m.size();
        } else {
            return n.size();
        }
    }
    
    

    @Override
    public int compare(Vector m, Vector n) { // method for compare vectors
        if (n.size() <= m.size()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int size() { // for length array
        return mas.length;
    }

    @Override
    public int minSize(Vector m, Vector n) {
        if (compare(m, n) == 0) {
            return n.size();
        } else {
            return m.size();
        }
    }

    @Override
    public double getValue(int index) {
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

    @Override
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

    public void addArray(Vector m) {
        if ((mas.length - pos) <= m.size()) {
            incArray(mas.length + m.size());
        }
        int i;
        for (i = 0; i < m.size(); i++) {
            mas[i + (pos + 1)] = m.getValue(i);
        }
        pos = pos + i;
    }

    @Override
    public void show() {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        /*   for (int i = 0; i < buf.length; i++) {
       *     System.out.print(buf[i] + " ");
        }*/
    }

    
}