package org.evaluation.twitter.Repository;

import javax.annotation.ManagedBean;

import org.evaluation.twitter.Entity.Tweet;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * UserRepository
 */
@ManagedBean
public interface TweetRepository extends PagingAndSortingRepository<Tweet,Integer>{

}