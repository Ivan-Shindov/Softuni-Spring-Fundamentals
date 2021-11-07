package bg.softuni.hateoas.model.dto;

public class OrderDto {

    private Long id;
    private Long studentID;
    private Long courseID;

    public OrderDto() {

    }

    public Long getId() {
        return id;
    }

    public OrderDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getStudentID() {
        return studentID;
    }

    public OrderDto setStudentID(Long studentID) {
        this.studentID = studentID;
        return this;
    }

    public Long getCourseID() {
        return courseID;
    }

    public OrderDto setCourseID(Long courseID) {
        this.courseID = courseID;
        return this;
    }
}
