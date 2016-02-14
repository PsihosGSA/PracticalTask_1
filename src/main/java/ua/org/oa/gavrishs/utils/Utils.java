package ua.org.oa.gavrishs.utils;

import ua.org.oa.gavrishs.model.Product;
import ua.org.oa.gavrishs.model.Shop;

/**
 * Created by Anna on 01.02.2016.
 */
public class Utils {

    public  static final String XML_FILE_PATH = "anyXMLFile.xml";
    public static Shop createShop() {
        return new Shop();
    }
    public static Product createProduct(String name, double price, String category, String description) {
        return new Product(name,  price,  category, description);
    }
}
