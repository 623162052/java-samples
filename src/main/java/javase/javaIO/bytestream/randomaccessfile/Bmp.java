package javase.javaIO.bytestream.randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Bmp {
	private int width;
	private int height;
	private RandomAccessFile raf;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Bmp(String file) throws IOException{
		raf = new RandomAccessFile(file, "rw");
		raf.seek(18);
		int w = raf.readInt();
		int h = raf.readInt();
		
		width = gaoZiJieXu(w);
		height = gaoZiJieXu(h);
	}

	private int gaoZiJieXu(int w) {
		int n = 0;
		n |= w >>> 24;
		n |= (w >>> 8) & 0x0000ff00;
		n |= (w << 8) & 0x00ff0000;
		n |= w << 24;
		return n;
	}
	
	public void brighter() throws IOException{
		raf.seek(54);
		int skipBytes = 0;
		if(width*3 % 4 != 0) {
			skipBytes = 4 - (width*3 % 4);
		}
		
		for(int i=0;i<height;i++) {
			for(int j=0;j<width*3;j++) {
				int b = raf.readByte() << 24 >>> 24;
				if(b == 0) b = 1;
				b = (int) Math.ceil(((b * 1.2>255)? 255 : b * 1.2));
				raf.seek(raf.getFilePointer()-1);
				raf.write(b);
			}
			raf.skipBytes(skipBytes);
		}
	}
	
	/**
	 *	≤‚ ‘ 
	 */
	public static void main(String[] args) throws Exception {
		Bmp bmp = new Bmp("src/javaIO/bytestream/randomaccessfile/picture.bmp");
		System.out.println(bmp.getWidth());
		System.out.println(bmp.getHeight());
		
		bmp.brighter();
	}
}
