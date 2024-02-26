package org.example;

public class someClass implements Comparable<someClass> {
    private String s;
    private String s1;
    private double num;
    public someClass(String s, String s1, double num){
        this.s = s;
        this.s1 = s1;
        this.num = num;
    }
    @Override
    public int compareTo(someClass temp){
        return (int)(this.num - temp.num);
    }
    @Override
    public String toString(){
        return s + "\t" + s1 + "\t" + num;
    }
}
