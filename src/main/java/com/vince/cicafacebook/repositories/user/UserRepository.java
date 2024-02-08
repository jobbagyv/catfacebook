package com.vince.cicafacebook.repositories.user;

import com.vince.cicafacebook.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom {
}
