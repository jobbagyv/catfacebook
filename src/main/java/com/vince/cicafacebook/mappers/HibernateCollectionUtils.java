package com.vince.cicafacebook.mappers;

import org.hibernate.Hibernate;
import org.mapstruct.Condition;

import java.util.Collection;

public class HibernateCollectionUtils {

    @Condition
    public static <T> boolean isCollectionAvailable(Collection<T> collection) {
        if (collection == null) {
            return false;
        }

        return Hibernate.isInitialized(collection);
    }

}