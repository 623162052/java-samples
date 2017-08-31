package javase.javaIO.bytestream.filterInputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

//import org.apache.log4j.Logger;


public class TestZipInputStream{
//	private static Logger log = Logger.getLogger(TestZipInputStream.class);

	/**
	 *	����
	 */
	public static void main(String[] args)  throws Exception  {
		//ѹ���ļ���
		compressDirectory("src/javaIO/bytestream/filterInputStream/testZip", "src/javaIO/bytestream/filterInputStream/testZip.zip");
		//��ѹ�ļ�
		deCompressFile("src/javaIO/bytestream/filterInputStream/testZip_new", "src/javaIO/bytestream/filterInputStream/testZip.zip");
	}

	/**
	 * ѹ���ļ���
	 * @param directory �ļ�����ƣ���·����
	 * @param zipFileName 	���zip�ļ���
	 */
	public static void compressDirectory(String directory, String zipFileName) throws IOException {
//		log.info("--- begin to zip directory --- " + directory);
		ZipOutputStream zipOut = new ZipOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(zipFileName)));
		
		File dir = new File(directory);
		if (!dir.isDirectory()) {
//			log.error(directory + " is not a directory!");
			return;
		}
		File files[] = dir.listFiles();
		byte buff[] = new byte[1024];
		for (int i = 0; i < files.length; i++) {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(files[i]));
//			log.info("--- zip file " + (i+1) + " ---");
			ZipEntry entry = new ZipEntry(files[i].getName());
			zipOut.putNextEntry(entry);
			int count;
			while ((count = bis.read(buff)) != -1) {
				zipOut.write(buff, 0, count);
			}
			bis.close();
		}
		
		zipOut.closeEntry();
		zipOut.flush();
		zipOut.close();
//		log.info("--- finish zip directory --- " + directory);
	}
	
	/**
	 *	��ѹ���ļ� 
	 * @param directory	Ҫ��ѹ��·��
	 * @param zipFileName	zip�ļ����·����
	 */
	public static void deCompressFile(String directory, String zipFileName) throws IOException{
//		log.info("--- begin to unzip zipFile --- " + zipFileName);
		File zipFile = new File(directory);
		zipFile.mkdir();
		
		ZipInputStream zin = new ZipInputStream(
				new BufferedInputStream(
						new FileInputStream(zipFileName)));
		
		ZipEntry zipEntry;
		while((zipEntry = zin.getNextEntry()) != null){
			int count;
			byte[] data = new byte[1024];
			FileOutputStream fos = new FileOutputStream(directory + "/" + zipEntry.getName());
			BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
			while((count = zin.read(data, 0, 1024)) != -1){
				bos.write(data, 0, count);
			}
			bos.flush();
			bos.close();
		}
		zin.close();
//		log.info("--- finish unzip zipFile --- " + zipFileName);
	}
	
}



