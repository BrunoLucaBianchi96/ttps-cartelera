package model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table(name = "billboard")
public class Billboard {

    @Id
    @Column(name = "billboard_id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    @Column(name = "name")
    private String name;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    @OneToMany(mappedBy="billboard")
    private ArrayList<Interest> interested;

    @OneToMany(mappedBy="billboard")
    private ArrayList<Publication> publications;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getCreated_at() { return created_at; }

    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }

    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }

    public ArrayList<Interest> getInterested() { return interested; }

    public void setInterested(ArrayList<Interest> interested) { this.interested = interested; }

    public ArrayList<Publication> getPublications() { return publications; }

    public void setPublications(ArrayList<Publication> publications) { this.publications = publications; }

}