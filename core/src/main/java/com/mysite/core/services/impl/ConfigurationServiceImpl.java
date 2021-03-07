package com.mysite.core.services.impl;

import com.mysite.core.services.Configuration;
import com.mysite.core.services.ConfigurationService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import java.util.List;

@Component(service=ConfigurationService.class)
@Designate(ocd=Configuration.class)
public class ConfigurationServiceImpl implements ConfigurationService {

    private int marks;
    private int status;

    @Activate
    @Modified
    protected void activate(Configuration config)
    {
        marks = config.PassMarks();
        status = config.StuAll();
    }


    @Override
    public int getPassMarks(int a)
    {
        return marks;

    }

    @Override
    public boolean isClassLimitReached(List List1) {
        if(List1.size()>=status)
        {
            return true;
        }

        return false;
    }



}
