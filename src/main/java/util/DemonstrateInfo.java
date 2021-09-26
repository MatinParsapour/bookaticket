package util;

import domain.Company;

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
}
