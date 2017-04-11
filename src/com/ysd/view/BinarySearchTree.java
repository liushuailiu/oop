package com.ysd.view;


/**
 * Created by FanLiYang on 2017/3/31.
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<? super T>>{
    private BinaryNode<T> root ; // 根节点
    public BinarySearchTree(){
        this.root = null ;
    }
    public void makeEmpty(){
        this.root = null ;
    }
    public boolean isEmpty(){
        return this.root == null ;
    }

    /**
     * 查询节点 X 是否在树 T 中
     * @param x 要查询的节点
     * @param t 要查询的树
     * @return 如果存在,返回 true , 否则 ,返回 false
     */
    private boolean contains(T x , BinaryNode<T> t){
        if(t == null)
            return false ;
        int compareResult = x.compareTo(t.element);
        if(compareResult<0)
            return contains(x,t.leftChild);
        else if (compareResult>0)
            return contains(x,t.rightChild);
        else
            return true ;
    }
    // 查询最小值
    private BinaryNode<T> findMin(BinaryNode<T> t){
        if(t == null)
            return null ;
        else if ( t.leftChild == null )
            return t ;
        return findMin(t.leftChild) ;
    }
    // 查询最大值
    private BinaryNode<T> findMax(BinaryNode<T> t){
        if(t != null)
            while (t.rightChild != null)
                t = t.rightChild ;
        return t ;
    }
    public class BinaryNode<T> {
        private T element ;
        BinaryNode<T> leftChild ;
        BinaryNode<T> rightChild ;

        public BinaryNode(T element, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
            this.element = element;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public BinaryNode(T element) {
            this(element,null,null);
        }
    }

}
