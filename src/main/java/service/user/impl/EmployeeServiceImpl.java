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
import service.demography.impl.GenderServiceImpl;
import service.demography.impl.RaceServiceImpl;
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
    public Employee read(String id) {
        return repository.read(id);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.update(employee);
    }

    @Override
    public void delete(String id) {

        repository.delete(id);

    }

    @Override
    public Employee createEmployee(String firstName, String lastName, String race, String gender){

        Gender aGender = GenderServiceImpl.getService().readByName(gender);
        if(aGender == null){
            return null;
        }

        Race aRace = RaceServiceImpl.getService().readByName(race);
        if(aRace == null){
            return null;
        }

        Employee employee = EmployeeFactory.getEmployee(firstName, lastName);
        if(employee == null){
            return null;
        }

        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(employee.getEmpNumber(), aGender.getId());
        employeeGenderRepository.create(employeeGender);

        return create(employee);

    }

}
