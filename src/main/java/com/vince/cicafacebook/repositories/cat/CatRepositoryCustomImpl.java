package com.vince.cicafacebook.repositories.cat;

import com.vince.cicafacebook.entities.Cat;
import com.vince.cicafacebook.entities.QCat;
import com.vince.cicafacebook.repositories.QDSLRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatRepositoryCustomImpl extends QDSLRepository implements CatRepositoryCustom{
    public CatRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Cat> findAllWithRatings() {
        return getQueryFactory()
                .selectFrom(QCat.cat)
                .join(QCat.cat.ratings)
                .fetchJoin()
                .fetch();
    }

    @Override
    public Cat findWithRatings(Long id) {
        return getQueryFactory()
                .selectFrom(QCat.cat)
                .join(QCat.cat.ratings)
                .fetchJoin()
                .where(QCat.cat.id.eq(id))
                .fetchOne();
    }
}
