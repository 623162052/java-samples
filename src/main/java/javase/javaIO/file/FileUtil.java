package javase.javaIO.file;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *	文件工具类
 */
public class FileUtil {

	/**
	 *	测试 
	 */
	public static void main(String[] args) throws Exception {
//		concat("C:/test10.txt", "C:/test1.txt.1", "C:/test1.txt.2", "C:/test1.txt.3");
//		listAllFiles(new File("src/javaIO/bytestream"));
	}

	
	/**
	 * 合并小文件为大文件
	 * @param target	合并成的大文件
	 * @param files		需合并的小文件
	 */
	public static void concat(String target, String ...files) throws IOException{
		BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(target, true));
		BufferedInputStream bfIn = null;
		byte[] byteArray = new byte[10];
		int byteCounter;
		for(String file : files){ 
			bfIn = new BufferedInputStream(new FileInputStream(file));
			while((byteCounter = bfIn.read(byteArray)) != -1){
				bfOut.write(byteArray, 0, byteCounter);
			}
			if(null != bfIn){
				bfIn.close();
			}
		}
		if(null != bfOut){
			bfOut.close();
		}
		
	}
	
	
	/**
	 *	遍历目录的所有文件
	 */
	public static void listAllFiles(File directory) {
		File[] files = directory.listFiles();
		for(File file : files){
			if(!file.isDirectory()){
					System.out.println(file.getPath() + " - " + file.getName());
			}else{
				listAllFiles(file);
			}
		}
		
	}

}






