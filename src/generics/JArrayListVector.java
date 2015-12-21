/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author viks
 * @param <E>
 */
public class JArrayListVector<E> implements JVector {

    private E[] mas;
    private int pos;

    public JArrayListVector(int size) {
        mas = (E[]) new Object[size];
        pos = -1;
    }

    public JArrayListVector() {
        mas = (E[]) new Object[10];
        pos = -1;
    }
    
    public JArrayListVector(Object...value){
        mas = (E[]) new Object[value.length];
        pos = 0;
        for(Object x: value){
            mas[pos] = (E) x;
            pos++;
        }
    }

    @Override
    public void addLast(Object value) { //add element array
        if (pos + 1 == mas.length) {
            incArray(pos + 2);
        }
        mas[++pos] = (E) value;
    }

    @Override
    public void remove(int index) {
        if ((index >= 0) && (index <= mas.length - 1)) {
            bias(index, index);
        } else {
            System.out.println("Range of out array" + mas.length);
        }
    }

    protected void bias(int a, int b) {
        if (b != mas.length - 1) {
            for (int i = b + 1; i < mas.length; i++) {
                mas[i - (b - a) - 1] = mas[i];
            }
        }
        E[] buf = mas;
        mas = (E[]) new Object[mas.length - (b - a) - 1];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = buf[i];
        }
        pos = mas.length - 1;
    }

    @Override
    public void add(Object val, int index) { // add element array in index
        if ((index == mas.length) || (index < 0)) {
            System.out.println("Out of range");
        } else {
            incArray(mas.length + 1);
            int count = mas.length - index;
            for (int i = 0; i < count - 1; i++) {
                mas[mas.length - 1 - i] = mas[mas.length - 2 - i];
            }
            mas[index] = (E) val;
        }
    }

    @Override
    public int maxSize(JVector m, JVector n) {
        if (compare(m, n) == 0) {
            return m.size();
        } else {
            return n.size();
        }
    }

    public int compare(JVector m, JVector n) { // method for compare vectors
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
    public int minSize(JVector m, JVector n) {
        if (compare(m, n) == 0) {
            return n.size();
        } else {
            return m.size();
        }
    }

    @Override
    public Object getValue(int index) {
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
        E[] buf = (E[]) new Object[mas.length];
        for (int i = 0; i < mas.length; i++) {
            buf[i] = mas[i];
        }
        mas = (E[]) new Object[size];
        for (int i = 0; i < buf.length; i++) {
            mas[i] = buf[i];
        }
        buf = null;
    }

    @Override
    public void addArray(Object m[]) {
        if ((mas.length - pos) <= m.length) {
            incArray(mas.length + m.length);
        }
        int i;
        for (i = 0; i < m.length; i++) {
            mas[i + (pos + 1)] = (E) m[i];
        }
        pos = pos + i;
    }

    @Override
    public void addArray(JVector m) {
        if ((mas.length - pos) <= m.size()) {
            incArray(mas.length + m.size());
        }
        int i;
        for (i = 0; i < m.size(); i++) {
            mas[i + (pos + 1)] = (E) m.getValue(i);
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
        final JArrayListVector other = (JArrayListVector) m;
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
        JVector clon = new JArrayListVector();
        for (int i = 0; i < mas.length; i++) {
            clon.add(mas[i], i);
        }
        return clon;
    }
}
