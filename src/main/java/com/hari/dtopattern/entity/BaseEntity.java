package com.hari.dtopattern.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author HariomYadav
 * @since 02/10/20
 * https://www.objectdb.com/api/java/jpa/MappedSuperclass
 */
@Getter
@Setter
@NoArgsConstructor
@Slf4j
@MappedSuperclass//IMP - Getter , Setter is optional but add
public class BaseEntity implements Serializable {//IMP : serializable to make our entity to easily transfer via network

    @JsonIgnore//IMP : make this field not availble(since this is pk) in json response
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    @Column (updatable = false)//IMP : only assign 1st time
    String externalId = UUID.randomUUID().toString();

    @JsonIgnore
    @Column (updatable = false)
    LocalDateTime created = LocalDateTime.now();

    LocalDateTime updated = LocalDateTime.now();//TODO 2 : add auto insert logic -DONE

    @Version
    @JsonIgnore
    Integer version;

//    @PrePersist //before running any query on table this method will execute
//    public void prePersist() {
//        System.err.println("BaseEntity.prePersist");
//        //externalId = Strings.isBlank(externalId) ? UUID.randomUUID().toString() : externalId;
//    }

    @PreUpdate //before writting into db this method will call, e.g. set some field values and save into db
    public void preUpdate() {
        log.info("BaseEntity.preUpdate");
        updated = LocalDateTime.now();
    }
}
