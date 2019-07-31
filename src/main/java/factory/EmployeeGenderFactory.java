package factory;

import domain.EmployeeGender;

public class EmployeeGenderFactory {


    public static EmployeeGender buildEmployeeGender(String empID, String genderID)
    {
        return new EmployeeGender.Builder().empNumber(empID).genderID(genderID).build();

    }


}
