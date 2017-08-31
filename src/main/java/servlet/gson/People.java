package servlet.gson;

public class People {

	private String name;
	private String habby;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHabby() {
		return habby;
	}
	public void setHabby(String habby) {
		this.habby = habby;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public People() {
		super();
	}
	public People(String name, String habby, int age) {
		super();
		this.name = name;
		this.habby = habby;
		this.age = age;
	}
	
	
}
