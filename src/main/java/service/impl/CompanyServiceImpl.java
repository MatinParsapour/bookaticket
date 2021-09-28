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
        System.out.println("Company id : ");
        long id = new Scanner(System.in).nextLong();
        Company company = repository.findCompanyByName(id);
        return company;
    }
}
