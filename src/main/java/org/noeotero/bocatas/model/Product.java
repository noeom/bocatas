package org.noeotero.bocatas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "availability_date")
    private LocalDateTime availabilityDate;

    @Column(name = "deletion_date")
    private LocalDateTime deletionDate;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductExtra> extras;

    // Constructores
    public Product() {}

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, String description, Integer price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDateTime creationDate) {
        this.availabilityDate = creationDate;
    }

    public LocalDateTime getDeletionDate() {
        return deletionDate;
    }

    public void setDeletionDate(LocalDateTime deletionDate) {
        this.deletionDate = deletionDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductExtra> getExtras() {
        return extras;
    }

    public void setExtras(List<ProductExtra> extras) {
        this.extras = extras;
    }
}