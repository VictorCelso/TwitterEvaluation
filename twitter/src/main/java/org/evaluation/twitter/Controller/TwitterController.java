package org.evaluation.twitter.Controller;

import java.util.Set;

import org.evaluation.twitter.Entity.Tweet;
import org.evaluation.twitter.Entity.User;
import org.evaluation.twitter.Service.ITwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twitt")
public class TwitterController {
    @Autowired
    ITwitterService iTwitterService;

    @RequestMapping(method = RequestMethod.POST, params = { "id",
            "name" }, path = "/api/createUser", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> create(int id, String name) {

        return new ResponseEntity<User>(iTwitterService.createAccount(id, name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, params = { "id",
            "content" }, path = "/api/tweet", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Tweet> tweet(int id, String content) {

        try {
            return new ResponseEntity<Tweet>(iTwitterService.tweet(id, content), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = { "id" }, path = "/api/getNews", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Set<Tweet>> showTweets(int id) {
        try {
            
            return new ResponseEntity<Set<Tweet>>(iTwitterService.showTweetes(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Set<Tweet>>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.GET, params = { "id",
            "followed" }, path = "/api/follow", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<HttpStatus> follow(int id, int followed) {
        try {
            iTwitterService.follow(id, followed);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.GET, params = { "id",
            "followed" }, path = "/api/unfollow", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> unfollow(int id, int followed) {
        iTwitterService.unfollow(id, followed);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}