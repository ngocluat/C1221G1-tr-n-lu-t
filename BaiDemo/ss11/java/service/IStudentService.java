package service;

import model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<Student> getListStudent();

    Map<String, String> save(Student student);
}
