package com.example.jfx_employee;

import java.util.Date;
import java.util.SplittableRandom;

public class EmployeeArray extends Employee{
    Employee[] employees=new Employee[1000];

    public EmployeeArray() {
        super();
    }

    public void insert(int emp_num, String name, double salary, String department, String DOB){
        employees[emp_num]=new Employee(emp_num, name, salary, department, DOB);
    }

    public void delete(int employeeNumber){
        employees[employeeNumber]=null;
        Employee.employeeNumbers--;
    }

    public Employee at(int index){
        return employees[index];
    }

    public int linearSearch(int empNumber){
        int index=0;

        while(index<this.getEmployeesLength()){
            if(this.at(index)!=null)
            if(this.at(index).getEmp_num()==empNumber)
                return index;
            index++;
        }
        return -1;
    }

    public int binarySearch(int empNumber){
        int first=0, last=employees.length, mid=(first+last)/2;
        while(check(empNumber,mid)){
            if(this.at(mid)!=null) {
                if (empNumber == this.at(mid).getEmp_num()) {
                    return mid;
                } else if (empNumber < this.at(mid).getEmp_num())
                    last = mid;
                else
                    first = mid;
                mid = (first + last) / 2;
            } else
                return linearSearch(empNumber);
        }
        return -1;
    }

    public String toString(int index){
        return employees[index].getEmp_num()+"\t"+employees[index].getName()+"\t"+employees[index].getSalary()+"\t"+employees[index].getDepartment()+"\t"+employees[index].getDOB();
    }

    public void print(){
        for(int i=0; i<employees.length;i++){
            if(employees[i]!=null) {
                System.out.print(employees[i].getEmp_num() + "\t");
                System.out.print(employees[i].getName() + "\t");
                System.out.print(employees[i].getSalary() + "\t");
                System.out.print(employees[i].getDepartment() + "\t");
                System.out.print(employees[i].getDOB() + "\t");
                System.out.println("");
            }
        }
    }
    public Employee[] getEmployees() {
        return employees;
    }

    public int getEmployeesLength(){
        return employees.length;
    }


    public boolean check(int empNumber, int mid){
        if (this.at(mid)!=null) {
            if (empNumber != this.at(mid).getEmp_num())
                return true;
        }
        else if(mid<1000)
            return true;
        return false;
    }
}
