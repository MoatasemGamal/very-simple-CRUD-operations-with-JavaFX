package com.example.jfx_employee;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileController {
    protected static void write(File file, Employee[] emp) throws IOException {
        FileWriter fileWriter=new FileWriter(file);
        for(int i=1; i<EmployeeArray.getEmployeeNumbers()&&emp[i]!=null; i++){
            fileWriter.write(Integer.toString(emp[i].getEmp_num()));
            fileWriter.write(" "+emp[i].getName()+" ");
            fileWriter.write(Double.toString(emp[i].getSalary()));
            fileWriter.write(" "+emp[i].getDepartment());
            fileWriter.write(" "+emp[i].getDOB()+" |"); // | symbol for ending line
        }
        fileWriter.write('*'); //* symbol for ending file
        fileWriter.flush();
        fileWriter.close();
    }

    protected static String  read(File file) throws Exception{
        FileReader fileReader = new FileReader(file);
        int i=0;
        String s="";
        while((i=fileReader.read())!=-1){
            //System.out.print((char) i);
            s+=(char) i;
        }
        return s;
    }
}
