package com.example.jfx_employee;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TransferQueue;

import static java.lang.Integer.parseInt;

public class HelloController {
    //Elements
    @FXML
    private Label welcomeText;
    @FXML
    private Label statusBar;
    @FXML
    private ListView employeesListViewData;
    @FXML
    private TextField empNumTxt;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField salaryTxt;
    @FXML
    private TextField departmentTxt;
    @FXML
    private TextField dateOfBirthTxt;
    @FXML
    private TextField searchTxt;
    @FXML private Label searchedItemData;

    //Local variables and objects
    EmployeeArray employeeArray=new EmployeeArray();
    String dataFile=new String("");
    int updateTimes=0;

    //Actions
    @FXML
    protected void onLoadButtonClick() throws Exception {
        FileChooser f1=new FileChooser();
        f1.setInitialDirectory(new File("Files"));
        File f2= f1.showOpenDialog(null);
        loadDataFromFile(f2);
        showData();
        statusBar.setText(getFileNameFromPath(f2.getAbsolutePath())+" has been loaded successfully");
    }
    @FXML
    protected void onInsertButtonClick(){
        employeeArray.insert(parseInt(empNumTxt.getText()),nameTxt.getText(),Double.parseDouble(salaryTxt.getText()),departmentTxt.getText(),dateOfBirthTxt.getText());
        showData();
        statusBar.setText("Item has been inserted successfully");
    }
    @FXML
    protected void onSortButtonClick(){
        statusBar.setText("Items already sorted !");
    }
    @FXML
    protected void onDeleteButtonClick(){
        String s=employeesListViewData.getSelectionModel().getSelectedItem().toString();
        String empNum="";
        //emp number
        for (int i=0 ;(s.charAt(i) != '\t') && (i < s.length()-1) ; i++) {
             empNum+=s.charAt(i);
        }
        employeeArray.delete(Integer.parseInt(empNum));
        showData();
        statusBar.setText("Item with number "+empNum+" has deleted successfully");
    }
    @FXML
    protected void onLinearSearchButtonClick(){
            int empNumber = Integer.parseInt(searchTxt.getText());
            int inx=employeeArray.linearSearch(empNumber);
            if ( inx != -1)
                searchedItemData.setText(employeeArray.toString(inx));
            else
                searchedItemData.setText("Employee with number: " + empNumber + " not found");
    }
    @FXML
    protected void onBinarySearchButtonClick(){
        int empNumber = Integer.parseInt(searchTxt.getText());
        int inx=employeeArray.binarySearch(empNumber);
        System.out.println(inx+" ------------------");
        if ( inx != -1)
            searchedItemData.setText(employeeArray.toString(inx));
        else
            searchedItemData.setText("Employee with number: " + empNumber + " not found");
    }

    @FXML
    protected void onSaveButtonClick() throws IOException {
        FileChooser f1=new FileChooser();
        f1.setInitialDirectory(new File("Files"));
        File f2= f1.showOpenDialog(null);
        FileController.write(f2,employeeArray.getEmployees());
        statusBar.setText("Data has been saved into "+getFileNameFromPath(f2.getAbsolutePath())+" successfully");
    }

    //Functions
    protected void loadDataFromFile(File file) throws Exception {
        String dataFile=FileController.read(file);
        String[] dataFiled=new String[5];


        //int i=0,j=0,k=0;
        int j=0;
        while(dataFile.charAt(j)!='*'){
            dataFiled[0]="";
            dataFiled[1]="";
            dataFiled[2]="";
            dataFiled[3]="";
            dataFiled[4]="";

            //emp number
            for ( ;(dataFile.charAt(j) != ' ') && (j < dataFile.length()-1) ; j++) {
                dataFiled[0] += dataFile.charAt(j);
            }
            //name
            j++;
            for ( ;(dataFile.charAt(j) != ' ') && (j < dataFile.length()-1); j++) {
                dataFiled[1] += dataFile.charAt(j);
            }
            //salary
            j++;
            for ( ;(dataFile.charAt(j) != ' ') && (j < dataFile.length()-1); j++) {
                dataFiled[2] += dataFile.charAt(j);
            }
            //department
            j++;
            for ( ;(dataFile.charAt(j) != ' ') && (j < dataFile.length()-1); j++) {
                dataFiled[3] += dataFile.charAt(j);
            }
            //date of birth
            j++;
            for ( ;(dataFile.charAt(j) != ' ') && (j < dataFile.length()-1); j++) {
                dataFiled[4] += dataFile.charAt(j);
            }
            j+=2;
            employeeArray.insert(parseInt(dataFiled[0]),dataFiled[1],Double.parseDouble(dataFiled[2]),dataFiled[3],dataFiled[4]);
        }
    }

    protected void showData(){
        updateTimes++;
        employeesListViewData.getItems().add("↓↓↓ "+updateTimes+" Time update ↓↓↓");
        for(int i=0; i<employeeArray.getEmployeesLength()-1;i++) {
            if(employeeArray.at(i)!=null) {
                String s = "";
                System.out.println(employeeArray.at(i).getEmp_num());
                s += Integer.toString(employeeArray.at(i).getEmp_num()) + "\t";
                s += employeeArray.at(i).getName() + "\t";
                s += Double.toString(employeeArray.at(i).getSalary()) + "\t";
                s += employeeArray.at(i).getDepartment() + "\t";
                s += "\t"+employeeArray.at(i).getDOB();
                employeesListViewData.getItems().add(s);
            }
        }
    }

    protected String getFileNameFromPath(String s){
        String fileName="";
        for(int i=0; i<s.length(); i++){
            fileName+=s.charAt(i);
            if(s.charAt(i)=='\\')
                fileName="";
        }
        return fileName;
    }
}