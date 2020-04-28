package json.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParsingTest {
	public void parse() {
		try {
			// DOM Document 객체를 생성하기 위한 메서드
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			// DOM 파서로부터 입력받은 파일을 파싱하도록 요청
			DocumentBuilder builder = dbf.newDocumentBuilder();
			
			// XML 파일 지정
			String url = getClass().getResource("./data/book.xml").toExternalForm();
			
			// DOM 파서로부터 입력받은 파일을 파싱하도록 요청
			Document xmlDoc = builder.parse(url);
			
			// DOM Document 객체로부터 root 엘리먼트 및 자식 객체 가져오기
			Element root = xmlDoc.getDocumentElement();
			System.out.println("루트 엘리먼트 태그명: " + root.getTagName());
			
			// 하위 엘리먼트 접근 방법1 : getElementByTagName() 이용
			NodeList bookNodeList = root.getElementsByTagName("book");
			Node firstBookNode = bookNodeList.item(0); // 첫번재 항목
			Element firstBookElement = (Element)firstBookNode;
			
			// 속성 접근방법1 : 엘리먼트 객체의 getAttribute() 이용
			System.out.println("엘리먼트 객체의 getAttribute 이용 : " + firstBookElement.getAttribute("isbn"));
			
			// 속성 접근방법2 : 노드객체의 getAttributes() 메서드 이용
			NamedNodeMap nodeMap = firstBookNode.getAttributes();
			System.out.println("노드객체의 getAttributes 이용 : " + nodeMap.getNamedItem("isbn").getNodeValue());
			
			// 하위 엘리먼트 접근 방법 2 : getChildNodes() 메서드 이용
			NodeList firstBookChildNodeList = firstBookNode.getChildNodes();
			for (int i = 0; i < firstBookChildNodeList.getLength(); i++) {
				Node n = firstBookChildNodeList.item(i);
				System.out.println("노드명 : " + n.getNodeName()
									+ ", 노드값 : " + n.getNodeValue() // 엔터키도 인식이 된다. 엔터키를 안 먹게 하려면  
																	// xml 파일에서 엔터친 곳을 전부 지우고 태그들을 전부 붙여 놓는다.
									+ ", 노드타입 : " + n.getNodeType()
									+ ", 컨텐트값 : " + n.getTextContent()
									);
			}
			
			// 엔터키에 해당되는 부분이 읽힐 수 있으므로, getChildNodes
			// 보다는 getElementByTagName() 을 이용해 접근하는게 좋다.
			Node titleNode = firstBookChildNodeList.item(1);
			Element titleElement = (Element) titleNode;
			System.out.println("titleElementByTagName() => " + titleElement.getTagName());
			
			// 전체 출력하기
			System.out.println("---------------------------");
			for (int i = 0; i < bookNodeList.getLength(); i++) {
				Node bookNode = bookNodeList.item(i);
				Element element = (Element) bookNode;
				String isbn = element.getAttribute("isbn");
				String kind = element.getAttribute("kind");
				String title = element.getElementsByTagName("title").item(0).getTextContent();
				String author = element.getElementsByTagName("author").item(0).getTextContent();
				String price = element.getElementsByTagName("price").item(0).getTextContent();
				String str = String.format("%8s %10s %20s %10s %8s", isbn, kind, title, author, price);
				System.out.println(str);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DomParsingTest parser = new DomParsingTest();
		parser.parse();
	}
}
