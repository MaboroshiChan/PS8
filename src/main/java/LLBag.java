import java.util.Scanner;

public class LLBag implements Bag {
    private class Node {
        private Object item;
        private Node next;

        private Node(Object i, Node n) {
            this.item = i;
            this.next = n;
        }
    }


    private Node head;
    private int numItems;
    public LLBag() {
        head = null;
        numItems = 0;
    }

    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
        }
        head = new Node(item, head);
        numItems++;
        return true;
    }

    public boolean remove(Object item) {
        if (item == null) {
            return false;
        }
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.item.equals(item)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                numItems--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public boolean contains(Object item) {
        if (item == null) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public int numItems() {
        return numItems;
    }


    public Object grab() {
        if (numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        int whichOne = (int) (Math.random() * numItems);
        Node current = head;
        for (int i = 0; i < whichOne; i++) {
            current = current.next;
        }
        return current.item;
    }


    public Object[] toArray() {
        Object[] result = new Object[numItems];
        Node current = head;
        for (int i = 0; i < numItems; i++) {
            result[i] = current.item;
            current = current.next;
        }
        return result;
    }


    public String toString() {
        String sb = "{";
        Node current = head;
        while (current != null) {
            sb += current.item;
            if (current.next != null) {
                sb += ", ";
            }
            current = current.next;
        }
        sb += "}";
        return sb;
    }

    public static void main(String[] args) {
        LLBag lb = new LLBag();
        lb.add(1);
        lb.add(2);
        lb.add(3);

        for(int i = 0; i < lb.numItems() + 5; ++i) {
            System.out.println(lb.contains(i));
        }

        System.out.println(lb);
        for(int i = 0; i < 10; ++i) {
            System.out.println(lb.grab());
        }

        LLBag empty_bag = new LLBag();
        for(int i = 0; i < 5; ++i) {
            System.out.println("It should print nothing");
            System.out.println(empty_bag.contains(i));
        }

        System.out.println(lb);
        for(int i = 0; i < 10; ++i) {
            System.out.println("It should print nothing");
            System.out.println(empty_bag.grab());
        }
    }
    
}
