package com.hari.dtopattern.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hari.dtopattern.DtoEntity.ViewDTO;
import com.hari.dtopattern.dao.OrderDao;
import com.hari.dtopattern.dao.StudentDao;
import com.hari.dtopattern.entity.Order;
import com.hari.dtopattern.entity.Student;
import lombok.extern.slf4j.Slf4j;

/**
 * @author HariomYadav
 * @since 02/10/20
 */
@RestController
@RequestMapping ("/api/v1")
@Slf4j
public class StudentResource {
    @Autowired
    StudentDao studentDao;

    @Autowired
    OrderDao orderDao;

    @RequestMapping (method = RequestMethod.GET)
    public ViewDTO getDTO() {
        log.info("StudentResource.getDTO");
        final Student student = studentDao.findById(1l).get();
        log.info("student = " + student);
        final Order order = orderDao.findById(1l).get();
        log.info("order = " + order);
        final ViewDTO viewDTO = ViewDTO.builder().student(Arrays.asList(student, student, student)).order(order).build();
        log.info("viewDTO = " + viewDTO);
        return viewDTO;
    }

    @RequestMapping (method = RequestMethod.POST)
    public void setStudentDao() {
        log.info("StudentResource.setStudentDao");
        final Optional<Student> optionalStudent = studentDao.findById(1l);
        optionalStudent.ifPresent(student1 -> {
            student1.setName("chandan yadav");
            studentDao.save(student1);
            student1.setName("chandan yadav12");
            studentDao.save(student1);
        });
    }

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    public List<Student> getAllStudent() {
        log.info("StudentResource.getAllStudent");
        final List<Student> students = studentDao.findAll();
        log.info("students = " + students);
        return students;
    }
}
