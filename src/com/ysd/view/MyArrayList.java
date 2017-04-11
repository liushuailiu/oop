package com.ysd.view;

import java.util.Iterator;

/**
 * Created by FanLiYang on 2017/4/8.
 * 利用数组实现简单链表(ArrayList的内部实现其实就是顺序表)
 */
public class MyArrayList<T> implements Iterable<T> {
    // 初始数组的长度
    private static final int DEFAULT_CAPACITY = 10 ;
    // 集合的长度
    private int size ;
    private T [] items ;

    public int size(){
        return this.size ;
    }

    public void clear(){
        doClear();
    }

    public void add(T t){
        add(size(),t);
    }

    // 通过下标添加元素
    public void add(int index, T t) {
        // 如果数组已经装满 , 那么开辟一个新的数组
        if(items.length==size())
            ensureCapacity(size() * 2 + 1);
        for (int i = this.size ; i > index ; i--)
            items[i] = items[i-1];
        items[index] = t ;
        this.size ++ ;
    }

    public void remove(int index){
        T t = items[index];
        for (int i = index ; i < size()-1 ; i++) {
            items[i] = items[i+1] ;
        }
        this.size -- ;
    }

    public T get(int index){
        if(index<0||index>=size())
            throw new IndexOutOfBoundsException();
        return items[index];
    }

    public boolean isEmpty(){
        return this.size()==0 ;
    }

    // 将老数组重新赋值给一个新的数组
    private void ensureCapacity(int newCapacity){
        if(newCapacity<size)
            return;
        T  [] old = items ;
        items = (T[]) new Object[newCapacity];
        for (int i = 0; i < size() ; i++) {
            items[i] = old[i];
        }
    }

    // 集合的初始化
    public void doClear(){
        this.size = 0 ;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public MyArrayList() {
        doClear();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * 内部类 , 实现了Iterator迭代器
     */
    private class ArrayListIterator implements Iterator<T>{
        private int current =  0 ;
        @Override
        public boolean hasNext() {
            return current < size() ;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new IndexOutOfBoundsException();
            return items[current++] ;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
