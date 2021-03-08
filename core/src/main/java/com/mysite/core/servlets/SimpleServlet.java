/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mysite.core.servlets;

import com.mysite.core.services.ConfigurationService;


import java.util.Arrays;
import java.util.List;

import com.mysite.core.services.Student;
import com.mysite.core.services.StudentClassService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */

@Component(service = { Servlet.class },immediate = true)
@SlingServletPaths(value = "/bin/myservlet")
public class SimpleServlet extends SlingSafeMethodsServlet {

//private static final long serialVersionUID = 1L;
//private static List l;

    @Reference
    private ConfigurationService configurationService;

    @Reference
    private StudentClassService studentClassService;

    @Override
    public void init() throws ServletException{

        studentClassService.addStudent(new Student(1,100,"Chirag"));
        studentClassService.addStudent(new Student(2,90,"Swastik"));
        studentClassService.addStudent(new Student(3,80,"Manya"));

    }


    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("action"));
        List l = Arrays.asList(req.getParameterValues("list"));
        int id = Integer.parseInt(req.getParameter("id"));
        resp.getWriter().write("A = " + configurationService.isClassLimitReached(l) + " marks = " + configurationService.getPassMarks(a));
        resp.getWriter().println("Is Student Passed : "+studentClassService.isStudentPassed(id));

    }
}