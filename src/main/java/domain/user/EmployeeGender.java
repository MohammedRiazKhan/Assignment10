package domain.user;

public class EmployeeGender {

    private String genderID;
    private String empNumber;

    public EmployeeGender(){

    }

    public String getGenderID() {
        return genderID;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public EmployeeGender employeeGender(String empNumber, String genderId){


        this.empNumber = empNumber;
        this.genderID = genderId;
        return this;


    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "empNumber='" + empNumber + '\'' +
                ", genderID='" + genderID + '\'' +
                '}';
    }

}
