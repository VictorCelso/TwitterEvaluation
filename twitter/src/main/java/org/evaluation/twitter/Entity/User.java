package org.evaluation.twitter.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User
 */
@Table(name = "User",schema = "TwitterEvaluation")
@Entity
public class User {

    @Id
    @Column(unique = true,nullable = false,name = "UserId")
    private String id;
    @Column(nullable = false)
    private String name;

    @OneToMany
    List<User> followers;

    @OneToMany
    List<User> followed;

    @OneToMany
    List<Twitt> twitts;
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}