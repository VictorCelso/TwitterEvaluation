package org.evaluation.twitter.Service;

import java.util.Set;

import org.evaluation.twitter.Entity.Tweet;
import org.evaluation.twitter.Entity.User;

/**
 * ITwitterService
 */
public interface ITwitterService {
    public User createAccount(int id, String name);

    public Tweet tweet(int id, String publication) throws Exception;

    public Set<Tweet> showTweetes(int id) throws Exception;

    public void follow(int followerId, int followedId) throws Exception;

    public void unfollow(int followerId, int followedId);
}