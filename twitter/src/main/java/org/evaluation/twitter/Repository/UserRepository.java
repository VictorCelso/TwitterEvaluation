package org.evaluation.twitter.Repository;

import org.evaluation.twitter.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>{
    
}