package cn.shaoxiongdu;

import java.io.NotActiveException;

/**
 * ClassName : LinkedList
 * (c)CopyRight 2021/4/13 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class LinkedList implements List{

    /**
     * 链表节点内部类
     */
    private class Node{

        /**
         * 当前索引
         */
        private int index;

        /**
         * 数据元素
         */
        private Object elementData;

        /**
         * 下一节点引用
         */
        private Node nextNode;

        /**
         * 带参构造
         * @param index 当前索引
         * @param elementData 数据元素
         * @param nextNode 下一节点引用
         */
        public Node(int index, Object elementData, Node nextNode) {
            this.index = index;
            this.elementData = elementData;
            this.nextNode = nextNode;
        }

        public Node() {
            this.nextNode = null;
            this.elementData = null;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Object getElementData() {
            return elementData;
        }

        public void setElementData(Object elementData) {
            this.elementData = elementData;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

    /**
     * 头节点
     */
    private Node headNode;

    /**
     * 当前元素个数
     */
    private int size;

    public LinkedList() {
        this.headNode = new Node(0,null,null);
        this.size = 0;
    }

    @Override
    public void print() {
        System.out.println("------------------------------");
        for (Node temp = headNode;temp.nextNode!=null;temp=temp.nextNode){
            System.out.println(temp.nextNode.getElementData());
        }
        System.out.println("------------------------------");
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void clear() {
        headNode.nextNode = null;
        size=0;
    }

    /**
     * 通过下标获取元素
     * @param index
     * @return  如果下标错误 返回NULL
     * @throws Exception 下标小于0或者大于元素个数 抛出此异常
     */
    @Override
    public Object get(int index) throws Exception {
        if(index <= 0 || index > size) throw new Exception("下标错误");
        Node temp = headNode;
        while (true){
            if(temp == null){
                return null;
            }
            if(temp.index == index){
                return temp.elementData;
            }
            temp = temp.nextNode;
        }
    }

    /**
     * 通过元素获取位置
     * @param object
     * @return 若元素为NULL或者未找到 则返回-1
     */
    @Override
    public int findIndexByObject(Object object) {
        if(object == null) return -1;
        Node temp = headNode;
        while (true){
            if(temp == null){
                return -1;
            }
            if(object.equals(temp.elementData)){
                return temp.index;
            }
            temp = temp.nextNode;
        }

    }

    /**
     * 将指定元素插入到指定位置之前 长度加一
     * @param index 指定位置
     * @param object 指定元素
     * @return 返回插入的元素 如果下标不存在,则返回NULL
     * @throws Exception 如果下标小于0  则抛出此异常
     */
    @Override
    public Object insert(int index, Object object) throws Exception {
        if( index < 0 ) throw new Exception("下标错误");
        Node temp = headNode;
        for (int i = 0; i < index-1 && temp.nextNode!=null; i++) {
            temp = temp.nextNode;
        }
        /**
         * 如果不存在该节点,则返回NULL
         */
        if( temp == null) return null;

        Node node = new Node(index, object, temp.nextNode);
        temp.nextNode = node;
        for (Node node1 = node.nextNode;node1!=null;node1=node1.nextNode) {
            node1.setIndex(node1.getIndex()+1);
        }

        size++;
        return node.elementData;

    }

    /**
     * 通过下标删除元素
     * @param index 指定位置
     * @return
     * @throws Exception 下标错误抛出此异常
     */
    @Override
    public Object delete(int index) throws Exception {
        if(index < 0 || index > size) throw new Exception("下标错误");
        Node temp = headNode,deleteNode = null;
        while (true){
            if(temp == null){
                return null;
            }
            if(temp.nextNode.index == index){
                deleteNode = temp.nextNode;
                temp.nextNode = temp.nextNode.nextNode;
                for(temp=temp.nextNode;temp!=null;temp=temp.nextNode){
                    temp.setIndex(temp.getIndex()-1);
                }

                size--;
                return deleteNode;
            }
            temp = temp.nextNode;
        }
    }

    @Override
    public Object insert(Object object) throws Exception {
        if(object == null) return null;
        Node temp = headNode;
        while (true){
            if(temp.nextNode == null){
                Node node = new Node(temp.index + 1, object, null);
                temp.nextNode = node;
                size++;
                return temp.nextNode.getElementData();
            }
            temp = temp.nextNode;

        }
    }

    @Override
    public int size() {
        return this.size;
    }
}
