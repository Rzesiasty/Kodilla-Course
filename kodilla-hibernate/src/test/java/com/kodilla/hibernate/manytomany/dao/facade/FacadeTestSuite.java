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
        Company company1 = new Company("Company1 test");

        //When
        companyDao.save(company);
        companyDao.save(company1);
        List<Company> companies = facade.searchCompanyByName("%comp%");

        //Then
        Assert.assertEquals(2, companies.size());

        //CleanUp
        companyDao.deleteById(company.getId());
        companyDao.deleteById(company1.getId());
    }

    @Test
    public void testEmployeeSearchNameFacade() throws SearchProcessingException {
        //Given
        Employee employee = new Employee("name", "lastname");
        Employee employee1 = new Employee("name1", "lastname1");
        Employee employee2 = new Employee("name2", "Kowalski");

        //When
        employeeDao.save(employee);
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        List<Employee> employees = facade.searchEmployByName("%last%");

        //Then
        Assert.assertEquals(2, employees.size());

        //CleanUp
        employeeDao.deleteById(employee.getId());
        employeeDao.deleteById(employee1.getId());
        employeeDao.deleteById(employee2.getId());
    }
}
