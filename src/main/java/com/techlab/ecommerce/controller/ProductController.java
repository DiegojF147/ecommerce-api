package com.techlab.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.techlab.ecommerce.dto.request.ProductRequestDTO;
import com.techlab.ecommerce.dto.response.ProductResponseDTO;
import com.techlab.ecommerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Operation(summary = "Crear producto")
    @ApiResponse(responseCode = "201", description = "Producto creado")
    @PostMapping("")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(dto));
    }

    @Operation(summary = "Listar productos")
    @GetMapping("")
    public List<ProductResponseDTO> getProducts() {
        return service.getProducts();
    }

    @Operation(summary = "Buscar por nombre")
    @GetMapping("/search")
    public List<ProductResponseDTO> searchProductsByName(@RequestParam String queryName) {
        return service.searchProductByName(queryName);
    }

    @Operation(summary = "Buscar por ID")
    @GetMapping("/{id}")
    public ProductResponseDTO searchProductsById(@PathVariable Long id) {
        return service.searchProductById(id);
    }

    @Operation(summary = "Actualizar producto")
    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO dto) {
        return service.updateProduct(id, dto);
    }

    @Operation(summary = "Eliminar producto")
    @DeleteMapping("/{id}")
    public ProductResponseDTO deleteProduct(@PathVariable Long id) {
        return service.deleteProduct(id);
    }
}
