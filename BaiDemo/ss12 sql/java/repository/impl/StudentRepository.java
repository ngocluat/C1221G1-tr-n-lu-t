package repository.impl;

import dto.StudentListDTO;
import model.Student;
import repository.BaseRepository;
import repository.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private BaseRepository baseRepository = new BaseRepository();


    @Override
    public List<StudentListDTO> getList() {
        List<StudentListDTO> studentList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
//            Cách 1
//            Statement statement = this.baseRepository.getConnectionJavaToDB().createStatement();
//            statement.executeQuery("select code_student, name_student, date_of_birth, gender, point from student");

//            Cách 2:
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select code_student, name_student, date_of_birth, gender, point, name_class from student inner join `class` on student.code_class = `class`.code_class");
            ResultSet resultSet = preparedStatement.executeQuery();
            StudentListDTO student;
            while (resultSet.next()) {
                student = new StudentListDTO();
                student.setId(resultSet.getInt("code_student"));
                student.setName(resultSet.getString("name_student"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                student.setGrade(resultSet.getDouble("point"));
                student.setGender(resultSet.getInt("gender"));
                student.setNameClass(resultSet.getString("name_class"));
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        PreparedStatement preparedStatement = null;
        try {
//            Statement statement = this.baseRepository.getConnectionJavaToDB().createStatement();
//            statement.executeUpdate("insert into student(code_student, name_student, date_of_birth, gender, point) value ("+student.getId()+","+student.getName()+","+")");

            preparedStatement = this.baseRepository.getConnectionJavaToDB()
            .prepareStatement("insert into student(name_student, date_of_birth, gender, point) value (?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDateOfBirth());
            preparedStatement.setInt(3, student.getGender());
            preparedStatement.setDouble(4, student.getGrade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Student> search(String name) {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
//            Cách 1
//            Statement statement = this.baseRepository.getConnectionJavaToDB().createStatement();
//            statement.executeQuery("select code_student, name_student, date_of_birth, gender, point from student");

//            Cách 2:
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select code_student, name_student, date_of_birth, gender, point from student where name_student like ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("code_student"));
                student.setName(resultSet.getString("name_student"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                student.setGrade(resultSet.getDouble("point"));
                student.setGender(resultSet.getInt("gender"));
                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }
}
