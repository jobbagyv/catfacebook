package com.vince.cicafacebook.repositories.cat;

import com.vince.cicafacebook.entities.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long>, CatRepositoryCustom {

}
