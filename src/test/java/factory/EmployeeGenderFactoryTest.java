package factory;

import domain.demography.EmployeeGender;
import factory.demography.EmployeeGenderFactory;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeGenderFactoryTest {

    @Test
    public void buildEmployeeGender() {

        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(1, 1);
        Assert.assertNotNull(employeeGender);

    }

}