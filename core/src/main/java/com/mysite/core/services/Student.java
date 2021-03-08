package com.mysite.core.services;

public class Student {

    public int id;
    public int marks1;
    public String name;

    public Student(int id, int marks1, String name)
    {
        this.id=id;
        this.name=name;
        this.marks1=marks1;
    }

    public String toString()
    {
        return this.id+" "+this.name+" "+this.marks1;
    }

    public int getId()
    {
        return id;
    }

    public int getMarks()
    {
        return marks1;
    }
}
