package com.example.jfx_employee;

import java.util.Date;

public class Employee {
    static int employeeNumbers=0;
    int emp_num=0;
    String name;
    double salary;
    String department;
    String DOB;

    public Employee(int emp_num, String name, double salary, String department, String  DOB) {
        this.emp_num = emp_num;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.DOB = DOB;
        employeeNumbers++;
    }

    public Employee() {

    }

    public static int getEmployeeNumbers() {
        return employeeNumbers;
    }

    public static void setEmployeeNumbers(int employeeNumbers) {
        Employee.employeeNumbers = employeeNumbers;
    }

    public int getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(Integer emp_num) {
        this.emp_num = emp_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String  getDOB() {
        return DOB;
    }

    public void setDOB(String  DOB) {
        this.DOB = DOB;
    }
}
