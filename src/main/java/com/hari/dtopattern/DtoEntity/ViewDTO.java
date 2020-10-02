package com.hari.dtopattern.DtoEntity;

import java.util.ArrayList;
import java.util.List;
import com.hari.dtopattern.entity.Order;
import com.hari.dtopattern.entity.Student;
import lombok.Builder;
import lombok.Data;

/**
 * @author HariomYadav
 * @since 02/10/20
 */
@Data
public class ViewDTO {
        List<Student> student = new ArrayList<>();
        Order order;

        @Builder
        public ViewDTO(List<Student> student, Order order) {
                this.student = student;
                this.order = order;
        }
}
