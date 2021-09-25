package service.impl;

import base.service.BaseServiceImpl;
import domain.Company;
import repository.CompanyRepository;
import service.CompanyService;

public class CompanyServiceImpl extends BaseServiceImpl<Company, Long, CompanyRepository> implements CompanyService {
    public CompanyServiceImpl(CompanyRepository repository) {
        super(repository);
    }
}
