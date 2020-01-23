package org.evaluation.twitter.Repository;

import org.evaluation.twitter.Entity.Follower;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface FollowerRepository extends PagingAndSortingRepository<Follower,Integer>{

}