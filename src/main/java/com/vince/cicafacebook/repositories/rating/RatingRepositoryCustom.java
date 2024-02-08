package com.vince.cicafacebook.repositories.rating;

import com.vince.cicafacebook.entities.Cat;

import java.util.List;

public interface RatingRepositoryCustom {
    public void fetchForCats(List<Cat> cats);
}
