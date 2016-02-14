package ua.org.oa.gavrishs;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.org.oa.gavrishs.model.Product;
import ua.org.oa.gavrishs.model.Shop;
import ua.org.oa.gavrishs.utils.Utils;

/**
 * Created by Anna on 01.02.2016.
 */
public class MySAXParser extends DefaultHandler {
    public Shop myShop;
    public Product curentProduct;
    public String curentElement = "";
    private long beginTime = 0;


    @Override
    public void startDocument() throws SAXException {
        //замеряем время вначале парсинга
        beginTime = System.currentTimeMillis();
        //выводим в кансоль сообщение о начале документа
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        //выводим в консоль о конце парсинга
        System.out.println("End document");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //выводим в консоль время затраченое на парсинг посредством вычитания из текущеного времени времени начала
        System.out.printf("processing time: %15dms.\n",System.currentTimeMillis()- beginTime);
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        switch (qName){
            case "shop":
                myShop = Utils.createShop();
                break;

            case "goods":
                curentProduct = new Product();
                curentProduct.id = Long.valueOf(atts.getValue("id"));
                break;
        }
        //инициализируем curentElement
        curentElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName ) throws SAXException {
        //если goods то добавляем curentProduct, который успел наполниться данными, в myShop посредством метода addProduct
        switch (qName){
            case "goods":
                myShop.addProduct(curentProduct);
                break;
        }
        //обнуляем curentElement
        curentElement = "";

    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //вносим иниформацию из элементов в соответствующие переменные curentProduct
        if (curentElement.equals("name")){
            curentProduct.name = new String(ch, start, length);
        }
        if (curentElement.equals("price")){
            curentProduct.price = Double.valueOf(new String(ch, start, length));
        }
        if (curentElement.equals("category")){
            curentProduct.category = new String(ch, start, length);
        }
        if (curentElement.equals("description")){
            curentProduct.description = new String(ch, start, length);
        }
    }
}
