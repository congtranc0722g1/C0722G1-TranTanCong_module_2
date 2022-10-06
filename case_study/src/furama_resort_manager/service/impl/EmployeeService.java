package furama_resort_manager.service.impl;

import furama_resort_manager.model.person.Employee;
import furama_resort_manager.service.IEmployeeService;
import furama_resort_manager.service.IService;
import furama_resort_manager.utils.exception.CodeException;
import furama_resort_manager.utils.regex.Regex;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IService, IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();

    @Override
    public void displayListEmployees() {
        try {
            employeeList = readFileEmployee();
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            System.out.println("List is empty");
        }
    }

    @Override
    public void editEmployees() {
        String codeEdit;
        abc111:
        while (true){
            try {
                employeeList = readFileEmployee();
                System.out.println("Enter the employee code to edit: ");
                codeEdit = scanner.nextLine();
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getCode().equals(codeEdit)) {
                        String nameEdit;
                        while (true) {
                            try {
                                System.out.println("Enter new name (Ex: Nguyễn văn A): ");
                                nameEdit = scanner.nextLine();
                                if (Regex.checkName(nameEdit)){
                                    employeeList.get(i).setName(nameEdit);
                                    break;
                                } else {
                                    System.out.println("The input name is not in the correct format. Please re-enter");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        LocalDate localDate = LocalDate.now();
                        LocalDate dateOfBirthEdit;

                        while (true) {
                            try {
                                System.out.println("Enter new date of birth (dd/MM/yyyy): ");
                                String day = scanner.nextLine();
                                dateOfBirthEdit = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                employeeList.get(i).setDateOfBirth(dateOfBirthEdit);
                                break;
                            } catch (Exception e) {
                                System.out.println("The date of birth entered is not in the correct format, please re-enter");
                            }
                        }
                        String genderEdit;
                        abc11:
                        while (true) {
                            try {
                                System.out.println("Enter new gender:\n1.Male\n2.Female\n3.Other");
                                int tempGender = Integer.parseInt(scanner.nextLine());
                                switch (tempGender) {
                                    case 1:
                                        genderEdit = "Male";
                                        employeeList.get(i).setGender(genderEdit);
                                        break abc11;
                                    case 2:
                                        genderEdit = "Female";
                                        employeeList.get(i).setGender(genderEdit);
                                        break abc11;
                                    case 3:
                                        genderEdit = "Other";
                                        employeeList.get(i).setGender(genderEdit);
                                        break abc11;
                                    default:
                                        System.out.println("Please enter as required");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }

                        String idNumberEdit;
                        while (true) {
                            try {
                                System.out.println("Enter a new identity card number (Ex: 384709875847): ");
                                idNumberEdit = scanner.nextLine();
                                if (Regex.checkIdentityNumber(idNumberEdit)) {
                                    employeeList.get(i).setIdentityNumber(idNumberEdit);
                                    break;
                                } else {
                                    System.out.println("Invalid ID card number. Please re-enter");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String phoneNumberEdit;
                        while (true) {
                            try {
                                System.out.println("Enter new phone number (Ex: +84901961xxx): ");
                                phoneNumberEdit = scanner.nextLine();
                                if (Regex.checkPhoneNumber(phoneNumberEdit)) {
                                    employeeList.get(i).setPhoneNumber(phoneNumberEdit);
                                    break;
                                } else {
                                    System.out.println("invalid phone number");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String emailEdit;
                        while (true) {
                            try {
                                System.out.println("Enter new email (Ex: abc@gmail.com): ");
                                emailEdit = scanner.nextLine();
                                if (Regex.checkEmail(emailEdit)) {
                                    employeeList.get(i).setEmail(emailEdit);
                                    break;
                                } else {
                                    System.out.println("Invalid email. Please re-enter");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String levelEdit;
                        abc12:
                        while (true) {
                            try {
                                System.out.println("Enter new employee level:\n1. Intermediate level\n2.College level\n3. University level\n4. Postgraduate level");
                                int tempLevelEdit = Integer.parseInt(scanner.nextLine());
                                switch (tempLevelEdit) {
                                    case 1:
                                        levelEdit = "Intermediate level";
                                        employeeList.get(i).setLevel(levelEdit);
                                        break abc12;
                                    case 2:
                                        levelEdit = "College level";
                                        employeeList.get(i).setLevel(levelEdit);
                                        break abc12;
                                    case 3:
                                        levelEdit = "University level";
                                        employeeList.get(i).setLevel(levelEdit);
                                        break abc12;
                                    case 4:
                                        levelEdit = "Postgraduate level";
                                        employeeList.get(i).setLevel(levelEdit);
                                        break abc12;
                                    default:
                                        System.out.println("Please enter as required");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String positionEdit;
                        abc13:
                        while (true) {
                            try {
                                System.out.println("Enter position:\n1. Reception\n2. Serve\n3. Expert\n4. Supervise\n5. Administer\n6. Director");
                                int tempPositionEdit = Integer.parseInt(scanner.nextLine());
                                switch (tempPositionEdit) {
                                    case 1:
                                        positionEdit = "Reception";
                                        employeeList.get(i).setPosition(positionEdit);
                                        break abc13;
                                    case 2:
                                        positionEdit = "Serve";
                                        employeeList.get(i).setPosition(positionEdit);
                                        break abc13;
                                    case 3:
                                        positionEdit = "Expert";
                                        employeeList.get(i).setPosition(positionEdit);
                                        break abc13;
                                    case 4:
                                        positionEdit = "Supervise";
                                        employeeList.get(i).setPosition(positionEdit);
                                        break abc13;
                                    case 5:
                                        positionEdit = "Administer";
                                        employeeList.get(i).setPosition(positionEdit);
                                        break abc13;
                                    case 6:
                                        positionEdit = "Director";
                                        employeeList.get(i).setPosition(positionEdit);
                                        break abc13;
                                    default:
                                        System.out.println("Please enter as required");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String salaryEdit;
                        while (true) {
                            try {
                                System.out.println("Enter new employee salary (Ex: 5000000VND): ");
                                salaryEdit = scanner.nextLine();
                                if (Regex.checkSalary(salaryEdit)) {
                                    employeeList.get(i).setSalary(salaryEdit);
                                    break;
                                } else {
                                    System.out.println("The format is not correct. Please re-enter");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        System.out.println("Editing is successful");
                        writeFileEmployee(employeeList);
                        break abc111;
                    }
                }
                System.out.println("Code not found");
            } catch (Exception e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

    }

    @Override
    public void add() {
            employeeList = readFileEmployee();
            Employee employee = this.infoEmployee();
            employeeList.add(employee);
            writeFileEmployee(employeeList);
            System.out.println("Successfully added new");
    }

    public Employee infoEmployee() {
        String code;

        while (true){
            try {
                System.out.println("Enter employee code (Ex: NV-0000): ");
                code = scanner.nextLine();
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getCode().equals(code)){
                        throw new CodeException("Code cannot be duplicated. Please re-enter");
                    }
                }
                if (Regex.checkCodeEmployee(code)){
                    break;
                }else {
                    System.out.println("Invalid employee CODE format. Please re-enter");
                }
            } catch (CodeException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

        String name;
        while (true){
            try {
                System.out.println("Enter name (Ex: Nguyễn văn A): ");
                name = scanner.nextLine();
                if (Regex.checkName(name)){
                    break;
                }else {
                    System.out.println("The input name is not in the correct format. Please re-enter");
                }
            }catch (Exception e){
                System.out.println("Invalid syntax. Please try again");
            }
        }
        LocalDate localDate = LocalDate.now();
        LocalDate dateOfBirth;
        while (true){
            try {
                System.out.println("Enter date of birth (dd/MM/yyyy): ");
                String day = scanner.nextLine();
                dateOfBirth = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("The date of birth entered is not in the correct format, please re-enter");
            }
        }

        String gender;
        abc:
        while (true){
            try {
                System.out.println("Enter employee gender:\n1.Male\n2.Female\n3.Other");
                int tempGender = Integer.parseInt(scanner.nextLine());
                switch (tempGender){
                    case 1:
                        gender = "Male";
                        break abc;
                    case 2:
                        gender = "Female";
                        break abc;
                    case 3:
                        gender = "Other";
                        break abc;
                    default:
                        System.out.println("Please enter as required");
                }
            }catch (Exception e){
                System.out.println("Invalid syntax. Please try again");
            }
        }

        String identityNumber;

        while (true) {
            try {
                System.out.println("Enter identity card number (Ex: 384709875847): ");
                identityNumber = scanner.nextLine();
                if (Regex.checkIdentityNumber(identityNumber)){
                    break;
                }else {
                    System.out.println("Invalid ID card number. Please re-enter");
                }
            } catch (Exception e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

        String phoneNumber;
        while (true){
            try {
                System.out.println("Enter phone number(Ex: +84901961xxx): ");
                phoneNumber = scanner.nextLine();
                if (Regex.checkPhoneNumber(phoneNumber)){
                    break;
                }else {
                    System.out.println("invalid phone number");
                }
            } catch (Exception e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

        String email;
        while (true){
            try {
                System.out.println("Enter email (Ex: abc@gmail.com): ");
                email = scanner.nextLine();
                if (Regex.checkEmail(email)){
                    break;
                }else {
                    System.out.println("Invalid email. Please re-enter");
                }
            } catch (Exception e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

        String level;
        abc1:
        while (true){
            try {
                System.out.println("Enter employee level:\n1. Intermediate level\n2.College level\n3. University level\n4. Postgraduate level");
                int tempLevel = Integer.parseInt(scanner.nextLine());
                switch (tempLevel){
                    case 1:
                        level = "Intermediate level";
                        break abc1;
                    case 2:
                        level = "College level";
                        break abc1;
                    case 3:
                        level = "University level";
                        break abc1;
                    case 4:
                        level = "Postgraduate level";
                        break abc1;
                    default:
                        System.out.println("Please enter as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

        String position;
        abc2:
        while (true){
            try {
                System.out.println("Enter position:\n1. Reception\n2. Serve\n3. Expert\n4. Supervise\n5. Administer\n6. Director");
                int tempPosition = Integer.parseInt(scanner.nextLine());
                switch (tempPosition){
                    case 1:
                        position = "Reception";
                        break abc2;
                    case 2:
                        position = "Serve";
                        break abc2;
                    case 3:
                        position = "Expert";
                        break abc2;
                    case 4:
                        position = "Supervise";
                        break abc2;
                    case 5:
                        position = "Administer";
                        break abc2;
                    case 6:
                        position = "Director";
                        break abc2;
                    default:
                        System.out.println("Please enter as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

        String salary;

        while (true){
            try {
                System.out.println("Enter employee salary (Ex: 5000000VND): ");
                salary = scanner.nextLine();
                if(Regex.checkSalary(salary)){
                    break;
                }else {
                    System.out.println("The format is not correct. Please re-enter");
                }
            } catch (Exception e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

        Employee employee = new Employee(code, name, dateOfBirth, gender, identityNumber, phoneNumber, email, level, position, salary);
        return employee;
    }

    private List<Employee> readFileEmployee(){
        BufferedReader bufferedReader = null;
        String line;
        String[] info;
        Employee employee;

        try {
            employeeList = new ArrayList<>();
            File file = new File("src\\furama_resort_manager\\data\\employee.csv");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                info = line.split(",");
                employee = new Employee(info[0], info[1], LocalDate.parse(info[2]), info[3],info[4], info[5], info[6], info[7], info[8], info[9]);
                employeeList.add(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    private void writeFileEmployee(List<Employee> employees){
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\furama_resort_manager\\data\\employee.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList) {
                bufferedWriter.write(getInfo(employee));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getInfo (Employee employee){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",employee.getCode(), employee.getName(), employee.getDateOfBirth(), employee.getGender(), employee.getIdentityNumber(), employee.getPhoneNumber(), employee.getEmail(), employee.getLevel(), employee.getLevel(), employee.getSalary());
    }
}
