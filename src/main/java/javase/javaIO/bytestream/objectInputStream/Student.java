package javase.javaIO.bytestream.objectInputStream;

import java.io.Serializable;

/**
 *	学生类
 *	需要实现 Serializable接口,序列化对象
 */
class Student implements Serializable {
	private static final long serialVersionUID = -3092963755413871932L;

	private String name;
	private int age;
	//transient: 	表示一个域不是该对象串行化的一部分,不用serialization机制来保存它
	private /*transient*/ String sex;
	
	public Student() {
		super();
	}
	public Student(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}