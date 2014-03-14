package com.bongah.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bongah.entities.UserEntity;

public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Integer> 
{
	UserEntity findByFirstName(String firstName);
}
