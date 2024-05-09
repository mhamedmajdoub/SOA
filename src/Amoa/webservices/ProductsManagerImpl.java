package Amoa.webservices;

import java.util.ArrayList;
import Amoa.domains.Product;
import Amoa.domains.Products;
import Amoa.exceptions.NoSuchProductException;

public class ProductsManagerImpl implements ProductsManager {
    private static Products products = new Products(new ArrayList<>());

    @Override
    public long addProduct(Product product) {
        return products.add(product); // Utiliser la méthode add de la classe Products
    }

    @Override
    public Product getProduct(long id) throws NoSuchProductException {
        Product product = products.get(id);
        if (product != null) {
            return product;
        } else {
            throw new NoSuchProductException("No such product");
        }
    }

    @Override
    public double getProductPrice(long id) throws NoSuchProductException {
        Product product = products.get(id);
        if (product != null) {
            return product.getPrice();
        } else {
            throw new NoSuchProductException("No such product");
        }
    }

    @Override
    public Products getProducts() {
        return products;
    }

    @Override
    public Product updateProduct(Product product) {
        // Implémentez la logique pour mettre à jour un produit
        long id = product.getId();
        Product existingProduct = products.get(id);
        if (existingProduct != null) {
            existingProduct.setLabel(product.getLabel());
            existingProduct.setPrice(product.getPrice());
            return existingProduct;
        } else {
            // Si le produit n'existe pas, peut-être que vous voulez le créer ?
            // Dans ce cas, vous pouvez appeler la méthode addProduct(product)
            // ou lancer une exception selon votre logique métier
            return null;
        }
    }

    @Override
    public boolean deleteProduct(long id) {
        return products.remove(id); // Utiliser la méthode remove de la classe Products
    }

    @Override
    public boolean deleteAllProducts() {
        return products.removeAll(); // Utiliser la méthode removeAll de la classe Products
    }

	@Override
	public boolean deletAllProducts() {
		// TODO Auto-generated method stub
		return false;
	}
}
