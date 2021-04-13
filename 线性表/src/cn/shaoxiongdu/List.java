package cn.shaoxiongdu;

import java.util.ArrayList;

/**
 * InterfaceName : List
 * (c)CopyRight 2021/4/12 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public interface List {

    public void print();

    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 清空线性表
     */
    public void clear();

    /**
     * 返回线性表中下标为index的元素
     * @param index
     * @return
     */
    public Object get(int index) throws Exception;

    /**
     * 返回指定元素的下标
     * @param object
     * @return 若线性表中无该元素,则返回-1
     */
    public int findIndexByObject(Object object);

    /**
     * 在指定位置插入新元素
     * @param index 指定位置
     * @param object 指定元素
     * @return 新插入的元素
     */
    public Object insert(int index,Object object) throws Exception;

    /**
     * 删除指定位置的元素
     * @param index 指定位置
     * @return 元素 若下标错误或者无指定元素 返回NULL
     */
    public Object delete(int index) throws Exception;

    /**
     * 插入新元素
     * @param object
     * @return 新插入的元素
     */
    public Object insert(Object object) throws Exception;

    /**
     * 返回线性表的元素个数
     * @return
     */
    public int size();

}
