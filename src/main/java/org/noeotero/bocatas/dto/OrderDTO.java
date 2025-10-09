package org.noeotero.bocatas.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Long id;
    private UserDTO user;
    private LocalDateTime orderDate;
    private LocalDateTime servedDate;
    private ProductDTO product;
}
