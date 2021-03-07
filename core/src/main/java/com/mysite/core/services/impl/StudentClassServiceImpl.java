package com.mysite.core.services.impl;

import com.mysite.core.services.Configuration;
import com.mysite.core.services.ConfigurationService;
import com.mysite.core.services.StudentClassService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import java.util.List;

@Component(service= ConfigurationService.class)
@Designate(ocd=Configuration.class)
public class StudentClassServiceImpl implements StudentClassService {

    private int id;
    private int marks;
    private String name;

    StudentClassServiceImpl(int id, String name, int marks)
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }


    @Activate
    @Modified
    protected void activate(Configuration config)
    {


    }


    @Override
    public void addStudent() {

    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public boolean isStudentPassed() {
        return false;
    }

    @Override
    public int getStudent() {
        return 0;
    }

    @Override
    public int getAllStudent() {
        return 0;
    }
}
