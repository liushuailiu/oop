package com.ysd.tree;

/**
 * Created by fanliyang on 17-5-15.
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<? super T>>{

    private BinaryNode<T> root ; //根节点

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null ;
    }

    //判断二叉树 t 中是否含有节点 x

    private boolean contains(T x , BinaryNode<T> t){
        if (t==null)
            return false;
       return false ;
    }

    private static class BinaryNode<T>{

        T element ;
        BinaryNode<T> left ;
        BinaryNode<T> right ;

        public BinaryNode(T theElement) {
            this(theElement,null,null);
        }

        public BinaryNode(T theElement,BinaryNode<T> it ,BinaryNode<T> rt) {
            element = theElement ;
            left = it ;
            right = rt ;
        }
    }


}
