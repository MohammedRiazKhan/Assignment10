package controller;

import domain.demography.Gender;
import domain.demography.Race;
import domain.user.Employee;
import domain.user.EmployeeGender;
import factory.demography.GenderFactory;
import factory.demography.RaceFactory;
import factory.user.EmployeeFactory;
import factory.user.EmployeeGenderFactory;
import service.demography.impl.GenderServiceImpl;
import service.demography.impl.RaceServiceImpl;
import service.user.EmployeeService;
import service.user.impl.EmployeeServiceImpl;

public class EmployeeController {

    private EmployeeService employeeService = EmployeeServiceImpl.getService();

    public Employee createEmployee(String fName, String lName, String gender, String race){

        return employeeService.createEmployee(fName, lName, gender, race);

    }
}
