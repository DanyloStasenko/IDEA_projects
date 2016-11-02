import models.Product;
import models.ProductCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
        Session session =sessionFactory.openSession();

        List<Product> products = null;

        /*
        Creating objects:

        ProductCategory productCategory = new ProductCategory();
        Product product = new Product();
        product.setProductCategory(productCategory);

        product.setTitle("ProductSomeTitle");
        product.setDescription("ProductSomeDescription");
        productCategory.setTitle("SomeCategory");
        session.persist(productCategory);
        session.persist(product);
        */


        try
        {
           session.beginTransaction();

           Query query = session.createQuery("SELECT p FROM Product as p INNER JOIN FETCH p.productCategory as pc");
           // query.setParameter("id", 4L);                                             with pc.id = :id
            Product product = new Product();
            product.setTitle("example");
            //session.save(product);
            //session.delete(product);

            /*
            Query query2;
            query2.uniqueResult();
            */

            session.update(product);

            products = query.list();

            session.getTransaction().commit();
        }
        catch (Exception e)
       {
           session.getTransaction().rollback();
           e.printStackTrace();
       }
        finally
        {
            session.close();
            sessionFactory.close();
        }

        for(Product prod : products)
        {
            System.out.println(prod.toString());
        }

        /*
        FROM Product
        From Product p;
        From Product as p;

        FROM product as p, ProductCategory as pc

        SQL:
        SELECT * FROM product p INNER JOIN FETCH Product_category pc ON p.product_category_id = pc.id

        FROM Product as p INNER JOIN p.productCategory as pc;

        FROM Product as p INNER JOIN p.productCategory as pc with pc.id = 1;

            right outer / left outer JOIN
         */
    }
}