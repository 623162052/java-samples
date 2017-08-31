package javase.reflection.usereflection;

import java.io.IOException;

public class GameMain{
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		Game gm = GameFactory.createGame();
		gm.print();
	}
}
