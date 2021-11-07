package bg.softuni.hateoas.web;

import bg.softuni.hateoas.mapping.StudentMapper;
import bg.softuni.hateoas.model.dto.OrderDto;
import bg.softuni.hateoas.model.dto.StudentDto;
import bg.softuni.hateoas.model.entity.StudentEntity;
import bg.softuni.hateoas.repository.StudentRepository;
import javassist.NotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class StudentController {

    //Just for example, I use repository instead service
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentController(StudentRepository studentRepository,
                             StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    @GetMapping("/students")
    public ResponseEntity<CollectionModel<EntityModel<StudentDto>>> getStudents() {

        List<EntityModel<StudentDto>> allStudents = this.studentRepository.findAll()
                .stream()
                .map(student -> this.studentMapper.mapEntityToDto(student))
                .map(dto -> {
                    try {
                        return EntityModel.of(dto, createStudentLinks(dto));
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(allStudents));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<EntityModel<StudentDto>> update(@PathVariable Long id,
                                                          StudentDto studentDto) {

        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<EntityModel<StudentDto>> getStudentById(@PathVariable Long id) throws NotFoundException {
            StudentDto studentDto = studentRepository.findById(id)
                    .map(student -> studentMapper.mapEntityToDto(student))
                    .orElseThrow(() -> new NotFoundException("Student not found"));

            return ResponseEntity.ok(
                    EntityModel.of(studentDto, createStudentLinks(studentDto))
            );
    }

    @GetMapping("/students/{id}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrderDto>>> getOrders(@PathVariable Long id) {

        StudentEntity studentEntity = studentRepository.findById(id)
                .orElse(null);

        List<EntityModel<OrderDto>> orders = studentEntity.getOrders()
                .stream()
                .map(order -> studentMapper.mapToOrderDto(order))
                .map(dto -> EntityModel.of(dto))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(orders));
    }

    private Link[] createStudentLinks(StudentDto studentDto) throws NotFoundException {
        List<Link> result = new ArrayList<>();

        Link selfLink = linkTo(methodOn(StudentController.class)
                        .getStudentById(studentDto.getId()))
                .withSelfRel();
        result.add(selfLink);

        Link updateLink = linkTo(methodOn(StudentController.class)
                .update(studentDto.getId(),studentDto)).withRel("update");
        result.add(updateLink);

        Link ordersLink = linkTo(methodOn(StudentController.class)
                .getOrders(studentDto.getId())).withRel("orders");
        result.add(ordersLink);


        return result.toArray(new Link[0]);
    }

}
