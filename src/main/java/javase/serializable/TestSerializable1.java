package javase.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class TestSerializable1 {
	private static final long serialVersionUID = 1L;

	// public static void main(String[] args) throws IOException {
	// FileOutputStream fos = new FileOutputStream("src/temp.txt");
	// ObjectOutputStream oos = new ObjectOutputStream(fos);
	// oos.writeObject(new Date());
	// oos.flush();
	// oos.close();
	// }

	public static void main(String[] args) {

		// //序列化
		// FileOutputStream fos = null;
		// ObjectOutputStream oos = null;
		// try{
		// fos = new FileOutputStream("src/temp.txt");
		// oos = new ObjectOutputStream(fos);
		// Student stu = new Student("aoao","123");
		// System.out.println(stu.getName() + ":" + stu.getPassword());
		// oos.writeObject(stu);
		// }
		// catch(Exception e){
		// e.printStackTrace();
		// }
		// finally{
		// try {
		// if(oos!= null)
		// oos.flush();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// try {
		// if(oos!=null)
		// oos.close();
		// if(fos!=null)
		// fos.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

		// 反序列化
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("src/temp.txt");
			ois = new ObjectInputStream(fis);
			Student student = (Student) ois.readObject();
			System.out.println(student.getName() + ":" + student.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

class Student implements Serializable {
	private static final long serialVersionUID = -7312029550965481435L;
	private String name;
	private String password;

	public Student() {
	}

	public Student(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
