package javase.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;



public class DOMCreate {
	
	/**
	 * 使用Dom读取
	 */
	public void domRead() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(DOMResult.class.getResourceAsStream("Books.xml"));
		NodeList nodes = doc.getElementsByTagName("title");
		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);
			System.out.print(((Element) element.getParentNode()).getAttribute("id") + " : ");
			Node node = element.getFirstChild();
			if (node instanceof Text)
				System.out.println(node.getNodeValue());
		}
	}
	
	/**
	 * 使用Dom创建
	 */
	public void domCreate() throws Exception{
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			Element student = doc.createElement("student");
			student.setAttribute("ID", "001");

			Element firstname = doc.createElement("firstname");
			firstname.appendChild(doc.createTextNode("yu"));
			Element lastname = doc.createElement("lastname");
			lastname.appendChild(doc.createTextNode("feng"));
			student.appendChild(firstname);
			student.appendChild(lastname);

			Element student1 = doc.createElement("student");
			student1.setAttribute("ID", "002");

			Element firstname1 = doc.createElement("firstname");
			firstname1.appendChild(doc.createTextNode("yu1"));
			Element lastname1 = doc.createElement("lastname");
			lastname1.appendChild(doc.createTextNode("feng1"));
			student1.appendChild(firstname1);
			student1.appendChild(lastname1);
			
			
			
			
			Element students = doc.createElement("students");
			students.appendChild(student);
			students.appendChild(student1);
			doc.appendChild(students);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.transform(new DOMSource(doc), new StreamResult(System.out));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

}