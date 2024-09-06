package mylinkedlist;

import java.util.LinkedList;

import mylinkedlist.Node;

public class MyLinkedList extends Node {
    private Node head;
    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public void add(int data, int index){
        Node newNode = new Node(data);
        if(index == 0){
            addFirst(data);
            return;
        } else { 
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
        }
    }
    // BTVN: Viet code cho cac ham sau
    // 1. public int length()
    // 2. public void display()
    // 3. public void deleteFirst()


    public int length(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println("");
    }
    public void deleteFirst(){
        Node newNode = new Node();
        if(head == null){
            head = newNode;
        } else {
            head = head.next;
        }
    }
        //BTVN3 : 
        //viet code ham sort tăng dần
        public void sort(){
            if(head == null|| head.next == null){
                return;
            }
            Node current = head;
            Node index = null;
            int temp;
            while(current != null){
                index = current.next;
                while(index != null){
                    if(current.data > index.data){
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
                }
            // viet code xoa phan tu tai vi tri index theo vong while, dùng count++
        public Node DeletePosition(int index){
            Node temp = head;
            int count = 0;
            while(temp != null && count < index){
              count++;
              head= head.next;
            } 
            return head;
        }
    
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
       linkedList.addFirst(1);
       linkedList.addFirst(2);
       linkedList.addFirst(3);
        //3->2->1
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        //4->5->6
        linkedList.display();
        System.out.println("Chieu dai cua chuoi la: " + linkedList.length());
        linkedList.deleteFirst();
        System.out.println("Sau khi xoa truoc la: ");
        linkedList.display();
        System.out.println("Danh sách sau khi sap xep tang dan la: ");
        linkedList.sort();
        linkedList.display();
        linkedList.DeletePosition(2);
        System.out.println("Danh sach sau khi xoa tai index 2 la: ");
        linkedList.display();
     }
    }

