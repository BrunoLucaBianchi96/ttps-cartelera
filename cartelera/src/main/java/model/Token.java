package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "token")
public class Token {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    @Column(name = "token")
    private String token;

    @OneToOne( fetch = FetchType.LAZY)
    private User user;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}
