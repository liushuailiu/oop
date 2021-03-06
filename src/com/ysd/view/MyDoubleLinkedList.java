package com.ysd.view;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by FanLiYang on 2017/3/31.
 * JAVA实现双链表
 */

public class MyDoubleLinkedList<T> {
     // 链表的开端
     private Node<T> beginMarker ;
     // 链表的结束
     private Node<T> endMarker ;
     // 链表的长度
     private int size ;
     private int modCount = 0 ;

     public void set(int index , T t){
         Node<T> node = getNode(index);
         node.data = t ;
     }

    /**
     * 删除节点
     * @param p
     */
     public void remove(Node<T> p){

         // 2-3-4 , 将3删除,
         // 3的上一个(2)的下一个为4
         p.prev.next = p.next ;
         // 3的下一个(4)的上一个为 2
         p.next.prev = p.prev ;
         this.size -- ;
         modCount ++ ;
     }

     public void remove(int index){
         remove(getNode(index));
     }

    public int size(){
        return this.size;
    }

    public void clear(){
        doClear();
    }

    public MyDoubleLinkedList() {
        doClear();
    }
    // 初始化链表
    private void doClear() {
        // 开始节点
        beginMarker = new Node<T>(null,null,null);
        // 结束节点的上一个是开始节点
        endMarker = new Node<T>(beginMarker,null,null);
        // 开始节点的下一个是结束节点
        beginMarker.next = endMarker ;
        // 初始化长度为0
        this.size = 0 ;
        modCount ++ ;
    }

    public void add(T t ){
        addBefore(t,getNode(size()));
    }

    public void add(T t , int index){
        addBefore(t,getNode(index));
    }

    /**
     *
     * @param t 要插入的数据
     * @param node 被往后挤的节点
     */
    private void addBefore(T t , Node<T> node){
        // 要插入的数据升级为节点
        Node<T> newNode = new Node<T>(node.prev,
                node,t);
        // 将 5 插入到 2-3  之间
        // 3的上一个(其实为2)的下一个是 5
        node.prev.next = newNode ;
        // 3的上一个是5
        node.prev = newNode ;
        this.size ++ ;
        modCount ++ ;
    }
    public T get(int index){
        return getNode(index).data ;
    }
    private Node<T> getNode(int index){
        return getNode(index,0,size());
    }

    /**
     *
     * @param index 指定节点的下标
     * @param lower 0
     * @param upper 链表的长度
     * @return 节点
     */
    private Node<T> getNode(int index ,int lower
            , int upper){
        Node<T> node ;
        // 如果下标不在链表范围之内,抛出异常
        if(index<lower || index>upper)
            throw new IndexOutOfBoundsException();
        // 如果下标更接近头部
        if(index<size()/2){
            node = beginMarker.next ;
            for (int i = 0; i < index; i++) {
                node = node.next ;
            }
        // 如果下标更接近尾部
        }else{
            node = endMarker ;
            for (int i = size(); i > index ; i--) {
                node = node.prev ;
            }
        }
        return node ;
    }
    // 节点类
    private static class Node<T>{
         private Node prev ; // 上一个节点
         private Node next ; // 下一个节点
         private T data ;    // 本身数据源
         // 构造函数
         public Node(Node prev, Node next, T data) {
             this.prev = prev;
             this.next = next;
             this.data = data;
         }
     }
     private class LinkedListIterator implements Iterator<T>{

        private Node<T> current = beginMarker.next ;
        private int expectedModCount = modCount ;
        private boolean okToRemove = false ;

         @Override
         public boolean hasNext() {
             return current != endMarker ;
         }

         @Override
         public T next() {
             if(modCount != expectedModCount)
                 throw new ConcurrentModificationException();
             if(!hasNext())
                 throw new NoSuchElementException();
             T nextItem = current.data ;
             current = current.next ;
             okToRemove = true ;
             return nextItem ;
         }

         @Override
         public void remove() {
            if(modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            MyDoubleLinkedList.this.remove(current.prev);
            expectedModCount ++ ;
            okToRemove = false ;
         }
     }
}
