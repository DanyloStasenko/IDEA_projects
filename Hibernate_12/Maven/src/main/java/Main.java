import models.Product;
import models.ProductCategory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Iterator;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
        Session session =sessionFactory.openSession();

        List<Object []> products = null;

        try
        {
            session.beginTransaction();

            SQLQuery queryUpdate = session.createSQLQuery("UPDATE product SET title = 'qwerty' WHERE id = '1'");

            /*
            like JDBC:
            SQLQuery queryUpdate = session.createSQLQuery("UPDATE product SET title = :title WHERE id = :id");
            SQLQuery queryUpdate = session.createSQLQuery("UPDATE product SET title = ? WHERE id = ?");
            queryUpdate.setParameter(0, "val");
            queryUpdate.setParameter(3, val);
            queryUpdate.setParameter("id", "1");
            queryUpdate.executeUpdate;
            */
            queryUpdate.executeUpdate();

            SQLQuery querySelect = session.createSQLQuery("SELECT * FROM product");
            querySelect.addEntity("p", Product.class);
            products = querySelect.list();

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

        for(Object [] obj : products )
        {
            System.out.println(obj[0].toString());
        }
    }
}