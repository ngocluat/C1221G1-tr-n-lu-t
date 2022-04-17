package repository;

import dto.StudentListDTO;
import model.Student;

import java.util.List;

public interface IStudentRepository extends ICrudRepository<Student> {
    List<StudentListDTO> getList();
}
