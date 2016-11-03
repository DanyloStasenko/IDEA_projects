package models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product extends Model
{
    // fields
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    // constructor
    public Product()
    {
        super();
    }

    public Product(Long id)
    {
        super(id);
    }

    // getter-setter

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public ProductCategory getProductCategory()
    {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory)
    {
        this.productCategory = productCategory;
    }

    @Override
    public String toString()
    {
        return super.getId() + " - " + title + " - " + description + " - " + productCategory.getTitle();
    }
}
