package ua.org.oa.gavrishs;

/**
 * Created by Anna on 01.02.2016.
 */
import ua.org.oa.gavrishs.model.Product;
import ua.org.oa.gavrishs.model.Shop;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import static ua.org.oa.gavrishs.utils.Utils.*;

public class MyJAXBParser {

    public static void main(String[] args) {
        try {
            marshalExample();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        try {
            unmarshalExample();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void unmarshalExample() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
        Unmarshaller unmarshaller =
                jaxbContext.createUnmarshaller();
        Object o = unmarshaller.unmarshal(new File(XML_FILE_PATH));
        System.out.println(o);
        Shop myShopeMagazinOloloGagaGaga = (Shop)o;
        myShopeMagazinOloloGagaGaga.getGoods().stream().forEach(System.out::println);
    }

    public static void marshalExample() throws JAXBException {
        Shop magazin = createShop();
        String name = "product";
        String category = "babyShoose";

        for (int i = 0; i < 100; i++) {
            magazin.addProduct(
                    createProduct(name+i, Math.random(),category+i,"description"));
        }
        System.out.println(magazin);

        JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        File file = new File(XML_FILE_PATH);
        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(magazin, file);
        jaxbMarshaller.marshal(magazin, System.out);
    }


}
