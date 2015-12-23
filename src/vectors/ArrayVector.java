/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

import java.io.DataInputStream;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class ArrayVector implements Vector {

 
    private double[] mas;
    private int pos;
    int index = 0 ;

    public ArrayVector(int size) {
        mas = new double[size];
        pos = -1;

    }

    public ArrayVector() {
        mas = new double[1];
        pos = -1;

    }
    
    public ArrayVector(double...value){
        pos = 0;
        mas = new double[value.length];
        for(double x : value){
            mas[pos] = x;
            pos++;
        }
    }


    
    

    @Override
    public void addLast(double value) { //add element array
        if (pos + 1 == mas.length) {
            incArray(pos + 2);
        }
        mas[++pos] = value;
    }

    @Override
    public void remove(int index) {
        if ((index >= 0) && (index <= mas.length - 1)) {
            bias(index, index);
        } else {
            System.out.println("Range of out array" + mas.length);
        }
    }

    public void del(int begin, int end) {
        if ((begin >= 0) && (end <= mas.length - 1) && (end >= begin)) {
            bias(begin, end);
        } else {
            System.out.println("Range of out array" + mas.length + " or not correct begin and end");
        }
    }

    protected void bias(int a, int b) {
        if (b != mas.length - 1) {
            for (int i = b + 1; i < mas.length; i++) {
                mas[i - (b - a) - 1] = mas[i];
            }
        }
        double[] buf = mas;
        mas = new double[mas.length - (b - a) - 1];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = buf[i];
        }
        pos = mas.length - 1;
    }

    @Override
    public void add(double val, int index) { // add element array in index
        if ((index == mas.length) || (index < 0)) {
            System.out.println("Out of range");
        } else {
            incArray(mas.length + 1);
            int count = mas.length - index;
            for (int i = 0; i < count - 1; i++) {
                mas[mas.length - 1 - i] = mas[mas.length - 2 - i];
            }
            mas[index] = val;
        }
    }

    @Override
    public int maxSize(Vector m, Vector n) {
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

    @Override
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

    @Override
    public String toString() {
        return "ArrayVector{" + "mas=" + mas + ", pos=" + pos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Arrays.hashCode(this.mas);
        hash = 37 * hash + this.pos;
        return hash;
    }

    @Override
    public boolean equals(Object m) {
        if (this == m) {
            return true;
        }
        if (m == null) {
            return false;
        }
        if (getClass() != m.getClass()) {
            return false;
        }
        final ArrayVector other = (ArrayVector) m;
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < this.mas.length; i++) {
            if (this.getValue(i) != other.getValue(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object clone() {
        Vector clon = new ArrayVector();
        for (int i = 0; i < mas.length; i++) {
            clon.add(mas[i], i);
        }
        return clon;
    }

    @Override
    public Iterator iterator() {
      index = 0 ;
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return index != mas.length;
            }

            @Override
            public Object next() {  
                return getValue(index++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }

}
