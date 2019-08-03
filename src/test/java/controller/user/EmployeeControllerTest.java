package controller.user;

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


    private EmployeeService employeeService = EmployeeServiceImpl.getService();
    private EmployeeGenderService employeeGenderService = EmployeeGenderServiceImpl.getService();
    private RaceService raceService = RaceServiceImpl.getService();
    private GenderService genderService = GenderServiceImpl.getService();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
    }
}