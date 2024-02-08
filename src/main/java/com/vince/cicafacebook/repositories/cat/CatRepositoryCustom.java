package com.vince.cicafacebook.repositories.cat;

import com.vince.cicafacebook.entities.Cat;

import java.util.List;

public interface CatRepositoryCustom {
    public List<Cat> findAllWithRatings();
    public Cat findWithRatings(Long id);
}
