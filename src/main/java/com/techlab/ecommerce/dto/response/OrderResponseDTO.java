package com.techlab.ecommerce.dto.response;

import com.techlab.ecommerce.entity.Order;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {

    private Long id;
    private LocalDate date;
    private List<OrderLineResponseDTO> items;

    public static OrderResponseDTO fromEntity(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setDate(order.getDate());
        dto.setItems(order.getOrderLines().stream()
                .map(OrderLineResponseDTO::fromEntity)
                .collect(Collectors.toList()));
        return dto;
    }
}

