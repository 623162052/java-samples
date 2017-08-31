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
        // ��ʼ������
        Person[] arr = new Person[]{new Person("li", '1', 11), new Person("tang", '2', 9), new Person("he", '1', 14)};

        // ��ת���ɵ�list
        List<Person> list = new ArrayList<>();

        // ͨ��Collectionsת��
        Collections.addAll(list, arr);

        System.out.println("[testAsList0] " + list);

    }

    /**
     * ע�⣺Arrays.asList()����һ����ָ������֧�ֵĹ̶���С���б����Բ�����Add��Remove�Ȳ�����
     * ���磺������list.add("4"); ����ʱ��ᱨ�쳣��java.lang.UnsupportedOperationException
     */
    public void testAsList1() {
        // ��ʼ������
        Person[] arr = new Person[]{new Person("li", '1', 11), new Person("tang", '2', 9), new Person("he", '1', 14)};

        // ͨ��Arraysת����list
        List<Person> list = Arrays.asList(arr);
        System.out.println("[testAsList1] " + list);
        list.add(new Person("xi", '1', 10));                   // TODO: Ϊʲô��������
        System.out.println("[testAsList1] " + list);
    }

    public void testAsList2() {
        // ��ʼ������
        Person[] arr = new Person[]{new Person("li", '1', 11), new Person("tang", '2', 9), new Person("he", '1', 14)};

        // ͨ��list���캯��ת���ɿɲ�����list(add��)
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
