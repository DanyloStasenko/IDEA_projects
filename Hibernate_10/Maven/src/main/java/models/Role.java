package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role_table")
public class Role extends Model
{
    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    public Role() {}

    public Set<User> getUsers()
    {
        return users;
    }

    public void setUsers(Set<User> users)
    {
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
