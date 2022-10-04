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
        employeeList = readFileEmployee();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void editEmployees() {
        employeeList = readFileEmployee();
        String codeEdit;
        System.out.println("Enter the employee code to edit: ");
        codeEdit = scanner.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCode().equals(codeEdit)){
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
                if (Regex.checkCodePerson(code)){
                    break;
                }else {
                    System.out.println("Invalid employee CODE format. Please re-enter");
                }
            } catch (CodeException e) {
                e.printStackTrace();
            }
        }

        String name;
        while (true){
            try {
                System.out.println("Enter employee name (Ex: Nguyễn văn A): ");
                name = scanner.nextLine();
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")){
                    break;
                }else {
                    System.out.println("The input name is not in the correct format. Please re-enter");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        LocalDate localDate = LocalDate.now();
        LocalDate dateOfBirth;
        while (true){
            try {
                System.out.println("Enter employee's date of birth (dd/MM/yyyy): ");
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
                System.out.println("Enter employee gender(1.Male, 2.Female, 3.Other):");
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
                System.out.println("Enter the employee's identity card number(Ex: 384709875847): ");
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
                System.out.println("Enter employee phone number(Ex: 0901961xxx): ");
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
                System.out.println("Enter employee level \n(1. Intermediate level, 2.College level, 3. University level, 4. Postgraduate level): ");
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
                System.out.println("Enter position (1. Reception, 2. Serve,\n 3. Expert, 4. Supervise, 5. Administer, 6. Director)");
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
            System.out.println("Enter employee salary (Ex: 5000000VND): ");
            salary = scanner.nextLine();
            if(Regex.checkSalary(salary)){
                break;
            }else {
                System.out.println("The format is not correct. Please re-enter");
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
