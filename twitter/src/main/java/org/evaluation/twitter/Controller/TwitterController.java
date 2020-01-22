package org.evaluation.twitter.Controller;

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

    @RequestMapping(method = RequestMethod.POST,params = {"id","name"} ,
    path = "/api/createUser", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> create(String id, String name) {

        return new ResponseEntity<User>(iTwitterService.createAccount(id, name), HttpStatus.OK);
    }

}