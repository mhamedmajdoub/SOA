package Amoa.domains;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {
    @XmlElement(name = "product")
    private List<Product> products;

    public Products(ArrayList<Product> list) {
        this.products = list;
    }

    public long add(Product product) {
        long id = generateId();
        product.setId(id);
        products.add(product);
        return id;
    }

    public Product get(long id) {
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    public boolean remove(long id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeAll() {
        products.clear();
        return true;
    }

    // Méthode de génération d'ID unique à implémenter
    private long generateId() {
        // Logique de génération d'ID
        return System.currentTimeMillis(); // Exemple simple : utiliser le timestamp actuel comme ID
    }
}
