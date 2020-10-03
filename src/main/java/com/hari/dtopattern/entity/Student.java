package com.hari.dtopattern.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author HariomYadav
 * @since 02/10/20
 */
@Getter
@Setter
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "students")//IMP
public class Student extends BaseEntity {//TODO 1 : move common things in super class, PK and CreateDate - DONE
    String name;
    String password;

    @Builder//IMP
    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }
}