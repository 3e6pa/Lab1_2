package vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author viks
 */
public class LinkedListVector implements Vector{

    Link head;
    int length;

    public LinkedListVector() {
        head = null;
        length = 0;
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

    public void addFirst(double value) {
        Link temp = head;
        Link e = new Link(temp, temp.prev, value); //next, prev
        head = e;
        e.next.prev = e;
        e.prev.next = e;
        length++;
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
            Link temp = head;
            for (int i = 0; i < index - 2; i++) {
                temp = temp.next;
            }
            Link e = new Link(temp.next, temp, value); // next, prew
            e.prev.next = e;
            e.next.prev = e;
            length++;
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
    public double getValue(int index) {
        if ((index < 0) || (index > length)) {
            System.out.println("Out fo range");
            return 0;
        } else {
            double value = 0;
            Link temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            value = temp.value;
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
        if ((index < 2) || (index > length)) {
            System.out.println("Out fo range, use E.removeFirst() or E.removeLast()");
        } else {
            Link temp = head;
            for (int i = 0; i < index - 1; i++) {
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

}
