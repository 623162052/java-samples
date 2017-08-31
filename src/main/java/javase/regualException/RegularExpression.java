package javase.regualException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式，参考JDK文档
 * 
 * Pattern
 * Matcher
 * 
 */
public class RegularExpression {
	
	public static void main(String[] args) {
	/*
		//matches: 尝试将整个区域与模式匹配
		//编译模式
		Pattern mailPattern = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		//匹配模式
		Matcher matcher = mailPattern.matcher("aoaoxiong@gmail.com");
		
		//是否匹配，matcher为匹配整个字符串
		System.out.println(matcher.matches());
		
		//find为找到第一个匹配，返回boolean
		while(matcher.find()){
			String mailStr = matcher.group();
			System.out.println(mailStr);
		}

		
		Pattern pattern1 = Pattern.compile("[a-z]{2}");
		Matcher matcher1 = pattern1.matcher("abc-a-aa");
		//find：尝试查找与该模式匹配的输入序列的下一个子序列
		System.out.println(matcher1.find());
		//start:匹配的开始位置，匹配的最后位置的下一位
		System.out.println(matcher1.start() + " - " + matcher1.end());
		System.out.println(matcher1.find());
		System.out.println(matcher1.find());
		
		//lookingAt：尝试将从区域开头开始的输入序列与该模式匹配
		System.out.println(matcher1.lookingAt());

		
		//replacement
		//CASE_INSENSITIVE、MULTILINE、DOTALL、UNICODE_CASE、 CANON_EQ、UNIX_LINES、LITERAL、COMMENTS
		Pattern pattern2 = Pattern.compile("kitty", Pattern.CASE_INSENSITIVE);
		Matcher matcher2 = pattern2.matcher("sweetkittyKittyKITTY");
		while(matcher2.find()){
			System.out.println(matcher2.group());
		}
		System.out.println(matcher2.replaceAll("KITTY"));
		
	*/
		
		//分组
		Pattern pattern3 = Pattern.compile("(\\d{3,5})([a-z]{2})");
		Matcher matcher3 = pattern3.matcher("123aa-34345bb-234cc-00");
		while(matcher3.find()){
			System.out.println(matcher3.group(2));
		}
	}
}


/*
 * 范围
 * 边界处理
 * 
 * quantifiers:	数量词	
 * 		Greedy, 		贪婪数量词			最大匹配（吐）
 * 		Reluctant, 		勉强数量词			最小匹配（吞）	
 * 		Possessive		独占数量词			最大匹配（不吐）
 * 
 * 
 * 非捕获
 * 
 */





