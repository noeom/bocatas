package org.noeotero.bocatas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "extras")
@Data
public class Extra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    // Constructors
    public Extra() {}

    public Extra(String name) {
        this.name = name;
    }

    public Extra(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
