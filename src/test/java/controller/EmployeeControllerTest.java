package controller;

import domain.user.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeControllerTest {

    EmployeeController controller = new EmployeeController();
    @Test
    public void createEmployee() {

        Employee employee = controller.createEmployee("Riaz", "Khan", "M", "Indian");
        Assert.assertNull(employee);
    }
}