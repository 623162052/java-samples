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
		
		//���ϴ����ȡ�����ļ�,�����õļ�ֵ�Է���Properties����
		
		String key = Game.class.getSimpleName();	//��ȡGame�ӿ���Game
		String className = pro.getProperty(key);	//��ȡ�����ļ���"Game"��Ӧ��ʵ��������
		Object game = Class.forName(className).newInstance();	//���䴴��ʵ��
		return (Game)game;
		
	}	
}
