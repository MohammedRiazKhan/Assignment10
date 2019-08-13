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
import service.user.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl service = null;
    private EmployeeRepository repository;
    private GenderRepository genderRepository;
    private EmployeeGenderRepository employeeGenderRepository;
    private RaceRepository raceRepository;

    public EmployeeServiceImpl() {
        repository = EmployeeRepositoryImpl.getEmployeeRepository();
        genderRepository = GenderRepositoryImpl.getGenderRepository();
        employeeGenderRepository = EmployeeGenderRepositoryImpl.getEmployeeGenderRepository();
        raceRepository = RaceRepositoryImpl.getRaceRepository();
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

    @Override
    public void createEmp(int empId, String firstName, String lastName, int genderId, int raceId){

        Employee employee = EmployeeFactory.getEmployee(empId, firstName, lastName);
        repository.create(employee);

        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(empId, genderId);
        employeeGenderRepository.create(employeeGender);

        Race race = RaceFactory.buildRace(raceId, "Race");
        raceRepository.create(race);

        Gender gender = GenderFactory.buildGender(genderId, "None");
        genderRepository.create(gender);


    }

}
