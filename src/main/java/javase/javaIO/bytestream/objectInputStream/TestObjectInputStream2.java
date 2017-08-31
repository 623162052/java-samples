package javase.javaIO.bytestream.objectInputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestObjectInputStream2 {
	
	/**
	 *	����
	 */
	public static void main(String[] args) throws Exception {
		TestObjectInputStream2 test = new TestObjectInputStream2();
		test.seria();
		test.reSeria();
	}

	/**
	 *	�����л������ļ���ȡ���� 
	 */
	public void reSeria() throws Exception {
		ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("src/javaIO/bytestream/list.obj")));
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) in.readObject();
		in.close();
		for(Student stu : list){
			System.out.println(stu.getName() + "-" + stu.getAge() + "-" + stu.getSex());
		}
	}

	/**
	 *	���л����󣬴洢�����ļ� 
	 */
	public void seria() throws Exception {
		//��������
		List<Student> list = new ArrayList<Student>();
		Student stu1 = new Student("a",1,"a");
		Student stu2 = new Student("b",2,"b");
		list.add(stu1);
		list.add(stu2);
		
		//���л��洢���ļ�
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("src/javaIO/bytestream/list.obj")));
		out.writeObject(list);
		out.flush();
		out.close();		
	}

}
