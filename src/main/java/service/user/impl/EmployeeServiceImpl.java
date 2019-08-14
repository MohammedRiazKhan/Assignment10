package service.user.impl;

import domain.demography.Gender;
import domain.demography.Race;
import domain.user.Employee;
import domain.user.EmployeeGender;
import factory.demography.GenderFactory;
import factory.demography.RaceFactory;
import factory.user.EmployeeFactory;
import factory.user.EmployeeGenderFactory;
import repository.demography.GenderRepository;
import repository.demography.RaceRepository;
import repository.demography.impl.GenderRepositoryImpl;
import repository.demography.impl.RaceRepositoryImpl;
import repository.user.EmployeeGenderRepository;
import repository.user.EmployeeRepository;
import repository.user.impl.EmployeeGenderRepositoryImpl;
import repository.user.impl.EmployeeRepositoryImpl;
import service.demography.GenderService;
import service.demography.RaceService;
import service.demography.impl.GenderServiceImpl;
import service.demography.impl.RaceServiceImpl;
import service.user.EmployeeGenderService;
import service.user.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {


    private static EmployeeServiceImpl service = null;
    private EmployeeRepository repository;
    private EmployeeGenderRepository employeeGenderRepository;
    private RaceRepository raceRepository;
    private GenderRepository genderRepository;


    public EmployeeServiceImpl() {
        repository = EmployeeRepositoryImpl.getEmployeeRepository();
        employeeGenderRepository = EmployeeGenderRepositoryImpl.getEmployeeGenderRepository();
        raceRepository = RaceRepositoryImpl.getRaceRepository();
        genderRepository = GenderRepositoryImpl.getGenderRepository();

    }

    public static EmployeeServiceImpl getService(){

        if(service == null){
            return new EmployeeServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Employee> getAll() {
        return repository.getAll();
    }

    @Override
    public Employee createEmployee(int empId, String firstName, String lastName, int genderId, int raceId) {

        Employee employee = EmployeeFactory.getEmployee(empId, firstName, lastName);
        service.create(employee);

        Race race = RaceFactory.buildRace(raceId, "Yellow");
        raceRepository.create(race);

        Gender gender = GenderFactory.buildGender(genderId, "Male");
        genderRepository.create(gender);

        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(empId, genderId);
        employeeGenderRepository.create(employeeGender);

        return employee;
    }

    @Override
    public Employee create(Employee employee) {
        return repository.create(employee);
    }

    @Override
    public Employee read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.update(employee);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);

    }
}
