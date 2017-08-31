package javase.javaIO.bytestream.objectInputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *	测试ObjectInputStream 
 */
public class TestObjectInputStream {
	/**
	 *	测试 
	 */
	public static void main(String[] args) throws Exception {
//		outObject();
//		readObject();
	}

	/**
	 * 从文件读取对象
	 * 反序列化对象
	 */
	public static void readObject() throws Exception {
		ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("src/javaIO/bytestream/test.obj")));
		
		Student stu1 = (Student) in.readObject();
		Student stu2 = (Student) in.readObject();
		
		System.out.println(stu1.getName() + "-" + stu1.getAge() + "-" + stu1.getSex());
		System.out.println(stu2.getName() + "-" + stu2.getAge() + "-" + stu2.getSex());
		if(in != null){
			in.close();
		}
	}

	/**
	 * 	输出对象到文件
	 *	序列化对象
	 */
	public static void outObject() throws Exception {
		Student stu1 = new Student("a", 1, "男");
		Student stu2 = new Student("b", 2, "女");
		
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("src/javaIO/bytestream/test.obj")));

		out.writeObject(stu1);
		out.writeObject(stu2);
		out.flush();
		if(out != null){
			out.close();
		}
	}
}
