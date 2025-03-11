package edu.ntudp.pzks.lab6.repository;

import edu.ntudp.pzks.lab6.model.Student;
import edu.ntudp.pzks.lab6.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements HumanRepository<Student>{
    ConnectionManager connectionManager = new ConnectionManager();

    private List<Student> extractStudents(ResultSet resultSet) {
        List<Student> students = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Student student = new Student();

            try {
                student.setId(resultSet.getLong("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setMiddleName(resultSet.getString("middle_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setBirthDate(resultSet.getDate("birth_date"));
                student.setRecordBookNumber(resultSet.getString("record_book_number"));

                students.add(student);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return students;
    }

    @Override
    public void save(Student student) {
        if (student.isFilled()){
            String query = "INSERT INTO Students (first_name, middle_name, last_name, birth_date, record_book_number) " +
                    "VALUES (?, ?, ?, ?, ?)";

            try (Connection connection = connectionManager.open();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setString(1, student.getFirstName());
                preparedStatement.setString(2, student.getMiddleName());
                preparedStatement.setString(3, student.getLastName());
                preparedStatement.setDate(4, student.getBirthDate());
                preparedStatement.setString(5, student.getRecordBookNumber());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Error during student save: ", e);
            }
        }
        else{
            throw new IllegalArgumentException("Error: Student have null data!");
        }
    }

    @Override
    public List<Student> getAll() {
        String query = "SELECT * FROM `Students`";
        List<Student> students;

        try (Connection connection = connectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            students = extractStudents(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException("Error during student getAll: ", e);
        }
        return students;
    }

    @Override
    public List<Student> getByMonthOfBirthDate(int month) {
        String query = "SELECT * FROM `Students` WHERE MONTH(birth_date) = ?";
        List<Student> students;

        try (Connection connection = connectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, month);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                students = extractStudents(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error during student getByMonthOfBirthDate: ", e);
        }
        return students;
    }

    @Override
    public void delete(Student student) {
        String query = "DELETE FROM `Students` WHERE `id` = ?";

        try (Connection connection = connectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, student.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new RuntimeException("Error: Student with this ID not found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error during student deleting: ", e);
        }
    }

}
