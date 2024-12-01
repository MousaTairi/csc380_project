package csc380Project;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> current;
    public int size = 0;

    public LinkedList() {
        head = current = null;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current != null && current.next == null;
    }

    public boolean full() {
        return false;
    }

    public void findFirst() {
        current = head;
    }

    public void findNext() {
        if (current != null) {
            current = current.next;
        }
    }

    public T retrieve() {
        return current != null ? current.data : null;
    }

    public void update(T e) {
        if (current != null) {
            current.data = e;
        }
    }

    public boolean insert(T e) {
        if (empty()) {
            current = head = new Node<T>(e);
        } else {
            if (find(e)) {
                return false; // Duplicate entry, don't insert
            }
            // Move current to the last node
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<T>(e);
        }
        size++;
        return true;
    }

    public boolean find(T e) {
        Node<T> n = head;
        while (n != null) {
            if (n.data.equals(e)) {
                current = n; // Point to the found node
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public boolean remove(T e) {
        if (!find(e)) {
            return false; // Element not found
        }

        if (head != null && head.data.equals(e)) { // Removing the head
            head = head.next;
            size--;
            return true;
        }

        Node<T> prev = null;
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(e)) {
                if (prev != null) {
                    prev.next = temp.next; // Skip the node to remove
                }
                size--;
                return true;
            }
            prev = temp;
            temp = temp.next;
        }
        return false;
    }
}
