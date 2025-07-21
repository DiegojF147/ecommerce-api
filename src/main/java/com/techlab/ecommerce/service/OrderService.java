package com.techlab.ecommerce.service;

import com.techlab.ecommerce.dto.request.OrderLineRequestDTO;
import com.techlab.ecommerce.dto.request.OrderRequestDTO;
import com.techlab.ecommerce.dto.response.OrderResponseDTO;
import com.techlab.ecommerce.entity.Order;
import com.techlab.ecommerce.entity.OrderLine;
import com.techlab.ecommerce.entity.Product;
import com.techlab.ecommerce.exception.TechlabEcommerceException;
import com.techlab.ecommerce.repository.OrderRepository;
import com.techlab.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public List<OrderResponseDTO> getOrders() {
        return orderRepo.findAll()
                .stream()
                .map(OrderResponseDTO::fromEntity)
                .toList();
    }

    public OrderResponseDTO getOrderById(Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new TechlabEcommerceException("Order not found with ID: " + id,
                        "ID not found", HttpStatus.NOT_FOUND));
        return OrderResponseDTO.fromEntity(order);
    }

    public OrderResponseDTO createOrder(OrderRequestDTO dto) {
        Order order = new Order();
        order.setDate(LocalDate.now());

        for (OrderLineRequestDTO lineDTO : dto.getItems()) {
            Product product = productRepo.findById(lineDTO.getProductId())
                    .orElseThrow(() -> new TechlabEcommerceException("Product not found with ID: " + lineDTO.getProductId(),
                            "Invalid product", HttpStatus.NOT_FOUND));

            if (product.getStock() < lineDTO.getQuantity()) {
                throw new TechlabEcommerceException("Insufficient stock for product: " + product.getName(),
                        "Stock error", HttpStatus.BAD_REQUEST);
            }

            product.setStock(product.getStock() - lineDTO.getQuantity());
            productRepo.save(product);

            OrderLine line = new OrderLine();
            line.setProduct(product);
            line.setQuantity(lineDTO.getQuantity());
            order.addItem(line);
        }

        orderRepo.save(order);
        return OrderResponseDTO.fromEntity(order);
    }

    public OrderResponseDTO deleteOrder(Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new TechlabEcommerceException("Order not found with ID: " + id,
                        "ID not found", HttpStatus.NOT_FOUND));

        for (OrderLine line : order.getOrderLines()) {
            Product product = line.getProduct();
            product.setStock(product.getStock() + line.getQuantity());
            productRepo.save(product);
        }

        orderRepo.delete(order);
        return OrderResponseDTO.fromEntity(order);
    }
}
