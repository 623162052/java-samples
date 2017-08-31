package javase.reflection.usereflection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameFactory {
	public static Game createGame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		
		
		InputStream in = GameFactory.class.getResourceAsStream("/javaReflection/usereflection/game.properties");
		Properties pro = new Properties();
		pro.load(in);
		in.close();
		
		//以上代码读取配置文件,将配置的键值对方法Properties对象
		
		String key = Game.class.getSimpleName();	//获取Game接口名Game
		String className = pro.getProperty(key);	//获取配置文件中"Game"对应的实现类类名
		Object game = Class.forName(className).newInstance();	//反射创建实例
		return (Game)game;
		
	}	
}
