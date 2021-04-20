package cn.shaoxiongdu;

/**
 * ClassName : LinkedQueue
 * (c)CopyRight 2021/4/20 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class LinkedQueue implements Queue{

    /**
     * 节点内部类
     */
    private class Node{

        /**
         * 数据
         */
        private Object elementData;

        /**
         * 下一节点地址
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
    }

    /**
     * 头节点引用
     */
    private Node front;

    /**
     * 尾节点引用
     */
    private Node rear;

    private int size;

    /**
     * 构造链表队列
     */
    public LinkedQueue() {
        front = new Node(null,null);
        rear = front;
    }

    @Override
    public void clear() {
        front.next = null;
        rear = front;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public Object getHead() {
        return front.next.elementData;
    }

    @Override
    public void enterObject(Object object) throws Exception {
        Node node = new Node(object, null);
        rear.next = node;
        size++;
        rear = rear.next;
    }

    @Override
    public Object deleteObject() throws Exception {
        if(front == rear) throw new Exception("栈已空");
        Node node = front.next;
        front.next = front.next.next;
        size--;
        if(node == rear){
            rear = front;
        }
        return node.elementData;
    }

    @Override
    public int size() {
        return size;
    }
}
