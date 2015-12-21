package vectors;

import java.util.Iterator;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author viks
 */
public class LinkedListVector implements Vector {

    Link head;
    int length;

    public LinkedListVector() {
        head = null;
        length = 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    class Link {

        Link next;
        Link prev;
        double value;

        Link(Link next, Link prev, double value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        Link() {
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    @Override
    public void addArray(double m[]) {
        int z = 0;
        if (head == null) {
            addLast(m[0]);
            z++;
        }
        for (int i = z; i < m.length; i++) {
            addLast(m[i]);
        }
    }
    
     @Override
    public String toString() {
        return "LinkedListVector{" + "head = " + head.value + ", length = " + length + '}';
    }

    @Override
    public void addArray(Vector m) {
        int z = 0;
        if (head == null) {
            addLast(m.getValue(z));
            z++;
        }
        for (int i = z; i < m.size(); i++) {
            addLast(m.getValue(i));
           
        }
    }

    public void addFirst(double value) { 
        if (head == null){
            Link e = new Link();
            e.setValue(value);
            head = e;
            head.next = head.prev = e;
            length++;
        } else {
        Link temp = head;
        Link e = new Link(temp, temp.prev, value); //next, prev
        head = e;
        e.next.prev = e;
        e.prev.next = e;
        }
    }
    
    @Override
    public void show() {
        Link temp = head;
        for (int i = 0; i < length; i++) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public void addLast(double value) {
        Link e = new Link();
        e.setValue(value);
        if (head == null) {
            head = e;
            head.next = head.prev = e;
            length++;
        } else {
            head.prev.next = e;
            e.prev = head.prev;
            e.next = head;
            e.next.prev = e;
            length++;
        }
    }

    @Override
    public void add(double value, int index) {
        if ((index < 1) || (index > length)) {
            System.out.println("Out fo range");
        } else {
            Link temp = head.prev;
            for (int i = 0; i < index ; i++) {
                temp = temp.next;
            }
            Link e = new Link(temp.next, temp, value); // next, prew
            e.prev.next = e;
            e.next.prev = e;
            length++;
        }
    }

    

    @Override
    public double getValue(int index) {
        if ((index < 0) || (index > length)) {
            System.out.println("Out fo range");
            return 0;
        } else {
            double value = 0;
            Link temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            value = temp.value;
           // System.out.println("Method getValue: value = "+ value + " index = "+index);
            return value;
        }
    }

    public void removeLast() {
        Link temp = head.prev.prev;
        head.prev = temp;
        head.prev.next = head;
        length--;
    }

    @Override
    public void remove(int index) {
        if ((index < 1) || (index > length)) {
            System.out.println("Out fo range, use E.removeFirst() or E.removeLast()");
        } else {
            Link temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            length--;
        }
    }

    public void removeFirst() {
        Link temp = head.next;
        head.prev.next = temp;
        head = temp;
        length--;
    }

    @Override
    public int size() {
        return length;
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
    public int minSize(Vector m, Vector n) {
        if (compare(m, n) == 0) {
            return n.size();
        } else {
            return m.size();
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
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.head);
        hash = 17 * hash + this.length;
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
        final LinkedListVector other = (LinkedListVector) m;
        if (this.length != other.length) {
            return false;
        }
        Link temp1 = this.head;
        Link temp2 = other.head;
        for (int i = 0; i < this.length; i++) {
            if (!Objects.equals(temp1, temp2)) {
                return false;
            }
            temp1 = this.head.next;
            temp2 = other.head.next;
        }
        temp1 = null;
        temp2 = null;
        return true;
    }

    @Override
    public Object clone()  {
        LinkedListVector clon = new LinkedListVector();
        for (int i = 0; i < this.size(); i++) {
            clon.addLast(this.getValue(i));
        }
        return clon;
    }

}
