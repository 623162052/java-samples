package javase.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class BooksHandler extends DefaultHandler {
	boolean book = false;
	boolean title = false;
	boolean author = false;
	boolean price = false;

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("book")) {
			book = true;
			System.out.print("book\t");
			for (int i = 0; i < attributes.getLength(); i++)
				System.out.println(attributes.getQName(i) + " : " + attributes.getValue(i));
		}
		if (qName.equals("title"))
			title = true;
		if (qName.equals("author"))
			author = true;
		if (qName.equals("price"))
			price = true;
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		if (title)
			System.out.println("\ttitle : " + new String(ch, start, length));
		if (author)
			System.out.println("\tauthor : " + new String(ch, start, length));
		if (price)
			System.out.println("\tprice : " + new String(ch, start, length));
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("book"))
			book = false;
		if (qName.equals("title"))
			title = false;
		if (qName.equals("author"))
			author = false;
		if (qName.equals("price"))
			price = false;
	}

	public void endDocument() throws SAXException {
		System.out.println("End Document");
	}
}

public class SAXRead {
	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(SAXRead.class.getResourceAsStream("Books.xml"), new BooksHandler());
	}
}
