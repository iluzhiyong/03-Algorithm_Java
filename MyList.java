
public class MyList {

    private static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }

    }

    private Node head;
    private Node last;
    private int size;

    public Node get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" 超出链表节点范围! ");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(" 超出链表节点范围! ");
        }

        Node insertedNode = new Node(data);
        if (size == 0) {
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            insertedNode.next = head;
            head = insertedNode;
        } else if (size == index) {
            last.next = insertedNode;
            last = insertedNode;
        } else {
            Node prevNode = get(index - 1);
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size++;
    }

    public Node remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(" 超出链表节点范围! ");
        }

        Node removedNode = null;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            Node prevNode = get(index - 1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("My List");
        MyList myList = new MyList();
        myList.insert(3, 0);
        myList.insert(7, 1);
        myList.insert(9, 2);
        myList.insert(5, 3);
        myList.insert(6, 1);
        myList.remove(0);
        myList.output();
    }
}