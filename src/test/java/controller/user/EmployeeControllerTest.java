package controller.user;

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
import service.demography.GenderService;
import service.demography.RaceService;
import service.demography.impl.GenderServiceImpl;
import service.demography.impl.RaceServiceImpl;
import service.user.EmployeeGenderService;
import service.user.EmployeeService;
import service.user.impl.EmployeeGenderServiceImpl;
import service.user.impl.EmployeeServiceImpl;

import static org.junit.Assert.*;

public class EmployeeControllerTest {

    private EmployeeController employeeController;

    @Before
    public void setUp() throws Exception {
        employeeController = new EmployeeController();
    }

    @Test
    public void create() {

        Gender gender = GenderFactory.buildGender(1, "M");
        Race race = RaceFactory.buildRace(1,"Real");
        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(1, 1);
        System.out.println(employeeGender);
        Employee employee = EmployeeFactory.getEmployee(1, "Riaz", "Khan");

        Employee employee1 = employeeController.create(employee.getEmpNumber(), employee.getEmpLastName(),employee.getEmpLastName(), gender.getId(),race.getRaceID());

        Assert.assertNotNull(employee1);

    }
}