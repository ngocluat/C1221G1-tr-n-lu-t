package service;

import dto.StudentListDTO;
import model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<StudentListDTO> getListStudent();

    Map<String, String> save(Student student);

    List<Student> search(String name);
}
