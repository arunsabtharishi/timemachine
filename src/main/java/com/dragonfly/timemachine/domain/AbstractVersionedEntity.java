package com.dragonfly.timemachine.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class AbstractVersionedEntity extends AbstractAuditableEntity {

    @Version
    protected int lockVersion;

    /**
     * Gets lock version, used for optimistic locking.
     */
    public int getLockVersion() {
        return lockVersion;
    }

    /**
     * <p>Sets lock version, used for optimistic locking.</p>
     * 
     * <p><strong>Note</strong>: Shouldn't be set except by JPA, 
     * setter needed for matching getter/setter for conversion 
     * between entities and JAXB beans.
     */
    public void setLockVersion(int lockVersion) {
        this.lockVersion = lockVersion;
    }
    
}