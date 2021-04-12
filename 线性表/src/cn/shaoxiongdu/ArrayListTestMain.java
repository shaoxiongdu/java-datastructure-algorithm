package cn.shaoxiongdu;

/**
 * ClassName : TestMain
 * (c)CopyRight 2021/4/12 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class ArrayListTestMain {

    public static void main(String[] args) {

        try {

            ArrayList arrayList = new ArrayList(20);

            arrayList.insert(new Student("张三",20));
            arrayList.insert(new Student("李四",30));
            arrayList.insert(new Student("王五",40));

            System.out.println("元素个数为"+arrayList.size());

            for (int i = 1; i <= arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
            }

            System.out.println("第一处添加元素之后");
            arrayList.insert(1,new Student("赵6",50));
            for (int i = 1; i <= arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
            }

            System.out.println("第二个元素为: "+ arrayList.get(2));

            System.out.println("删除第一个元素之后" + arrayList.delete(1));
            System.out.println("大小为" + arrayList.size());
            for (int i = 1; i <= arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
            }

            Student wangwu = new Student("王五", 40);
            System.out.println("wangwu所在位置为"+arrayList.findIndexByObject(wangwu));

            System.out.println("是否为空" + arrayList.isEmpty());

            arrayList.clear();

            System.out.println("清空之后是否为空" + arrayList.isEmpty());

            System.out.println("arrayList的size = " + arrayList.size());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
