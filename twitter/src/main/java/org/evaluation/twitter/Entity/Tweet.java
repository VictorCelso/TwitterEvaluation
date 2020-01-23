package org.evaluation.twitter.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Twitt
 */
@Table(name = "Twitt")
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, name = "TweetId", nullable = false)
    private int id;
    
    @Column(name = "Content", nullable = false )
    private String content;

    @Column(name = "TweetTime", nullable = false)
    private Date tweetDate;

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
     * @return the content
     */
    
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the tweetDate
     */
    
    public Date getTweetDate() {
        return tweetDate;
    }

    /**
     * @param twittDate the twittDate to set
     */
    public void setTweetDate(Date twittDate) {
        this.tweetDate = twittDate;
    }
}