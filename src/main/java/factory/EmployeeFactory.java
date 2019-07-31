package factory;

import domain.Employee;

public class EmployeeFactory {

    public static Employee getEmployee(int empNumber, String fname, String lname )
    {
        //String gender
        //  Gender g = GenderFactory.buildGender(gender);

        //take out all the gender kak
        return new Employee.Builder()
                .empNumber(empNumber)
                .empFirstName(fname)
                .empLastName(lname)
                //.gender(g)
                .build();
    }



}
