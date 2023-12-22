package co.istad.mvcap.model;

import java.util.UUID;

public class Product {
    private UUID id;
    private Integer code;
    private String name;
    private Double priceIn;

    public Product() {
    }

    public Product(UUID id, Integer code, String name, Double priceIn) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.priceIn = priceIn;
    }

    public Product(String name, Double priceIn) {
        this.name = name;
        this.priceIn = priceIn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(Double priceIn) {
        this.priceIn = priceIn;
    }

    @Override
    public String toString() {
        return "Product{" +
                "UUID=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", priceIn=" + priceIn +
                '}';
    }
}
