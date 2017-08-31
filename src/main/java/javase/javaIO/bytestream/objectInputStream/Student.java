package javase.javaIO.bytestream.objectInputStream;

import java.io.Serializable;

/**
 *	ѧ����
 *	��Ҫʵ�� Serializable�ӿ�,���л�����
 */
class Student implements Serializable {
	private static final long serialVersionUID = -3092963755413871932L;

	private String name;
	private int age;
	//transient: 	��ʾһ�����Ǹö����л���һ����,����serialization������������
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