package cn.shaoxiongdu;

/**
 * ClassName : LinkedListTestMain
 * (c)CopyRight 2021/4/13 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class LinkedListTestMain {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        System.out.println("linkedList.size() = " + linkedList.size());

        try {
            linkedList.insert(new Student("张三",10));
            linkedList.insert(new Student("李四",20));
            linkedList.insert(new Student("王五",30));

            System.out.println("添加之后");
            linkedList.print();


            System.out.println("添加之后:linkedList.size() = " + linkedList.size());

            System.out.println("位置3的元素是"+linkedList.get(3));

            System.out.println("删除位置1的元素");
            linkedList.delete(1);
            linkedList.print();

            Student z6 = new Student("赵6", 40);
            System.out.println("位置1添加元素" + z6);
            linkedList.insert(1,z6);
            linkedList.print();

            System.out.println("赵6 的位置"+linkedList.findIndexByObject(z6));

            System.out.println("清除");
            linkedList.clear();
            System.out.println("linkedList.size = " + linkedList.size());


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
