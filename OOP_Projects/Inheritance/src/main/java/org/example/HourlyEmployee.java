package org.example;

public class HourlyEmployee extends Employee{
    private float workHourPrice ;
    private int hourlyRate ;

    public HourlyEmployee(String name, String address, String department, String email, float salary, float workHourPrice, int hourlyRate) {
        super(name, address, department, email, salary);
        this.workHourPrice = workHourPrice;
        this.hourlyRate = hourlyRate;
    }

    public float getWorkHourPrice() {
        return workHourPrice;
    }

    public void setWorkHourPrice(float workHourPrice) {
        this.workHourPrice = workHourPrice;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public float getSalary(){
        return workHourPrice * (float)hourlyRate ;
    }
}
