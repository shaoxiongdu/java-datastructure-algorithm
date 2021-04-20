package cn.shaoxiongdu;

/**
 * InterfaceName : Queue
 * (c)CopyRight 2021/4/20 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 *     队列接口
 */
public interface Queue {

    /**
     * 清空队列
     */
    public void clear();

    /**
     * 是否为空
     */
    public boolean empty();

    /**
     * 获取头元素
     * @return
     */
    public Object getHead();

    /**
     * 堆尾插入新元素
     * @param object
     */
    public void enterObject(Object object) throws Exception;

    /**
     * 删除队列中的队头元素
     * @return
     */
    public Object deleteObject() throws Exception;

    /**
     * 返回队列元素个数
     * @return
     */
    public int size();
}
