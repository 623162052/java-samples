package javase.javaCommon.mail;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * ʹ��apache commons mail�����ʼ�
 * @author shiwx
 * @since 2011-12-19
 */
public class TestCommonsMail {

	/*
	 * SimpleEmail - This class is used to send basic text based emails. 
	1��������SimpleEmail����
	2���趨�����ż���smtp�����������û���趨����Ѱ��ϵͳ������mail.hostֵ��
	3���趨smtp���û�������
	4���ռ���
	5��������
	6������
	7������
	8������
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
	
	/* -------- ���͸��� -------- */
	//��Ҫ���Ͷ��������ֻ�贴�����EmailAttachement
	protected void sendAttachmentEmail() throws EmailException, MalformedURLException{
		
		//create the attachment
		EmailAttachment attachment = new EmailAttachment();
			//local attachment
			attachment.setPath("C:\\Users\\Matthew\\Workspaces\\MyEclipse\\Servlet\\WebRoot\\shanghai.jpg");
			//remote attachment
			//attachment.setURL(new URL(""));
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("�Ϻ���");
		attachment.setName("�Ϻ�");
		
		//create the email message
		MultiPartEmail multiPartEamil = new MultiPartEmail();
		multiPartEamil.setHostName("smtp.qq.com");
		multiPartEamil.setAuthentication("623162052@qq.com", "@sqsuqing22202");
		multiPartEamil.addTo("476173325@qq.com", "shiaoao", "UTF-8");			//��Ҫ���͸�����˿���ʹ��forѭ��addTo
		multiPartEamil.setFrom("623162052@qq.com", "shiwx", "UTF-8");
		multiPartEamil.setSubject("Test Message");
		multiPartEamil.setMsg("This is a message with attachment!");
		//add the attachment
		multiPartEamil.attach(attachment);
		//send mail
		multiPartEamil.send();
	}
	
	/* -------- ����Html�ʼ� -------- */
	public void sendHtmlEmail() throws EmailException{
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("C:\\Users\\Matthew\\Workspaces\\MyEclipse\\Servlet\\WebRoot\\shanghai.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("�Ϻ���");
		attachment.setName("�Ϻ�");
		
		HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setHostName("smtp.qq.com");
		htmlEmail.setAuthentication("623162052@qq.com", "@sqsuqing22202");
		htmlEmail.addTo("shiwx@asiainfo-linkage.com", "shiaoao", "UTF-8");
		htmlEmail.setFrom("623162052@qq.com", "shiwx", "UTF-8");
		htmlEmail.setSubject("Test Html Message");
		htmlEmail.setMsg("This is message with attachment!");
		
		htmlEmail.setHtmlMsg("<html><head><title>Html Message</title></head><body><table border='1'><tr><td>A</td><td>B</td></tr><tr><td>C</td><td>D</td></tr></table><img src='http://www.oschina.net/img/logo.gif'/></body></html>");
		htmlEmail.setTextMsg("Your email client does not support html messages!");
		//��Ӹ���
		htmlEmail.attach(attachment);
		htmlEmail.send();
	}
}
