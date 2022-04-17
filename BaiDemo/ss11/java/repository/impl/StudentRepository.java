package repository.impl;

import model.Student;
import repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
         static {
             studentList.add(new Student(1,"haiTT","01/01/1000",1,6.0));
             studentList.add(new Student(1,"haiTT","01/01/1000",1,7.0));
             studentList.add(new Student(1,"haiTT","01/01/1000",1,8.0));
             studentList.add(new Student(1,"haiTT","01/01/1000",1,9.0));
             studentList.add(new Student(1,"haiTT","01/01/1000",1,10.0));
         }


    @Override
    public List<Student> getList() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }
}
