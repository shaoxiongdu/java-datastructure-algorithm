package cn.shaoxiongdu;

/**
 * ClassName : HashMapTestMain
 * (c)CopyRight 2021/4/21 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class HashMapTestMain {

    public static void main(String[] args) {

        try {

            HashMap hashMap = new HashMap();
            Student zhagnsan = new Student("张三11", 11);
            hashMap.put(new Student("张三11",11),11);
            hashMap.put(new Student("李四12",12),12);
            hashMap.put(new Student("王五13",13),13);
            hashMap.put(new Student("张三21",21),21);
            hashMap.put(new Student("李四22",22),22);
            hashMap.put(new Student("王五23",23),23);

            System.out.println(hashMap.getSize());

            System.out.println(zhagnsan + "值为" + hashMap.get(zhagnsan));

            hashMap.remove(zhagnsan);
            System.out.println(zhagnsan + "值为" + hashMap.get(zhagnsan));



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
