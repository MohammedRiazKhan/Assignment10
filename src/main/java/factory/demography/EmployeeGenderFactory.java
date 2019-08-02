package factory.demography;

import domain.demography.EmployeeGender;

public class EmployeeGenderFactory {


    public static EmployeeGender buildEmployeeGender(int empId, int genderId)
    {
        return new EmployeeGender().employeeGender(genderId, empId);
    }



}
