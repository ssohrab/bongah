package com.bongah.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bongah.entities.UserEntity;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Integer> 
{
	UserEntity findByEmailAddress(String emailAddress);
}
