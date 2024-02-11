package org.example;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Khaled" , "Mansoura" , "AI" , "khaled@gmail.com" , 1000) ;
        System.out.println("Empoloyee Salary = " + employee.getSalary());
        SalariedEmployee salariedEmployee = new SalariedEmployee("Hassan" , "Aga" , "Civil Engineering" , "Hassan@gmail.com" , 500 , 50) ;
        System.out.println("SalariedEmployee salary = " + salariedEmployee.getSalary()); // Here we should make Override to produce features related to SalariedEmployee not regular Employee.
        DailyEmployee dailyEmployee = new DailyEmployee("Mohamed" , "Kafrawy" , "Undergraduated" , "mohamed@gmail.com" , 500 , 100 , 25) ;
        System.out.println("DailyEmployee salary = " + dailyEmployee.getSalary());
        HourlyEmployee houlrlyEmployee = new HourlyEmployee("Ahmed" , "Also Kafrawy" , "Undergraduated" , "Ahmed@gmail.com" , 499 , 99.9f , 25) ;
        System.out.println("HourlyEmployee salary = " + houlrlyEmployee.getSalary());
        
    }
}