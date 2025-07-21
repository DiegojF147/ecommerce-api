package com.techlab.ecommerce.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.techlab.ecommerce.dto.request.ProductRequestDTO;
import com.techlab.ecommerce.dto.response.ProductResponseDTO;
import com.techlab.ecommerce.entity.Product;
import com.techlab.ecommerce.exception.ProductNotFoundException;
import com.techlab.ecommerce.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        repository.save(product);

        ProductResponseDTO responseDTO = new ProductResponseDTO();
        BeanUtils.copyProperties(product, responseDTO);
        return responseDTO;
    }

    public List<ProductResponseDTO> getProducts() {
        return repository.findAll()
                .stream()
                .map(this::mapperToDTO)
                .toList();
    }

    public List<ProductResponseDTO> searchProductByName(String queryName) {
        List<Product> found = repository.findByNameContainingIgnoreCase(queryName);
        if (found.isEmpty()) {
            throw new ProductNotFoundException(queryName);
        }
        return found.stream().map(this::mapperToDTO).toList();
    }

    public ProductResponseDTO searchProductById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id.toString()));
        return mapperToDTO(product);
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id.toString()));

        BeanUtils.copyProperties(dto, product);
        repository.save(product);
        return mapperToDTO(product);
    }

    public ProductResponseDTO deleteProduct(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id.toString()));
        repository.delete(product);
        return mapperToDTO(product);
    }

    private ProductResponseDTO mapperToDTO(Product p) {
        ProductResponseDTO dto = new ProductResponseDTO();
        BeanUtils.copyProperties(p, dto);
        return dto;
    }
}

