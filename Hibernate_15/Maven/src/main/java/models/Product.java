package models;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product extends Model
{
    @NotNull(message = "Field title is null")
    @Size(min = 4, max = 16, message = "min4, max16")
    @Column(name = "title")
    private String title;

    @Pattern(regexp = "^gf")
    // for date: @Past
    // @NotEmpty
    // @Future
    // @AssertTrue
    // @AssertFalse
    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    // @CreditCardNumber
    @Column(name = "price")
    private BigDecimal price;

    @NotNull
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
