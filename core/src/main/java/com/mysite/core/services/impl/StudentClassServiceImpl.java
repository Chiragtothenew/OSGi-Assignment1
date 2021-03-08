package com.mysite.core.services.impl;

import com.mysite.core.services.*;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

import java.util.ArrayList;
import java.util.List;

@Component(service= StudentClassService.class)
@Designate(ocd= Configuration2.class)
public class StudentClassServiceImpl implements StudentClassService {

    @Reference
    private ConfigurationService config;



public List<Student> studentlist = new ArrayList<Student>();


    @Override
    public void addStudent(Student s) {

        if(config.isClassLimitReached(studentlist))
        {
            System.out.println("Class Limit Reached");
        }

        else
        {
            studentlist.add(s);
        }

    }

    @Override
    public void deleteStudent(int id) {
        int i=0;
        for(Student s : studentlist)
        {
            i++;
            if(s.getId()==id)
            {
                studentlist.remove(i);
            }
        }

    }

    @Override
    public boolean isStudentPassed(int id) {

        for( Student s : studentlist)
        {
            if(s.getId()==id)
            {
                if(s.getMarks()>=config.getPassMarks(3))
                {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Student getStudent(int id) {
        for(Student s : studentlist)
        {
            if(s.getId()==id)
            {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentlist;
    }
}