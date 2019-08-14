package controller.user;

import domain.demography.Gender;
import domain.demography.Race;
import domain.user.Employee;
import domain.user.EmployeeGender;
import factory.demography.GenderFactory;
import factory.demography.RaceFactory;
import factory.user.EmployeeFactory;
import factory.user.EmployeeGenderFactory;
import service.demography.GenderService;
import service.demography.RaceService;
import service.demography.impl.GenderServiceImpl;
import service.demography.impl.RaceServiceImpl;
import service.user.EmployeeGenderService;
import service.user.EmployeeService;
import service.user.impl.EmployeeGenderServiceImpl;
import service.user.impl.EmployeeServiceImpl;

public class EmployeeController {

    private EmployeeService employeeService = EmployeeServiceImpl.getService();

    public Employee create(int empId, String firstName, String lastName, int genderId, int raceId){

        return employeeService.createEmployee(empId, firstName, lastName, genderId, raceId);

    }


}
