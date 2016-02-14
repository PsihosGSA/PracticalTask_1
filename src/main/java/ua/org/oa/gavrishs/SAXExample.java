package ua.org.oa.gavrishs;


import org.xml.sax.SAXException;
import ua.org.oa.gavrishs.model.Shop;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import static ua.org.oa.gavrishs.utils.Utils.*;

/**
 * Created by Anna on 01.02.2016.
 */
public class SAXExample {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        File file = new File (XML_FILE_PATH);

        // create factory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MySAXParser saxp = new MySAXParser();


        parser.parse(file, saxp);
        System.out.println(saxp.myShop);

        Shop myShop = saxp.myShop;
    }
}
