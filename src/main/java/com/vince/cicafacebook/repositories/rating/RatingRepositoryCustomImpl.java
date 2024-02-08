package com.vince.cicafacebook.repositories.rating;

import com.vince.cicafacebook.entities.Cat;
import com.vince.cicafacebook.entities.QRating;
import com.vince.cicafacebook.entities.Rating;
import com.vince.cicafacebook.repositories.QDSLRepository;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RatingRepositoryCustomImpl extends QDSLRepository implements RatingRepositoryCustom{
    public RatingRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void fetchForCats(List<Cat> cats) {
        Map<Long, Cat> catMap = cats.stream().collect(Collectors.toMap(cat->cat.getId(), cat->cat));
        List<Rating> ratings = getQueryFactory().selectFrom(QRating.rating)
                .where(QRating.rating.cat.in(cats))
                .fetch();
        cats.forEach(cat->cat.setRatings(new ArrayList<>()));
        ratings.forEach(r->catMap.get(r.getCat().getId()).getRatings().add(r));
    }
}
