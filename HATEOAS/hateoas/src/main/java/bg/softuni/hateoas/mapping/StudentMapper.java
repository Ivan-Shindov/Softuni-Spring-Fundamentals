package bg.softuni.hateoas.mapping;

import bg.softuni.hateoas.model.dto.OrderDto;
import bg.softuni.hateoas.model.dto.StudentDto;
import bg.softuni.hateoas.model.entity.OrderEntity;
import bg.softuni.hateoas.model.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto mapEntityToDto(StudentEntity student);

    @Mapping(source = "orderEntity.student.id", target = "studentID")
    @Mapping(source = "orderEntity.course.id", target = "courseID")
    OrderDto mapToOrderDto(OrderEntity orderEntity);
}
