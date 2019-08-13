package service.user.impl;

import domain.demography.Gender;
import domain.demography.Race;
import domain.user.Employee;
import domain.user.EmployeeGender;
import factory.demography.GenderFactory;
import factory.demography.RaceFactory;
import factory.user.EmployeeFactory;
import factory.user.EmployeeGenderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.user.EmployeeService;

import java.util.Set;

public class EmployeeServiceImplTest {

    private EmployeeService service;

    @Before
    public void setUp() throws Exception {
        this.service = EmployeeServiceImpl.getService();
    }

    @Test
    public void getAll() {

        Set<Employee> employeeSet = service.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        Employee employee = EmployeeFactory.getEmployee(1, "Riaz", "Khan");

        service.create(employee);

        Employee inRepo = service.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Employee employee = EmployeeFactory.getEmployee(1, "Riaz", "Khan");

        service.create(employee);

        Employee inRepo = service.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Employee employee = EmployeeFactory.getEmployee(1, "Riaz", "Khan");

        service.create(employee);
        Employee inRepo = service.read(employee.getEmpNumber());

        employee.setEmpFirstName("Not Riaz");

        service.update(employee);

        Assert.assertEquals(employee.getEmpNumber(), inRepo.getEmpNumber());

    }

    @Test
    public void delete() {

        Employee employee = EmployeeFactory.getEmployee(1, "Riaz", "Khan");

        service.create(employee);

        Employee inRepo = service.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);

        service.delete(employee.getEmpNumber());

        Employee deleted = service.read(employee.getEmpNumber());

        Assert.assertNull(deleted);

    }

    @Test
    public void createEmp() {

        Gender gender = GenderFactory.buildGender(1, "M");
        Race race = RaceFactory.buildRace(1,"fa");
        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(1, 1);
        Employee employee = EmployeeFactory.getEmployee(1, "Riaz", "Khan");

        service.createEmp(employee.getEmpNumber(), employee.getEmpLastName(),employee.getEmpLastName(), gender.getId(),race.getRaceID());

        Assert.assertNotNull(service);

    }

}