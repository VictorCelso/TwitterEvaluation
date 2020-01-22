package org.evaluation.twitter.Repository;

import javax.annotation.ManagedBean;

import org.evaluation.twitter.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * UserRepository
 */
@ManagedBean
public interface UserRepository extends PagingAndSortingRepository<User,String>{

}