package vod.webrest.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String photo;
    private float price;
    private int producerId;
}
