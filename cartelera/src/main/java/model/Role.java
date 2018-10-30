package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy="roles")
    private List<Permission> permissions;

    public int getId() { return id; }

    public void setId(int id) { this.id = id;    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Permission> getPermissions() { return permissions; }

    public void setPermissions(List<Permission> permissions) { this.permissions = permissions; }


    public Role(){  }
}
