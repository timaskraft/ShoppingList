package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Product;
import entity.User;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductDAO {


    private final ObjectMapper objectMapper;
    private final File file;

    public void save(Product product) throws IOException {
        List<Product> products =  objectMapper.readValue(file, new TypeReference<List<Product>>() {
        });
        products.add(product);
        objectMapper.writeValue(file,products);
    }
    public List<Product> findAll() throws IOException {
        return objectMapper.readValue(file, new TypeReference<List<Product>>() {
        });
    }

    public void deleteById(UUID id) throws IOException {
        List<Product> products =  objectMapper.readValue(file, new TypeReference<List<Product>>() {
        });
        List<Product> productList =  products.stream().filter(product -> !product.getId().equals(id)).collect(Collectors.toList());
        objectMapper.writeValue(file,productList);
    }
}
