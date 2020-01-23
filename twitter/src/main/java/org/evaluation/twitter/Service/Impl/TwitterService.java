package org.evaluation.twitter.Service.Impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.evaluation.twitter.Entity.Follower;
import org.evaluation.twitter.Entity.Tweet;
import org.evaluation.twitter.Entity.User;
import org.evaluation.twitter.Repository.FollowerRepository;
import org.evaluation.twitter.Repository.TweetRepository;
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

    @PersistenceContext
    EntityManager manager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    FollowerRepository followerRepository;

    @Override
    public User createAccount(int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    @Override
    public Tweet tweet(int id, String publication) throws Exception {
        Tweet tweet = new Tweet();
        //Caso usuario não exista lança excessão.
        User user = userRepository.findById(id)
        .orElseThrow(() -> new Exception("Id de Usuario não existente"));
        tweet.setContent(Optional.ofNullable(publication).orElse(""));
        //Criando data e hora de postagem para ordenação de Tweets
        tweet.setTweetDate(new Date());
        tweetRepository.save(tweet);
        //Associando Tweet ao usuario.
        user.getTweets().add(tweet);
        userRepository.save(user);
        return tweet;
    }

    @Override
    public Set<Tweet> showTweetes(int id) throws Exception {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new Exception("Id de Usuario não existente"));
        //Lista 10 primeiros Tweets do usuario ordenados pela data e hora.
        Set<Tweet> tweets = user.getTweets().stream()
        .sorted(Comparator.comparing(Tweet::getTweetDate))
        .limit(10).collect(Collectors.toSet());
        //Chamada para instanciar lista de seguidores por LAZY Fetch
        user.getFollowers();
        //Desataxando entidade da base para não ocorrer excessões por tentativa de associar outros Tweets com o usuario.
        manager.detach(user);
        //Varrer usarios que está seguindo para pegar os 10 primeiros Tweets dos mesmos.
        user.getFollowers().forEach(f -> {
            tweets.addAll(userRepository.findById(f.getFollowed().getId()).map(User::getTweets).orElse(new HashSet<>())
                    .stream().sorted(Comparator.comparing(Tweet::getTweetDate)).collect(Collectors.toSet()));
        });
        return tweets;
    }

    @Override
    public void follow(int followerId, int followedId) throws Exception {
        Follower follower = new Follower();
        follower.setFollowerID(followerId);
        follower.setFollowed(
                userRepository.findById(followedId).orElseThrow(() -> new Exception("Id de Usuario não existente")));
        followerRepository.save(follower);
    }

    @Override
    public void unfollow(int followerId, int followedId) {
        followerRepository.deleteById(followerId);
    }

}