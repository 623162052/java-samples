package servlet.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;


/**
 * 测试gosn
 * @author shiwx
 *
 */
public class TestGson{
	private static Gson gson = new Gson();
	
	public static void main(String[] args) {
		//Serialization
		/*
		String result = gson.toJson(1);
		String result1 = gson.toJson("abc");
		int[] values = {1, 2, 3};
		String result2 = gson.toJson(values);
		*/
		
		//Deserialization
		/*
		int one1 = gson.fromJson("1", int.class);
		Integer one2 = gson.fromJson("1", Integer.class);
		Long one3 = gson.fromJson("1", Long.class);
		Boolean booleanFlag = gson.fromJson("false", Boolean.class);
		String str = gson.fromJson("\"abc\"", String.class);
		//String anotherStr = gson.fromJson("[\"abc\"]", String.class);			??
		System.out.println(1);
		*/
		
		
		//Object
		/*
		People people = new People("Aoao", "swimming", 11);
		//序列化
		String jsonPeople = gson.toJson(people);
		System.out.println(jsonPeople);
		//反序列化
		People people2 = gson.fromJson(jsonPeople, People.class);
		*/
		
		//Collections
		List<People> list = new ArrayList<People>();
		list.add(new People("Aoao1", "swwww", 11));
		list.add(new People("Aoao2", "hwwww", 12));
		list.add(new People("Aoao3", "wwwww", 13));
		String colJson = gson.toJson(list);
		System.out.println(colJson);
	}	
}