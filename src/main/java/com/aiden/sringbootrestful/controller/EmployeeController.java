package com.aiden.sringbootrestful.controller;

import com.aiden.sringbootrestful.dao.DepartmentDao;
import com.aiden.sringbootrestful.dao.EmployeeDao;
import com.aiden.sringbootrestful.entities.Department;
import com.aiden.sringbootrestful.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/empList")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("empList", all);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        System.out.println("进入添加界面");
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departmentList", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String emp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:empList";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        System.out.println(employee);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departmentList", departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("update " + employee);
        employeeDao.save(employee);
        return "redirect:empList";
    }

    @DeleteMapping("/emp/{id}")
    public String delEmp(@PathVariable("id") Integer id, Model model) {
        employeeDao.delete(id);
        System.out.println("删除: " + id);
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("empList", all);
        return "emp/list";
    }
}
