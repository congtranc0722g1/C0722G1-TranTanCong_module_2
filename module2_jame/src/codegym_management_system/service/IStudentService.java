package codegym_management_system.service;

import codegym_management_system.utils.StudentException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IStudentService {
    void addStudent() throws StudentException;

    void displayAllStudent();

    void removeStudent();

    void searchStudent();

    void sortStudent();

}
