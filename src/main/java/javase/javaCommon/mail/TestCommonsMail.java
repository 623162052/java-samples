package javase.javaCommon.mail;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * 使用apache commons mail发送邮件
 * @author shiwx
 * @since 2011-12-19
 */
public class TestCommonsMail {

	/*
	 * SimpleEmail - This class is used to send basic text based emails. 
	1：创建以SimpleEmail对象
	2：设定发送信件的smtp服务器，如果没有设定，会寻找系统变量中mail.host值。
	3：设定smtp的用户和密码
	4：收件人
	5：发件人
	6：主题
	7：内容
	8：发送
	*/
	public void sendSimpleEmail() throws EmailException{
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.qq.com");
		email.setAuthentication("623162052@qq.com", "@sqsuqing22202");
		email.addTo("476173325@qq.com", "shiaoao", "UTF-8");
		email.setFrom("623162052@qq.com", "shiwx", "UTF-8");
		email.setSubject("Test Message");
		email.setMsg("This is message content!");
		email.send();
	}
	
	/* -------- 发送附件 -------- */
	//需要发送多个附件，只需创建多个EmailAttachement
	protected void sendAttachmentEmail() throws EmailException, MalformedURLException{
		
		//create the attachment
		EmailAttachment attachment = new EmailAttachment();
			//local attachment
			attachment.setPath("C:\\Users\\Matthew\\Workspaces\\MyEclipse\\Servlet\\WebRoot\\shanghai.jpg");
			//remote attachment
			//attachment.setURL(new URL(""));
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("上海市");
		attachment.setName("上海");
		
		//create the email message
		MultiPartEmail multiPartEamil = new MultiPartEmail();
		multiPartEamil.setHostName("smtp.qq.com");
		multiPartEamil.setAuthentication("623162052@qq.com", "@sqsuqing22202");
		multiPartEamil.addTo("476173325@qq.com", "shiaoao", "UTF-8");			//需要发送给多个人可以使用for循环addTo
		multiPartEamil.setFrom("623162052@qq.com", "shiwx", "UTF-8");
		multiPartEamil.setSubject("Test Message");
		multiPartEamil.setMsg("This is a message with attachment!");
		//add the attachment
		multiPartEamil.attach(attachment);
		//send mail
		multiPartEamil.send();
	}
	
	/* -------- 发送Html邮件 -------- */
	public void sendHtmlEmail() throws EmailException{
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("C:\\Users\\Matthew\\Workspaces\\MyEclipse\\Servlet\\WebRoot\\shanghai.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("上海市");
		attachment.setName("上海");
		
		HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setHostName("smtp.qq.com");
		htmlEmail.setAuthentication("623162052@qq.com", "@sqsuqing22202");
		htmlEmail.addTo("shiwx@asiainfo-linkage.com", "shiaoao", "UTF-8");
		htmlEmail.setFrom("623162052@qq.com", "shiwx", "UTF-8");
		htmlEmail.setSubject("Test Html Message");
		htmlEmail.setMsg("This is message with attachment!");
		
		htmlEmail.setHtmlMsg("<html><head><title>Html Message</title></head><body><table border='1'><tr><td>A</td><td>B</td></tr><tr><td>C</td><td>D</td></tr></table><img src='http://www.oschina.net/img/logo.gif'/></body></html>");
		htmlEmail.setTextMsg("Your email client does not support html messages!");
		//添加附件
		htmlEmail.attach(attachment);
		htmlEmail.send();
	}
}
