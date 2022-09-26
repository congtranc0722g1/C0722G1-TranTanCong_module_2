package codegym_management_system.service;

import codegym_management_system.utils.TeacherException;

public interface ITeacherService {
    void addTeacher() throws TeacherException;

    void displayAllTeacher();

    void removeTeacher();

    void searchTeacher();

    void sortTeacher();
}
