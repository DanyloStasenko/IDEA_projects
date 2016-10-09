import java.util.Set;

/**
 * Created by Admin on 07.10.2016.
 */
public class Role
{
    private Long id;
    private String title;
    private User user;

    public Role()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
