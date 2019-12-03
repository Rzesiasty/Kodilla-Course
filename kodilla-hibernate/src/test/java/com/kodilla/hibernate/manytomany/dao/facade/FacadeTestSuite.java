package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.Facade;
import com.kodilla.hibernate.manytomany.facade.SearchProcessingException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuite {

    @Autowired
    private Facade facade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testCompanySearchNameFacade() throws SearchProcessingException {
        //Given
        Company company = new Company("Company test");

        //When
        companyDao.save(company);
        List<Company> companies = facade.searchCompanyByName("%comp%");

        //Then
        Assert.assertEquals(1, companies.size());

        //CleanUp
        companyDao.deleteById(company.getId());
    }

    @Test
    public void testEmployeeSearchNameFacade() throws SearchProcessingException {
        //Given
        Employee employee = new Employee("name", "lastname");

        //When
        employeeDao.save(employee);
        List<Employee> employees = facade.searchEmployByName("%last%");

        //Then
        Assert.assertEquals(1, employees.size());

        //CleanUp
        employeeDao.deleteById(employee.getId());

    }

}
