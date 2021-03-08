package com.mysite.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="ConfigurationService Service Configuration")
public @interface Configuration {


    @AttributeDefinition(name = "Students Allowed ", type = AttributeType.INTEGER)
    int StuAll() default 10;

    @AttributeDefinition(name = "Marks ", type = AttributeType.INTEGER)
    int PassMarks() default 40;


}
