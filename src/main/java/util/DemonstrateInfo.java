package util;

import domain.Company;
import domain.Employee;

import java.util.List;

public class DemonstrateInfo {
    public void demonstrateCompanyInfo(List<Company> companies){
        int companyNameSize = 0;
        for(Company company : companies){
            if(company.getCompanyName().length() > companyNameSize){
                companyNameSize = company.getCompanyName().length();
            }
        }
        int idSize = 10;

        int cover = companyNameSize + idSize + 14;

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(companyNameSize + 5)) + "s","name");
        System.out.format("| %" + (-(idSize + 5)) + "s |\n","id");


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(Company company : companies){
            System.out.format("| %" + (-(companyNameSize + 5)) + "s",company.getCompanyName());
            System.out.format("| %" + (-(idSize + 5)) + "s |\n",company.getId());
        }


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    public void printRequestsForCEO(List<Employee> employeeList) {
        int idSize = 10;
        int firstNameSize = 0;
        int lastNameSize = 0;
        int emailSize = 0;
        int phoneNumberSize = 0;
        int nationalCodeSize = 10;
        int birthdaySize = 10;
        for(Employee employee : employeeList){
            if(employee.getFirstName().length() > firstNameSize){
                firstNameSize = employee.getFirstName().length();
            }
            if(employee.getLastName().length() > lastNameSize){
                lastNameSize = employee.getLastName().length();
            }
            if(employee.getEmail().length() > emailSize){
                emailSize = employee.getEmail().length();
            }
            if(String.valueOf(employee.getPhoneNumber()).length() > phoneNumberSize){
                phoneNumberSize = String.valueOf(employee.getPhoneNumber()).length();
            }
        }

        int cover = idSize + firstNameSize + lastNameSize + emailSize + phoneNumberSize + nationalCodeSize + birthdaySize + 44;

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        System.out.format("| %" + (-(idSize)) + "s" , "id");
        System.out.format("| %" + (-(firstNameSize + 5)) + "s" , "firstname");
        System.out.format("| %" + (-(lastNameSize + 5)) + "s" , "lastname");
        System.out.format("| %" + (-(emailSize + 5)) + "s" , "email");
        System.out.format("| %" + (-(phoneNumberSize + 5)) + "s" , "phoneNumber");
        System.out.format("| %" + (-(nationalCodeSize + 5)) + "s" , "nationalcode");
        System.out.format("| %" + (-(birthdaySize + 5)) + "s | \n" , "birthday");

        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");

        for(Employee employee : employeeList){
            System.out.format("| %" + (-(idSize)) + "s" , employee.getId());
            System.out.format("| %" + (-(firstNameSize + 5)) + "s" , employee.getFirstName());
            System.out.format("| %" + (-(lastNameSize + 5)) + "s" , employee.getLastName());
            System.out.format("| %" + (-(emailSize + 5)) + "s" , employee.getEmail());
            System.out.format("| %" + (-(phoneNumberSize + 5)) + "s" , employee.getPhoneNumber());
            System.out.format("| %" + (-(nationalCodeSize + 5)) + "s" , employee.getNationalCode());
            System.out.format("| %" + (-(birthdaySize + 5)) + "s | \n" , employee.getBirthDate());
        }


        System.out.print("+");
        for(int i = 0 ; i < cover ; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
