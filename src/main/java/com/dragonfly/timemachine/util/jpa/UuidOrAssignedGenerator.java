package com.dragonfly.timemachine.util.jpa;

/**
 * Created by Arun on 9/4/2015.
 */
import java.io.Serializable;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.UUIDGenerator;

public class UuidOrAssignedGenerator extends UUIDGenerator {

    @Override
    public Serializable generate(SessionImplementor session, Object object) {
        Class<? extends Object> objClass = object.getClass();
        IdAssigned annotation = objClass.getAnnotation(IdAssigned.class);

        if (annotation != null && annotation.value()) {
            // if the annotation is present, return the object identifier
            return session.getEntityPersister(null, object).getClassMetadata().getIdentifier(object, session);
        } else {
            return super.generate(session, object);
        }
    }
}