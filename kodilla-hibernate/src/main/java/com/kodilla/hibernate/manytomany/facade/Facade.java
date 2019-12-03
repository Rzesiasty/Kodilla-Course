package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    private static final Logger LOGGER = LoggerFactory.getLogger(Facade.class);

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> searchCompanyByName(final String searchKey) throws SearchProcessingException{
        List<Company> companiesSearchResults = companyDao.searchCompanyByName(searchKey);
        if(companiesSearchResults.size() == 0){
            LOGGER.info(SearchProcessingException.ERR_COMPANY_NOT_FOUND);
            throw new SearchProcessingException(SearchProcessingException.ERR_COMPANY_NOT_FOUND);
        }
        return companiesSearchResults;
    }

    public List<Employee> searchEmployByName(final String searchKey) throws SearchProcessingException{
        List<Employee> employeesSearchResults = employeeDao.searchEmployeeByName(searchKey);
        if(employeesSearchResults.size() == 0){
            LOGGER.info(SearchProcessingException.ERR_EMPLOYEE_NOT_FOUND);
            throw new SearchProcessingException(SearchProcessingException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return employeesSearchResults;
    }

}
