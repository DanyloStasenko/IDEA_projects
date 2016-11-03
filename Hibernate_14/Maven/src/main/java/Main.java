import models.Product;
import models.ProductCategory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
        Session session =sessionFactory.openSession();

        List<Product> products = null;

        try
        {
           session.beginTransaction();

            Criteria criteria = session.createCriteria(Product.class, "product");

            //criteria.addOrder(Order.desc("id"));
            criteria.createCriteria("product.productCategory", "productCategory");
            criteria.add(Restrictions.eq("product.title", "SomeTitle"));
            //criteria.setProjection(Projections.distinct(Projections.property("products")));

            //criteria.setFirstResult(5);
            //criteria.setMaxResults(5);

            // JOIN analogue
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);




            products = criteria.list();

            //criteria.add(Restrictions.eq("title", "SomeTitle"));
            //criteria.add(Restrictions.between("price", 10, 20));
            //criteria.add(Restrictions.like("description", ""));
            //criteria.add(Restrictions.sqlRestriction(smth);

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

        for (Product product : products)
        {
            System.out.println(product.toString());
        }
    }
}