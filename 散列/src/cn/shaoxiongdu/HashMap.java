package cn.shaoxiongdu;

import java.io.Serializable;
import java.util.Objects;

/**
 * ClassName : HashMap
 * (c)CopyRight 2021/4/21 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 * @author Shaoxiong
 */
public class HashMap implements Serializable {

    /**
     * HashMap  内部节点类
     */
    private class Node{

        /**
         * 节点的哈希值
         */
        private int hash;

        /**
         * 节点KEY
         */
        private Object key;

        /**
         * 节点value
         */
        private Object value;

        /**
         * 下一节点的引用
         */
        private Node next;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        public Object getKey() {
            return key;
        }


        public Object getValue() {
            return value;
        }

        public Object setValue(Object newValue) {
            Object oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        public Node(int hash, Object key, Object value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }



    }

    private static final long serialVersionUID = 1L;

    /**
     * 默认初始容量 16
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 最大容量 2^30 = 1,073,741,824
     */
    private static final int MAX_CAPACITY = 1 << 30;

    /**
     * 默认负载因子 当当前元素个数达到容量的此倍数时,进行扩容
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 默认扩大倍数 2
     */
    static final int DEFAULT_EXPAND_MULTIPLE = 1 << 1;

    /**
     * 数组
     */
    private Node [] table;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 加载因子
     */
    private float loadFactor;

    /**
     * 已经占用的数组个数
     */
    private int countOfOccupiedArrays = 0;

    /**
     * key-value 数目
     */
    private int size;

    /**
     * 使用默认数据创建散列表
     */
    public HashMap() throws Exception {
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity) throws Exception {
        this(capacity,DEFAULT_LOAD_FACTOR);
    }

    /**
     * 使用指定数据创建散列表
     * @param initialCapacity 初始化容量
     * @param loadFactor 加载因子
     * @throws Exception 如果参数不合法,抛出此异常
     */
    public HashMap(int initialCapacity,float loadFactor) throws Exception {
        if( initialCapacity <= 0 ) {
            throw new Exception("初始化容量异常:" + initialCapacity);
        }
        if(loadFactor <= 0 || loadFactor >= 1 ) {
            throw new Exception("初始化负载因子异常" + loadFactor);
        }
        /**
         * 若初始化容量大于默认的最大容量 则置为最大容量
         */
        if(initialCapacity >= MAX_CAPACITY) {
            initialCapacity = MAX_CAPACITY;
        }
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        table = new Node[initialCapacity];
    }


    /**
     * 返回此Map中的Key-value映射条数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入方法
     * @param key
     * @param value
     * @return 返回插入的value 如果key重复 则插入新值 返回旧值
     */
    public Object put(Object key,Object value){

        int hash = key.hashCode();

        int index =  getIndexForHash(hash);

        Node node = new Node(hash,key,value,null);

        /**
         * 当当前占用的数组个数达到数组长度的扩容因子时 扩大默认倍数
         */
        if((countOfOccupiedArrays*1.0) / table.length > loadFactor){

            /**
             * 扩大默认倍数
             */
            expansion(DEFAULT_EXPAND_MULTIPLE);
        }
        /**
         * 如果该下标存在节点
         */
        if(table[index] != null){

            Node temp = table[index];
            //遍历链表是否存在
            while (temp != null){
                //如果Key相同 则替换旧值
                if(temp.key.equals(node.key)){
                    Object oldValue = temp.value;
                    temp.value = node.value;
                    size++;
                    return oldValue;
                }
                temp =temp.next;
            }
            //如果该链表中没有相同的key则插入头中
            node.next = table[index];
            table[index] = node;
            size++;
            countOfOccupiedArrays++;
        }else {
            //如果不存在 放入即可
            table[index] = node;
            size++;
        }

        return node.value;

    }

    /**
     * 通过Key获取Value 如果没有获取到 返回NULL
     * @param key
     * @return
     */
    public Object get(Object key){

        int hash = key.hashCode();

        int index =  getIndexForHash(hash);

        if(table[index] == null) {
            return null;
        }

        Node temp = table[index];

        while (temp != null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 通过KEY删除value
     * @param key
     * @return 返回删除的value 如果不存在KEY 则返回NULL
     */
    public Object remove(Object key){

        int hash = key.hashCode();

        int index =  getIndexForHash(hash);

        if(table[index] == null) {
            return null;
        }

        Node temp = table[index];

        while (temp.next != null){
            if(temp.next.key.equals(key)){
                Object value = temp.next.value;
                temp.next = temp.next.next;
                size--;
                return value;
            }
            temp = temp.next;
        }
        return null;
    }


    private int getIndexForHash(int hash){
        return hash % table.length;
    }

    /**
     * 将当前散列表的数组扩大指定倍数
     * @param expansionMultiple 指定倍数
     */
    private void expansion(int expansionMultiple){
        Node [] newTable = new Node[this.table.length * expansionMultiple];
        for (int i = 0; i < table.length; i++) {
            newTable[i] = table[i];
        }
        table = newTable;
    }
}
