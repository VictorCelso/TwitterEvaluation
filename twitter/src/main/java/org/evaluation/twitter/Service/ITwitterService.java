package org.evaluation.twitter.Service;

import org.evaluation.twitter.Entity.User;

/**
 * ITwitterService
 */
public interface ITwitterService {
    public User createAccount(String id, String name);

    public void twitte(String id, String publication);

    public void showTwittes(String id);

    public void follow(String followerId, String followedId);

    public void unfollow(String followerId, String followedId);
}