import java.util.Set;

/**
 * Created by Admin on 07.10.2016.
 */
public class Role
{
    private Long id;
    private String title;
    private Set<User> users;

    public Role()
    {

    }

    public Set<User> getUsers()
    {
        return users;
    }

    public void setUsers(Set<User> users)
    {
        this.users = users;
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
}
