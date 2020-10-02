package com.hari.dtopattern;

import java.time.LocalDateTime;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hari.dtopattern.DtoEntity.ViewDTO;
import com.hari.dtopattern.dao.OrderDao;
import com.hari.dtopattern.dao.StudentDao;
import com.hari.dtopattern.entity.Order;
import com.hari.dtopattern.entity.Student;

@SpringBootApplication
public class DtopatternApplication implements CommandLineRunner {
	@Autowired
	StudentDao studentDao;

	@Autowired
	OrderDao orderDao;

	public static void main(String[] args) {
		SpringApplication.run(DtopatternApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println("DtopatternApplication.run");
		Student student = Student.builder().name("hariom").password("password123").build();
		studentDao.save(student);
		studentDao.save(student);

		Order order = Order.builder().orderName("order hariom").status("active").build();
		orderDao.save(order);

		System.out.println("student = " + student);
		System.out.println("order = " + order);
		ViewDTO viewDTO = ViewDTO.builder().student(Arrays.asList(student)).order(order).build();
		System.out.println("finalDto = " + viewDTO);
	}

	private ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}
}
