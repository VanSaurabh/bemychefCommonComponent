package com.bemychef.commonComponent.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bemychef.commonComponent.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
	
}
