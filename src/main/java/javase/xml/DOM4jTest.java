package javase.xml;

/**
 * DOM4j创建xml并向文件输出、向控制台输出
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4jTest {
	
	/**
	 * 使用Dom4j读取
	 */
	public void dom4jRead() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/javase/xml/Cities.xml"));
		List cities = document.selectNodes("//cities/city");
		Iterator it = cities.iterator();
		while (it.hasNext()) {
			Element element = (Element) it.next();
			Element id = element.element("id");
			Element name = element.element("name");
			Element prov=name.element("prov");
			Element city=name.element("city");
			System.out.println(id.getData() + ":" + prov.getData()+":"+city.getData());
		}
	}
	
	/**
	 * 使用dom4j创建
	 */
	public void dom4jCreate() throws Exception {
		DocumentFactory df = DocumentFactory.getInstance();

		Document doc = df.createDocument("GBK");				//XML首行的字符集设置
		Element cities = doc.addElement("cities");

		Element city = cities.addElement("city");
		Element cityId = city.addElement("id");
		cityId.addText("1");
		Element cityName = city.addElement("name");
		cityName.addText("NanJin");

		city = cities.addElement("city");
		cityId = city.addElement("id");
		cityId.addText("2");
		cityName = city.addElement("name");
		cityName.addText("Soochow");

		OutputFormat format = OutputFormat.createCompactFormat();
		format.setEncoding("GBK");								

		
		/*输出到文件*/
		XMLWriter out = new XMLWriter(new FileOutputStream("src/javase/xml/Cities.xml"));
		out.write(doc);
		out.flush();
		out.close();
		
		/*输出到控制台*/
		StringWriter content = new StringWriter();
		out = new XMLWriter(content);
		out.write(doc);
		System.out.println(content.getBuffer().toString());
	}
	
	public static void main(String[] args) throws Exception {
		DOM4jTest tester = new DOM4jTest();
		tester.dom4jCreate();
//		tester.dom4jRead();
	}
}
