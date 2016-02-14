package ua.org.oa.gavrishs;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.org.oa.gavrishs.model.Shop;
import ua.org.oa.gavrishs.utils.Utils;

import java.io.File;
import java.io.IOException;

import static ua.org.oa.gavrishs.utils.Utils.*;

/**
 * Created by Serge on 14.02.2016.
 */
public class DOMExample {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File (XML_FILE_PATH);
        Shop myShop = Utils.createShop();

        //получаем фабрику парсеров
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        // получаем xml парсер с настройками по умолчанию
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // разбираем xml файл и создаем Document
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

//        if (doc.getDocumentElement().getNodeName() == "shop"){
//            myShop = Utils.createShop();
//        }

        //создаем NodeList из элементов с название тэгов goods
        NodeList nList = doc.getElementsByTagName("goods");
        //перебираем его элементы fori
        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);                      //получаем Node
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {     //проверяем является ли он элементом
                Element eElement = (Element) nNode;             //приводим полученный Нод к элементу и присваеваем его переменной

                //методом addProduct добавляем в myShop продукт созданный методом createProduct которому даем в качестве аргументов
                //переменные полученные от элементов с соответствующими именами, при этом получаем String
                //по этому price приводим к Double
                myShop.addProduct(createProduct(
                    eElement.getElementsByTagName("name").item(0).getTextContent(),
                    Double.valueOf(eElement.getElementsByTagName("price").item(0).getTextContent()),
                    eElement.getElementsByTagName("category").item(0).getTextContent(),
                    eElement.getElementsByTagName("description").item(0).getTextContent()
                ));
            }
        }
        System.out.println(myShop);
    }
}