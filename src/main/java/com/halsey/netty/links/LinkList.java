package com.halsey.netty.links;

import lombok.Getter;
import lombok.Setter;

/**
 * create by zhangyaohai
 * 2018-03-01 15:17
 **/
public class LinkList <T extends Comparable<T>> {
    Node<T> head;
    Node<T> tail;

    public LinkList(){
        head = null;
    }

    class Node <T extends Comparable<T>> {
        public @Setter @Getter Node<T> nextNode;
        private @Setter @Getter T currentValue;
        public Node(T value){
            this.currentValue = value;
        }
    }

    public void add(T t){
        Node node = new Node(t);
        if(this.head == null){
            head = node;
            tail = null;
        }else {
            if(tail == null){
                tail = node;
                head.nextNode = tail;
            }else {
                tail.nextNode = node;
                tail = node;
            }
        }
    }

    public void reverse(){
        if(head == null){
            return;
        }else {
            Node<T> p,q,pr;
            p = head;
            q = null;
            while(p != null){
                pr = p.nextNode;
                p.nextNode = q;
                q = p;
                p = pr;
            }
            head = q;
        }
    }

    public void printLinks(){
        Node<T> node = head;
        while (node != null){
            System.out.println(node.getCurrentValue());
            node = node.nextNode;
        }
    }

    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList();
        linkList.add(1);
        linkList.add(5);
        linkList.add(7);
        linkList.add(8);
        linkList.add(9);
        linkList.printLinks();
        linkList.reverse();
        linkList.printLinks();
    }
}
