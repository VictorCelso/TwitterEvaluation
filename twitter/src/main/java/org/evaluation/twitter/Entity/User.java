package org.evaluation.twitter.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User
 */
@Table(name = "User")
@Entity
public class User {

    @Id
    @Column(unique = true,nullable = false,name = "UserId")
    private int id;
    @Column(nullable = false, name = "userName")
    private String name;
    @OneToMany
    private Set<Tweet> tweets = new HashSet<>();
    @OneToMany(mappedBy = "followerID",fetch = FetchType.EAGER)
    private Set<Follower> followers;
    
    /**
     * @return the id
     */
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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

    /**
     * @param followers the followers to set
     */
    public void setFollowers(Set<Follower> followers) {
        this.followers = followers;
    }

    /**
     * @return the followers
     */
    
    public Set<Follower> getFollowers() {
        return followers;
    }
    
    /**
     * @return the tweets
     */
    
    public Set<Tweet> getTweets() {
        return tweets;
    }

    /**
     * @param tweets the twitts to set
     */
    public void setTweets(Set<Tweet> tweets) {
        this.tweets = tweets;
    }
}