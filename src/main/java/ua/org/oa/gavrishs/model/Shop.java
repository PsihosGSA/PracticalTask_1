package ua.org.oa.gavrishs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anna on 01.02.2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Shop {
    private List<Product> goods;

    public Shop() {
        this.goods = new LinkedList<>();
    }

    public void addProduct(Product product){
        this.goods.add(product);
    }

    public List<Product> getGoods() {
        return goods;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                '}';
    }
}
