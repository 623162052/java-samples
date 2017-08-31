package javase.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 控制台输入输出
 * @since 2011-9-12
 * @author shiwx
 * @version 1.0
 */
public class ConsoleInput {
	public static void main(String[] args) throws IOException {
		//字符流
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入一些内容");
		String varOne = reader.readLine();
		System.out.println(varOne);
		
		//Scanner
		System.out.println("请输入一些内容");
		Scanner scanner = new Scanner(System.in);
		String scannerStr = scanner.nextLine();
		System.out.println(scannerStr);

	}
}
