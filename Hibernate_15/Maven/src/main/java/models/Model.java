package models;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Model implements Serializable
{
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    // default constructor
    public Model()
    {
    }

    // overloaded constructor
    public Model(Long id)
    {
        this.id = id;
    }

    // getter-setter
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
