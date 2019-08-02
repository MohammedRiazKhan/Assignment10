package factory;

import domain.demography.Gender;
import factory.demography.GenderFactory;
import org.junit.Assert;
import org.junit.Test;

public class GenderFactoryTest {

    @Test
    public void getGender() {

        Gender gender = GenderFactory.getGender(1, "M");
        Assert.assertNotNull(gender);

    }
}