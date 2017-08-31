package servlet.thread;

import java.util.HashMap;
import java.util.Map;

public class MainThread {
	private static Map<String, Object> container = new HashMap<String, Object>();
	
	public static void main(String[] args) {
		System.out.println("--------------- start -----------------");
		
		QueryData queryData = new QueryData();
		queryData.setContainer(container);
		
		PushData pushData = new PushData();
		pushData.setContainer(container);
		
		new Thread(queryData).start();
		new Thread(pushData).start();
	}

}
