package com.aiden.sringbootrestful.controller;

import com.aiden.sringbootrestful.dao.EmployeeDao;
import com.aiden.sringbootrestful.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/empList")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("empList", all);
        return "emp/list";
    }
}
