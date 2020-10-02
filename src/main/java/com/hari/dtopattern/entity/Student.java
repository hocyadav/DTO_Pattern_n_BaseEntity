package com.hari.dtopattern.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
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