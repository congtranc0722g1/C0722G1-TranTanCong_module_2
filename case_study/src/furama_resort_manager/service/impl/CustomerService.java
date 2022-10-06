package furama_resort_manager.service.impl;

import furama_resort_manager.model.person.Customer;
import furama_resort_manager.service.ICustomerService;
import furama_resort_manager.service.IService;
import furama_resort_manager.utils.exception.CodeException;
import furama_resort_manager.utils.regex.Regex;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements IService, ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerList = new LinkedList<>();
    @Override
    public void displayListCustomers() {
        try {
            customerList = readFileCustomer();
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            System.out.println("List is empty");
        }

    }

    @Override
    public void editCustomer() {
        String codeEdit;
        abc107:
        while (true){
            try {
                customerList = readFileCustomer();
                System.out.println("Enter the employee code to edit: ");
                codeEdit = scanner.nextLine();
                for (int i = 0; i < customerList.size(); i++) {
                    if (customerList.get(i).getCode().equals(codeEdit)){
                        String nameEdit;
                        while (true){
                            try {
                                System.out.println("Enter new name (Ex: Nguyễn văn A): ");
                                nameEdit = scanner.nextLine();
                                if (nameEdit.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")){
                                    customerList.get(i).setName(nameEdit);
                                    break;
                                }else {
                                    System.out.println("The input name is not in the correct format. Please re-enter");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        LocalDate localDate = LocalDate.now();
                        LocalDate dateOfBirthEdit;
                        while (true){
                            try {
                                System.out.println("Enter new date of birth (dd/MM/yyyy): ");
                                String day = scanner.nextLine();
                                dateOfBirthEdit = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                customerList.get(i).setDateOfBirth(dateOfBirthEdit);
                                break;
                            } catch (Exception e) {
                                System.out.println("The date of birth entered is not in the correct format, please re-enter");
                            }
                        }
                        String genderEdit;
                        abc109:
                        while (true){
                            try {
                                System.out.println("Enter new gender(1.Male, 2.Female, 3.Other): ");
                                int tempGender = Integer.parseInt(scanner.nextLine());
                                switch (tempGender){
                                    case 1:
                                        genderEdit = "Male";
                                        customerList.get(i).setGender(genderEdit);
                                        break abc109;
                                    case 2:
                                        genderEdit = "Female";
                                        customerList.get(i).setGender(codeEdit);
                                        break abc109;
                                    case 3:
                                        genderEdit = "Other";
                                        break abc109;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String idNumberEdit;
                        while (true){
                            try {
                                System.out.println("Enter a new identity card number (Ex: 384709875847): ");
                                idNumberEdit = scanner.nextLine();
                                if (Regex.checkIdentityNumber(idNumberEdit)){
                                    customerList.get(i).setIdentityNumber(idNumberEdit);
                                    break;
                                }else {
                                    System.out.println("Invalid ID card number. Please re-enter");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String phoneNumberEdit;
                        while (true){
                            try {
                                System.out.println("Enter new phone number (Ex: +84901961xxx): ");
                                phoneNumberEdit = scanner.nextLine();
                                if (Regex.checkPhoneNumber(phoneNumberEdit)){
                                    customerList.get(i).setPhoneNumber(phoneNumberEdit);
                                    break;
                                }else {
                                    System.out.println("invalid phone number");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String emailEdit;
                        while (true){
                            try {
                                System.out.println("Enter new email (Ex: abc@gmail.com): ");
                                emailEdit = scanner.nextLine();
                                if (Regex.checkEmail(emailEdit)){
                                    customerList.get(i).setEmail(emailEdit);
                                    break;
                                }else {
                                    System.out.println("Invalid email. Please re-enter");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String guestTypeEdit;
                        abc108:
                        while (true){
                            try {
                                System.out.println("Enter new guest type (1. Diamond, 2. Platinium, 3. Gold, 4. Silver, 5. Member: ");
                                int tempGuestType = Integer.parseInt(scanner.nextLine());
                                switch (tempGuestType){
                                    case 1:
                                        guestTypeEdit = "Diamond";
                                        customerList.get(i).setGuestType(guestTypeEdit);
                                        break abc108;
                                    case 2:
                                        guestTypeEdit = "Platinium";
                                        customerList.get(i).setGuestType(guestTypeEdit);
                                        break abc108;
                                    case 3:
                                        guestTypeEdit = "Gold";
                                        customerList.get(i).setGuestType(guestTypeEdit);
                                        break abc108;
                                    case 4:
                                        guestTypeEdit = "Silver";
                                        customerList.get(i).setGuestType(guestTypeEdit);
                                        break abc108;
                                    case 5:
                                        guestTypeEdit = "Member";
                                        customerList.get(i).setGuestType(guestTypeEdit);
                                        break abc108;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        String addressEdit;
                        while (true){
                            try {
                                System.out.println("Enter new address: ");
                                addressEdit = scanner.nextLine();
                                customerList.get(i).setAddress(addressEdit);
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid syntax. Please try again");
                            }
                        }
                        System.out.println("Editing is successful");
                        writeFileCustomer(customerList);
                        break abc107;
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
        customerList =readFileCustomer();
        Customer customer = this.infoCustomer();
        customerList.add(customer);
        writeFileCustomer(customerList);
        System.out.println("Successfully added new");
    }

    public Customer infoCustomer(){
        String code;
        while (true){
            try {
                System.out.println("Enter customer code (Ex: KH-0000): ");
                code = scanner.nextLine();
                for (int i = 0; i < customerList.size(); i++) {
                    if(customerList.get(i).getCode().equals(code)){
                        throw new CodeException("Code cannot be duplicated. Please re-enter");
                    }
                }
                if (Regex.checkCodeCustomer(code)){
                    break;
                }else {
                    System.out.println("Invalid customer CODE format. Please re-enter");
                }
            } catch (CodeException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
        String name;
        while (true){
            try {
                System.out.println("Enter name (Nguyễn Văn A): ");
                name =scanner.nextLine();
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")){
                    break;
                }else {
                    System.out.println("The input name is not in the correct format. Please re-enter");
                }
            } catch (Exception e) {
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
        abc100:
        while (true){
            try {
                System.out.println("Enter  gender(1.Male, 2.Female, 3.Other):");
                int tempGender = Integer.parseInt(scanner.nextLine());
                switch (tempGender){
                    case 1:
                        gender = "Male";
                        break abc100;
                    case 2:
                        gender = "Female";
                        break abc100;
                    case 3:
                        gender = "Other";
                        break abc100;
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
        String guestType;
        abc101:
        while (true){
            try {
                System.out.println("Enter guest type (1. Diamond, 2. Platinium, 3. Gold, 4. Silver, 5. Member: ");
                int tempGuestType = Integer.parseInt(scanner.nextLine());
                switch (tempGuestType){
                    case 1:
                        guestType = "Diamond";
                        break abc101;
                    case 2:
                        guestType = "Platinium";
                        break abc101;
                    case 3:
                        guestType = "Gold";
                        break abc101;
                    case 4:
                        guestType = "Silver";
                        break abc101;
                    case 5:
                        guestType = "Member";
                        break abc101;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

        String address;
        while (true){
            try {
                System.out.println("Enter address: ");
                address = scanner.nextLine();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Customer customer = new Customer(code,name,dateOfBirth,gender, identityNumber, phoneNumber, email,guestType,address);
        return customer;
    }
    private List<Customer> readFileCustomer(){
        BufferedReader bufferedReader = null;
        String line;
        String[] info;
        Customer customer;

        try {
            customerList = new LinkedList<>();
            File file = new File("src\\furama_resort_manager\\data\\customer.csv");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                info = line.split(",");
                customer = new Customer(info[0],info[1],LocalDate.parse(info[2]),info[3],info[4],info[5],info[6],info[7],info[8]);
                customerList.add(customer);
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
        return customerList;
    }

    private void writeFileCustomer(List<Customer> customers){
        BufferedWriter bufferedWriter = null;

        try {
            File file = new File("src\\furama_resort_manager\\data\\customer.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.write(getInfo(customer));
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

    private String getInfo(Customer customer){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",customer.getCode(),customer.getName(),customer.getDateOfBirth(),customer.getGender(),customer.getIdentityNumber(),customer.getPhoneNumber(),customer.getEmail(),customer.getGuestType(),customer.getAddress());
    }
}
