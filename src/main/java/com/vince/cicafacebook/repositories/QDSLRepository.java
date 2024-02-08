package com.vince.cicafacebook.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class QDSLRepository {
    private final EntityManager entityManager;

    protected JPAQueryFactory getQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }
}
