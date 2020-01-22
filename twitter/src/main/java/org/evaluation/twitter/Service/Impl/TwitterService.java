package org.evaluation.twitter.Service.Impl;

import org.evaluation.twitter.Entity.User;
import org.evaluation.twitter.Repository.UserRepository;
import org.evaluation.twitter.Service.ITwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TwitterService
 */
@Service
@Transactional
public class TwitterService implements ITwitterService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createAccount(String id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    @Override
    public void twitte(String id, String publication) {
        // TODO Auto-generated method stub

    }

    @Override
    public void showTwittes(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void follow(String followerId, String followedId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void unfollow(String followerId, String followedId) {
        // TODO Auto-generated method stub

    }

    
}