package codegym_management_system.service;

import codegym_management_system.utils.TeacherException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ITeacherService {
    void addTeacher() throws TeacherException;

    void displayAllTeacher();

    void removeTeacher();

    void searchTeacher();

    void sortTeacher();
}
