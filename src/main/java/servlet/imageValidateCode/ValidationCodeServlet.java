package servlet.imageValidateCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 8632516553196171943L;

	public ValidationCodeServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置响应头
		response.setContentType("image/jpeg");
		//设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//向浏览器输入流
		OutputStream outPutStream = response.getOutputStream();
		int width = 80;
		int height = 20;
		//建立指定宽和高的BufferedImage对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		//画图
		Graphics g = image.getGraphics();
		//填充矩形
		g.fillRect(0, 0, width, height);
		//设置字体
		g.setFont(new Font("Times News Roman",Font.ITALIC,18));
		g.setColor(getRandColor(200,250));
		
		Random random = new Random();
		for (int i=0;i<155;i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
	        int xl = random.nextInt(12);
	        int yl = random.nextInt(12);
			g.drawLine(x,y,x+xl,y+yl);
		}
		
		//生成随机数
		String strRand = "";
		for(int i = 0; i< 4; i++){
			String rand = String.valueOf(random.nextInt(10));
			strRand += rand;
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			g.drawString(rand, 20*i, 16);
		}
		request.getSession().setAttribute("rand", strRand);
		g.dispose();
		//输出图片到页面
		ImageIO.write(image, "JPEG", outPutStream);
	}

	public static Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}