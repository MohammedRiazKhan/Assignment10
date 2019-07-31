package domain;

public class Employee {

    private int empNumber;
    private String empFirstName, empLastName;
    // private Gender gender;

    private Employee (){}

    public Employee(Builder builder)
    {
        this.empNumber = builder.empNumber;
        this.empFirstName = builder.empFirstName;
        this.empLastName = builder.empLastName;
        // this.gender = builder.gender;

    }

    public int getEmpNumber() {
        return empNumber;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

//    public Gender getGender() {
//        return gender;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNumber='" + empNumber + '\'' +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                '}';
    }

    public static class Builder
    {
        private int empNumber;
        private String empFirstName, empLastName;
        //   private Gender gender;

        public Builder empNumber(int empNumber)
        {
            this.empNumber = empNumber;
            return this;
        }

        public Builder empFirstName(String empFName)
        {
            this.empFirstName = empFName;
            return this;

        }

        public Builder empLastName(String empLName)
        {
            this.empLastName = empLName;
            return this;

        }

//        public Builder gender(Gender g)
//        {
//           this.gender = g;
//           return this;
//        }


//        public Builder gene()
//        {
//            return new Gender(this);
//        }



        public Employee build()
        {
            return new Employee(this);
        }

        public Employee copy(Employee employee)
        {
            this.empNumber = employee.empNumber;
            this.empFirstName = employee.empFirstName;
            this.empLastName = employee.empLastName;

            return employee;
        }
    }

}
