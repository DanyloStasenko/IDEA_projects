package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_category")
public class ProductCategory extends Model
{
    // fields
    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_product_category", referencedColumnName = "id")
    private ProductCategory parentProductCategory;

    /*@OneToMany(mappedBy = "productCategory")
    private Set<Product> products = new HashSet<Product>();*/

    // constructor
    public ProductCategory()
    {
        super();
    }

    public ProductCategory(Long id)
    {
        super(id);
    }


    //getter-setter
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public ProductCategory getParentProductCategory()
    {
        return parentProductCategory;
    }

    public void setParentProductCategory(ProductCategory parentProductCategory)
    {
        this.parentProductCategory = parentProductCategory;
    }

    /*public Set<Product> getProducts()
    {
        return products;
    }

    public void setProducts(Set<Product> products)
    {
        this.products = products;
    }*/
}
