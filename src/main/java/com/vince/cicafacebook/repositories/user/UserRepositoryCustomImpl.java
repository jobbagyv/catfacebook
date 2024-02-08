package com.vince.cicafacebook.repositories.user;

import com.vince.cicafacebook.entities.QCat;
import com.vince.cicafacebook.entities.QUser;
import com.vince.cicafacebook.entities.User;
import com.vince.cicafacebook.repositories.QDSLRepository;
import com.vince.cicafacebook.repositories.rating.RatingRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryCustomImpl extends QDSLRepository implements UserRepositoryCustom {

    RatingRepository ratingRepository;
    @Autowired
    public UserRepositoryCustomImpl(EntityManager em, RatingRepository ratingRepository){
        super(em);
        this.ratingRepository = ratingRepository;
    }
    @Override
    public User findEager(Long id) {
        User user = getQueryFactory().selectFrom(QUser.user)
                .join(QUser.user.cats, QCat.cat).fetchJoin()
                .where(QUser.user.id.eq(id))
                .fetchOne();
        ratingRepository.fetchForCats(user.getCats());
        return user;
    }

    @Override
    public List<User> findAllEager() {
        List<User> users = getQueryFactory().selectFrom(QUser.user)
                .join(QUser.user.cats, QCat.cat).fetchJoin()
                .fetch();
        ratingRepository.fetchForCats(users.stream().flatMap(user->user.getCats().stream()).toList());
        return users;
    }
}
