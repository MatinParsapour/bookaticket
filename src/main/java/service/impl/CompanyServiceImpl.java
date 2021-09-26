package service.impl;

import base.service.BaseServiceImpl;
import domain.Company;
import repository.CompanyRepository;
import service.CompanyService;
import util.ApplicationContext;

import java.util.Scanner;

public class CompanyServiceImpl extends BaseServiceImpl<Company, Long, CompanyRepository> implements CompanyService {
    public CompanyServiceImpl(CompanyRepository repository) {
        super(repository);
    }

    @Override
    public Company selectCompany() {
        ApplicationContext.getDemonstrateInfo().demonstrateCompanyInfo(findAll());
        System.out.println("Company name : ");
        String companyName = new Scanner(System.in).nextLine();
        Company company = repository.findCompanyByName(companyName);
        return company;
    }
}
