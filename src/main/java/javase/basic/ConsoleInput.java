package javase.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ����̨�������
 * @since 2011-9-12
 * @author shiwx
 * @version 1.0
 */
public class ConsoleInput {
	public static void main(String[] args) throws IOException {
		//�ַ���
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("������һЩ����");
		String varOne = reader.readLine();
		System.out.println(varOne);
		
		//Scanner
		System.out.println("������һЩ����");
		Scanner scanner = new Scanner(System.in);
		String scannerStr = scanner.nextLine();
		System.out.println(scannerStr);

	}
}
