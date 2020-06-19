package uvsq.fr.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String photocat;
    @OneToMany(mappedBy = "category")
    private Collection<Products> products;

    public Category(Long id, String name, String description, String photocat, Collection<Products> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photocat = photocat;
        this.products = products;
    }

    public Category(){}

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

    public String getPhotocat() {
        return photocat;
    }

    public void setPhotocat(String photocat) {
        this.photocat = photocat;
    }

    public Collection<Products> getProducts() {
        return products;
    }

    public void setProducts(Collection<Products> products) {
        this.products = products;
    }
}
