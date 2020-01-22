package org.evaluation.twitter.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Twitt
 */
@Table(name = "Twitt",schema = "TwitterEvaluation")
@Entity
public class Twitt {

    @Id
    @Column(unique = true, name = "TwittId", nullable = false)
    private int id;

    @PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "twittUser"),referencedColumnName = "UserId")
    private String userId;
    
    @Column(name = "content", nullable = false )
    String content;

    @Column(name = "TwittTime", nullable = false,columnDefinition = "Sysdate")
    Date twittDate;

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
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
}