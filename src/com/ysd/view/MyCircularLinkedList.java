 package com.ysd.view;

 /**
 * Created by FanLiYang on 2017/4/9.
 * JAVA循环列表的实现
 */

public class MyCircularLinkedList<T> {
    private Node header ;
    private int size ;
    public MyCircularLinkedList() {
        doClear();
    }
    private void doClear(){
        header = null ;
        size = 0 ;
    }
    public int size(){
        return this.size;
    }

    public void add(T t){
        Node node = new Node(t);
        if(header==null){
            header = node ;
            header.next = header ;
        }else{
            Node nextNode = header.next ;
            while(nextNode.next!=header){
                nextNode = nextNode.next ;
            }
            nextNode.next = node ;
            node.next = header ;
        }
        this.size ++ ;
    }

    public T get(int index){
        Node node = header ;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return (T)node.data ;
    }


    public void remove(){
        Node node = header ;
        while(size()>=4){
            node = node.next.next ;
            Node food = node.next ;
            Node nextMouse = food.next ;

            if(food==header){
                header = nextMouse ;
            }

            node = node.next = nextMouse ;
            this.size-- ;
        }
    }

    private static class Node<T>{
        private T data ;
        private Node next ;
        public Node(T data) {
            this.data = data;
        }
    }

}
