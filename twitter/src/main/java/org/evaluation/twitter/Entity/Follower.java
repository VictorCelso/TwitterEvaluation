package org.evaluation.twitter.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Follow
 */
@Entity
@Table(name = "Follower")
public class Follower {
    @Id
    private int followerID;
    @ManyToOne
    @JoinColumn(name = "id")
    private User followed;

    /**
     * @return the followed
     */
    
    public User getFollowed() {
        return followed;
    }

    /**
     * @return the followerID
     */
    
    public int getFollowerID() {
        return followerID;
    }

    /**
     * @param followed the followed to set
     */
    public void setFollowed(User followed) {
        this.followed = followed;
    }

    /**
     * @param followerID the followerID to set
     */
    public void setFollowerID(int followerID) {
        this.followerID = followerID;
    }
}