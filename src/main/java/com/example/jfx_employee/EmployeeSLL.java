package com.example.jfx_employee;

public class EmployeeSLL {
    public class Node{
        Employee value;
        Node next;

        public Node(Employee value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    Node head;
    public EmployeeSLL(Node head) {
        this.head=head;
    }

    public void insert(Node newEmployee, Node pred){
        if(pred==null) {
            newEmployee.next = head;
            head = newEmployee;
        }else {
            newEmployee.next=pred.next;
            pred.next=newEmployee;
        }
    }

    public void delete(Node node){
        Node pre=head;
        while(pre.next!=node){
            pre=pre.next;
        }
        pre.next=node.next;
    }
}
