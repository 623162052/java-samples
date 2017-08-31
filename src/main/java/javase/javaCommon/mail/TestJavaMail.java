package javase.javaCommon.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * ʹ��JavaMailAPI�շ��ʼ�
 * @author shiwx
 * @since 2011-12-19
 */
public class TestJavaMail {
	
	/*
	ʹ��JavaMail�����ʼ��Ļ��������£�
	1.����һ���µ�Session�����Ҷ�����ʹ�õĴ洢������(��IMAP����POP3)�ʹ��������(��smtp)��
	2.ʹ��Session���󣬴���һ���µ�Message���󣬲������ײ���һЩ�����硰from�����ֺ��ռ��ˡ�
	3. ������Ϣ��Transport.send()���������������������Ϣ�ײ��и�����ռ�����ʹ����ȷ�Ĵ��䷢����Ϣ��
	*/
	public void sendMail(String mailHost, String mailFrom, String password, String mailTo, String mailSubject, String mailContent) throws Exception{
		Properties properties;
		Session session;
		Message msg;
		Multipart mul;
		BodyPart bp;
		Transport transport;
		
		properties = System.getProperties();
		properties.put("mail.smtp.host", mailHost);	
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.transport.protocol", "smtp");		//�˴�smtp����ΪСд
		session = Session.getDefaultInstance(properties);
		msg = new MimeMessage(session);
		//���÷�����
		msg.setFrom(new InternetAddress(mailFrom));	
		//���ö���ռ��ˣ���;�ָ
		//�ռ���Message.RecipientType.TO		���͸�Message.RecipientType.CC	�ռ��˵�����������Message.RecipientType.BCC
		String[] strs = mailTo.split(";");
		for(int i=0; i<strs.length; i++){
			msg.addRecipient(RecipientType.TO, new InternetAddress(strs[i]));
		}
			
		//��������
		msg.setSubject(mailSubject);
		//��������
		mul = new MimeMultipart();
		bp = new MimeBodyPart();
		bp.setContent(mailContent, "text/html;charset=utf-8");
		mul.addBodyPart(bp);
		msg.setContent(mul);
		//���÷���ʱ��
		msg.setSentDate(new Date());
		//��ֽ��ͷ��ͬ�ػ����ݱ���һ�� 
		msg.saveChanges();      
		
		//�����ʼ�
		transport = session.getTransport();
		transport.connect(mailHost, mailFrom, password);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
	}

	
	/*
	��Ӧ�ó�����ʹ��JavaMail����ȡ�ʼ��Ļ��������£�
	1.����һ���µ�Session�����Ҷ�����ʹ�õĴ洢������(��IMAP����POP3)�ʹ��������(��SMTP)��
	2.ʹ��Session���󣬴���һ���µ�Store�����ڷ�����Ϣ�Ĵ洢֮ǰ����ǰ�û����뾭����֤��
	3.��Store��ȡ��Folder������INBOX��
	4.��Folder�л�ȡ��Ϣ��
	*/
	public void recieveMail() throws Exception{
		Properties properties;
		Session session;
		URLName url;
		Store store;
		Folder folder;
		
		//��ʼ������������
		properties = System.getProperties();
		properties.put("mail.smtp.host", "pop.qq.com");	
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.transport.protocol", "smtp");
		session = Session.getDefaultInstance(properties, null);
		
		//pop3	pop.qq.com   port:110
		//imap	stmp.qq.com	 port:-1
		url = new URLName("imap", "pop.qq.com", -1, null, "623162052@qq.com", "@sqsuqing22202");
		store = session.getStore(url);
		store.connect();//�����ʼ�������
		
		//�ռ���
		folder = store.getFolder("INBOX");//�ռ���
		if(folder == null){
			throw new Exception("No default folder!");
		}
		folder.open(Folder.READ_ONLY);//��ֻ����ʽ���ռ���
		int totalMessages = folder.getMessageCount();
		Message[] msgs = folder.getMessages();
		
		System.out.println("Login from : " + store.getURLName());
		System.out.println("Total Message: " + totalMessages);
		
		if(msgs.length != 0){
			for(int i=0; i<msgs.length; i++){
				System.out.println((i+1) + " / " + msgs.length + "---------------------------------------------------------------------------------------");
			//�����ʼ�
				Part part = msgs[i];
				//��ʾ�ʼ�ͷ
				//Subject(Title)
				System.out.println("Subject: " + msgs[i].getSubject());
				 
				//From
				Address[] mailFrom = msgs[i].getFrom();
				System.out.print("From: ");
				for(int m=0; m<mailFrom.length; m++){
					System.out.print(((InternetAddress)mailFrom[m]).getAddress());
				}
				System.out.println();
				
				//To
				 Address[] mailTo = msgs[i].getRecipients(RecipientType.TO);
				 System.out.print("To: ");
				 for(int n=0; n<mailTo.length; n++){
					 System.out.print(((InternetAddress)mailTo[n]).getAddress() + "; ");
				 }
				 System.out.println();
				 
				 //recieve date
				 System.out.println("Recieve Date: " + msgs[i].getReceivedDate());
				
				//��ȡ�ʼ�����
				//�����ʼ�������
				//text/html��html��ʽ������ 
				//text/plain���޸�ʽ���� 
				Object mailContent = part.getContent();
				
				if(part.isMimeType("text/*")){
					if(part.isMimeType("text/plain")){
						System.out.println("Mail content type: " + part.getContentType());
						System.out.println("Mail content: " + mailContent.toString());
					}else if(part.isMimeType("text/html")){
						System.out.println("Mail content type: " + part.getContentType());
						System.out.println("Mail content: " + mailContent.toString());
					}else{
						System.out.println("text/*:  Mail content type: " + part.getContentType());
					}
					
				}else if(part.isMimeType("multipart/*")){
					Multipart mp = (Multipart) mailContent;
					for(int j=0; j<mp.getCount(); j++){
						//dispaly
						//mp.getBodyPart(j)  displayPart
						Part pa = mp.getBodyPart(j);
						
						if(pa.getContentType() == null){
							System.out.println("multipart/*: invalid part");
						}else if(pa.getContentType().matches("text/*")){
							System.out.println("multipart/* --" + pa.getContentType() + " --- Mail content:" + pa.getContent().toString());
						}else{
							System.out.println("multipate/* -- other mail type: " + pa.getContentType());
						}
					}
				}else{
					System.out.println("OTHER mail type: " + part.getContentType());
				}
			}
		}else{
			System.out.println("�ʼ���Ϊ�㣡");
		}
		store.close();
	}
	
	
	public static void main(String[] args) {
		TestJavaMail test = new TestJavaMail();
		//�����ʼ�
		try {
			for(int i=0; i<20; i++){
				//smtp��ַ��		smtp.163.com, smtp.qq.com, smtp.asiainfo-linkage.com
				//String mailHost, String mailFrom, String password, String mailTo, String mailSubject, String mailContent
				test.sendMail("smtp.asiainfo-linkage.com","shiwx@asiainfo-linkage.com", "Abcabc22202", "835272904@qq.com", "Mail from shiwx", "Mail Content");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//�����ʼ�
//		try {
//			recieveMail();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	

	/**
	 * �ʼ�Э�飺	POP3/IMAP/SMTP
	*/
}
