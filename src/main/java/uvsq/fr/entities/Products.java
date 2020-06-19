package uvsq.fr.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double curentprice;
    private boolean promotion; //produit en promotion
    private boolean selected; //un momment donner on afficher que de produit selectionner par admin ou webmaster
    private boolean available; //qui indiquer si le prodiuit est disponible un stock
    private String photoname; //pour stocke le photo de produit dans un dossier quelque part!!
   @ManyToOne
    private Category category;

    public Products(String name, String description, double curentprice, boolean promotion, boolean selected, boolean available, String photoname, Category category) {
        this.name = name;
        this.description = description;
        this.curentprice = curentprice;
        this.promotion = promotion;
        this.selected = selected;
        this.available = available;
        this.photoname = photoname;
        this.category = category;
    }

    public Products(){}

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

    public double getCurentprice() {
        return curentprice;
    }

    public void setCurentprice(double curentprice) {
        this.curentprice = curentprice;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPhotoName() {
        return photoname;
    }

    public void setPhotoName(String photoname) {
        this.photoname = photoname;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
