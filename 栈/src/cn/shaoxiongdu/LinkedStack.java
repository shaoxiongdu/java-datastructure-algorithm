package cn.shaoxiongdu;

import java.util.Objects;

/**
 * ClassName : LinkedStack
 * (c)CopyRight 2021/4/19 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 *    用非连续存储结构(链表)实现栈数据结构
 */
public class LinkedStack implements Stack{

    /**
     * 内部节点类
     */
    private class Node{

        /**
         * 数据
         */
        private Object elementData;

        /**
         * 下一个节点引用
         */
        private Node next;

        public Node() {
        }

        public Node(Object elementData, Node next) {
            this.elementData = elementData;
            this.next = next;
        }

        public Object getElementData() {
            return elementData;
        }

        public void setElementData(Object elementData) {
            this.elementData = elementData;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(elementData, node.elementData) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(elementData, next);
        }
    }

    /**
     * 头节点
     */
    private Node headNode;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 默认空省构造函数
     */
    public LinkedStack() {
        headNode = new Node(null,null);
        size = 0;
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        headNode = null;
    }

    /**
     * 清空栈
     */
    @Override
    public void clear() {
        headNode.elementData = null;
        headNode.next = null;
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean empty() {
        return size == 0;
    }

    /**
     * 获取顶层元素
     * @return
     * @throws Exception 若栈被销毁或者栈为空,则抛出此异常
     */
    @Override
    public Object getTop() throws Exception {
        if(headNode == null) throw new Exception("栈被销毁");
        if(size == 0) throw new Exception("栈为空");
        Node temp = headNode;
        while (temp.next!=null){
            temp = temp.next;
        }
        return temp.elementData;
    }

    @Override
    public void push(Object object) {
        Node node = new Node(object, null);
        Node temp = headNode;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    /**
     * 弹出最顶层的元素
     * @return
     * @throws Exception 若栈被销毁或者栈为空,则抛出此异常
     */
    @Override
    public Object pop() throws Exception {
        if(headNode == null) throw new Exception("栈被销毁");
        if(size == 0) throw new Exception("栈为空");
        Node temp = headNode;

        while (temp.next.next!=null){
            temp = temp.next;
        }
        Object elementData = temp.next.elementData;
        temp.next = null;
        size--;
        return elementData;

    }

    @Override
    public int size() {
        return size;
    }
}
