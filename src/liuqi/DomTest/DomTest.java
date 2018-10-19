package liuqi.DomTest;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class DomTest {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db=dbf.newDocumentBuilder();
			//解析xml文件加载到Java
			Document document=db.parse("books.xml");
			NodeList booklist=document.getElementsByTagName("book");
			System.out.println(booklist.getLength());
			for(int i=0;i<booklist.getLength();i++){
				NamedNodeMap attrs=booklist.item(i).getAttributes();
				Node node=booklist.item(i);
				NodeList nodelist=node.getChildNodes();
				for(int k=0;k<nodelist.getLength();k++){
					if(nodelist.item(k).getNodeType()==Node.ELEMENT_NODE){
						//Element元素的getNodeValue获取值是null
					System.out.println(nodelist.item(k).getNodeName() + "值是"
							+ nodelist.item(k).getFirstChild().getNodeValue());
					}
				}
				/*for(int j=0;j<attrs.getLength();j++){
					System.out.println(attrs.item(j).getNodeName()+ "值是:"
							+ attrs.item(j).getNodeValue());
				}*/
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

