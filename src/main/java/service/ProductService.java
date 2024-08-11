package service;

import dao.ProductDAO;
import entity.Product;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;

    public void create(Product product) throws IOException {
        productDAO.save(product);
    }

    public List<Product> getAllProducts() throws IOException {
        return productDAO.findAll();
    }
    public void delete(UUID uuid) throws IOException {
        productDAO.deleteById(uuid);
    }
}
