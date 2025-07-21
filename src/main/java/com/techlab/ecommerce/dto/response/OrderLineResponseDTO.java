package com.techlab.ecommerce.dto.response;

import com.techlab.ecommerce.entity.OrderLine;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineResponseDTO {

    private Long id;
    private int quantity;
    private ProductResponseDTO product;

    public static OrderLineResponseDTO fromEntity(OrderLine line) {
        OrderLineResponseDTO dto = new OrderLineResponseDTO();
        dto.setId(line.getId());
        dto.setQuantity(line.getQuantity());
        dto.setProduct(ProductResponseDTO.fromEntity(line.getProduct()));
        return dto;
    }
}

