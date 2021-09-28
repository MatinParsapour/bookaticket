package repository;

import base.repository.BaseRepository;
import domain.Company;

public interface CompanyRepository extends BaseRepository<Company, Long> {
    Company findCompanyByName(long id);
}
