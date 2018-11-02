package model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "interest")
public class Interest {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    @OneToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Billboard billboard;


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Date getCreated_at() { return created_at; }

    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }

    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Billboard getBillboard() { return billboard; }

    public void setBillboard(Billboard billboard) { this.billboard = billboard; }

    public Interest(){

    }

}
