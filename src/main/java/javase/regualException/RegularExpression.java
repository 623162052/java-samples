package javase.regualException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽ���ο�JDK�ĵ�
 * 
 * Pattern
 * Matcher
 * 
 */
public class RegularExpression {
	
	public static void main(String[] args) {
	/*
		//matches: ���Խ�����������ģʽƥ��
		//����ģʽ
		Pattern mailPattern = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		//ƥ��ģʽ
		Matcher matcher = mailPattern.matcher("aoaoxiong@gmail.com");
		
		//�Ƿ�ƥ�䣬matcherΪƥ�������ַ���
		System.out.println(matcher.matches());
		
		//findΪ�ҵ���һ��ƥ�䣬����boolean
		while(matcher.find()){
			String mailStr = matcher.group();
			System.out.println(mailStr);
		}

		
		Pattern pattern1 = Pattern.compile("[a-z]{2}");
		Matcher matcher1 = pattern1.matcher("abc-a-aa");
		//find�����Բ������ģʽƥ����������е���һ��������
		System.out.println(matcher1.find());
		//start:ƥ��Ŀ�ʼλ�ã�ƥ������λ�õ���һλ
		System.out.println(matcher1.start() + " - " + matcher1.end());
		System.out.println(matcher1.find());
		System.out.println(matcher1.find());
		
		//lookingAt�����Խ�������ͷ��ʼ�������������ģʽƥ��
		System.out.println(matcher1.lookingAt());

		
		//replacement
		//CASE_INSENSITIVE��MULTILINE��DOTALL��UNICODE_CASE�� CANON_EQ��UNIX_LINES��LITERAL��COMMENTS
		Pattern pattern2 = Pattern.compile("kitty", Pattern.CASE_INSENSITIVE);
		Matcher matcher2 = pattern2.matcher("sweetkittyKittyKITTY");
		while(matcher2.find()){
			System.out.println(matcher2.group());
		}
		System.out.println(matcher2.replaceAll("KITTY"));
		
	*/
		
		//����
		Pattern pattern3 = Pattern.compile("(\\d{3,5})([a-z]{2})");
		Matcher matcher3 = pattern3.matcher("123aa-34345bb-234cc-00");
		while(matcher3.find()){
			System.out.println(matcher3.group(2));
		}
	}
}


/*
 * ��Χ
 * �߽紦��
 * 
 * quantifiers:	������	
 * 		Greedy, 		̰��������			���ƥ�䣨�£�
 * 		Reluctant, 		��ǿ������			��Сƥ�䣨�̣�	
 * 		Possessive		��ռ������			���ƥ�䣨���£�
 * 
 * 
 * �ǲ���
 * 
 */





