package codegym_management_system.view;

import codegym_management_system.controller.CodeGymController;
import codegym_management_system.utils.StudentException;
import codegym_management_system.utils.TeacherException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws StudentException, TeacherException, IOException {
        CodeGymController.menuCodegym();
    }
}
