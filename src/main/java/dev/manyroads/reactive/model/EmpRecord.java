package dev.manyroads.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employees")
public class EmpRecord {

    @Id
    @Column("empID")
    private int empID;
    @Column("empFirstName")
    private String empFirstName;
    @Column("empLastName")
    private String empLastName;

    public EmpRecord(int empID, String empFirstName, String empLastName) {
        this.empID = empID;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
    }

    public EmpRecord() {
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    @Override
    public String toString() {
        return "EmpRecord{" +
                "empID=" + empID +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                '}';
    }
}
