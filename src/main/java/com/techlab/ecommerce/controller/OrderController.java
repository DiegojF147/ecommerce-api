package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.dto.request.OrderRequestDTO;
import com.techlab.ecommerce.dto.response.OrderResponseDTO;
import com.techlab.ecommerce.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")

@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @Operation(summary = "Create order")
    @ApiResponse(responseCode = "201", description = "Order created")
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrder(dto));
    }

    @Operation(summary = "List orders")
    @GetMapping
    public List<OrderResponseDTO> getOrders() {
        return service.getOrders();
    }

    @Operation(summary = "Find order by ID")
    @GetMapping("/{id}")
    public OrderResponseDTO getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @Operation(summary = "Delete order")
    @DeleteMapping("/{id}")
    public OrderResponseDTO deleteOrder(@PathVariable Long id) {
        return service.deleteOrder(id);
    }
}



