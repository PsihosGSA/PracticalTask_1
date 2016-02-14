package ua.org.oa.gavrishs.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Anna on 01.02.2016.
 */

//@XmlType(propOrder = { "name", "price", "category" }, name = "goods")
@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    public String name;
    public double price;
    public String category;
    public String description;
    @XmlAttribute
    public long id;
    private static long qty=0;

    public Product() {
    }

    public Product(String name, double price, String category, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.id = ++qty;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", category='").append(category).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", id=").append(id);
        sb.append('}').append(System.lineSeparator());
        return sb.toString();
    }
//    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
//    @XmlElement(name = "price")
    public double getPrice() {
        return price;
    }
//    @XmlElement(name = "category")
    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }


    public long getId() {
        return id;
    }

    public static long getQty() {
        return qty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

}
