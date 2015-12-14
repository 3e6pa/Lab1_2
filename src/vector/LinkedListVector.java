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
public class LinkedListVector {

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

        public Link getNext() {
            return next;
        }

        public void setNext(Link next) {
            this.next = next;
        }

        public Link getPrev() {
            return prev;
        }

        public void setPrev(Link prev) {
            this.prev = prev;
        }

        public double getValue() {
            return value;
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

    public void add(double value, int index) {
        if ((index > 0) && (index < length)) {
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

    public void showList() {
        Link temp = head;
        for (int i = 0; i < length; i++) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

}
