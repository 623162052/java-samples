package javase.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shiwx on 2016/1/8.
 */
public class Transform {


    public void testAsList0() {
        // 初始化数组
        Person[] arr = new Person[]{new Person("li", '1', 11), new Person("tang", '2', 9), new Person("he", '1', 14)};

        // 待转换成的list
        List<Person> list = new ArrayList<>();

        // 通过Collections转换
        Collections.addAll(list, arr);

        System.out.println("[testAsList0] " + list);

    }

    /**
     * 注意：Arrays.asList()返回一个受指定数组支持的固定大小的列表。所以不能做Add、Remove等操作。
     * 例如：接上面list.add("4"); 运行时则会报异常：java.lang.UnsupportedOperationException
     */
    public void testAsList1() {
        // 初始化数组
        Person[] arr = new Person[]{new Person("li", '1', 11), new Person("tang", '2', 9), new Person("he", '1', 14)};

        // 通过Arrays转换成list
        List<Person> list = Arrays.asList(arr);
        System.out.println("[testAsList1] " + list);
        list.add(new Person("xi", '1', 10));                   // TODO: 为什么会这样？
        System.out.println("[testAsList1] " + list);
    }

    public void testAsList2() {
        // 初始化数组
        Person[] arr = new Person[]{new Person("li", '1', 11), new Person("tang", '2', 9), new Person("he", '1', 14)};

        // 通过list构造函数转换成可操作的list(add等)
        List<Person> list = new ArrayList<>(Arrays.asList(arr));
        list.add(new Person("xi", '1', 10));
        System.out.println("[testAsList2] " + list);
    }

    /**
     * List -> Array
     */
    public void listToArray() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("li", '1', 11));
        personList.add(new Person("tang", '2', 9));
        personList.add(new Person("he", '1', 14));

        Person[] personArr = new Person[personList.size()];
        personList.toArray(personArr);

        for (Person item : personArr) {
            System.out.println("[listToArray] " + item.toString());
        }
    }

    public static void main(String[] args) {
        Transform transform = new Transform();
        transform.testAsList0();
        transform.testAsList1();
        transform.testAsList2();
        transform.listToArray();
    }


}
