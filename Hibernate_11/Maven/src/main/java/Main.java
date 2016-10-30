import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
        Session session =sessionFactory.openSession();

        try
        {
            session.beginTransaction();
            // SQL
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

    }
}