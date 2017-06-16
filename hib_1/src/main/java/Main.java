import org.hibernate.SessionFactory;

/**
 * Created by Admin on 06.10.2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
        System.out.println("1");
    }

}
