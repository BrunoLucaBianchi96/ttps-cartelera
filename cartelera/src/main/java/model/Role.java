package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

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

    @OneToMany(mappedBy="role")
    private ArrayList<Permission> permissions;

    public int getId() { return id; }

    public void setId(int id) { this.id = id;    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public ArrayList<Permission> getPermissions() { return permissions; }

    public void setPermissions(ArrayList<Permission> permissions) { this.permissions = permissions; }


    public Role(){  }
}
