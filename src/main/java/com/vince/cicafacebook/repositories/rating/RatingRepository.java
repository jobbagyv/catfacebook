package com.vince.cicafacebook.repositories.rating;

import com.vince.cicafacebook.entities.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long>, RatingRepositoryCustom {
}
