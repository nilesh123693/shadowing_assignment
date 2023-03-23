package com.contact_manager.controller;

import com.contact_manager.entity.Employee;
import com.contact_manager.services.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class HomeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/home")
    public String home(Model model,HttpSession session) {
        List<Employee> list = employeeService.getAllemployee();
        model.addAttribute("list",list);
        return "index";
    }
    @GetMapping("/addemp")
    public String addEmp() {
        return "add";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute Employee employee , HttpSession session) {

        System.out.println(employee);
        session.setAttribute("msg",null);
        employeeService.addEmployee(employee);
        session.setAttribute("msg","employee data added successfully");
        return "redirect:/emp/home";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Employee employee = employeeService.getEmpById(id);
        model.addAttribute("emp", employee);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee employee,HttpSession session) {

        employeeService.addEmployee(employee);
        session.setAttribute("msg","employee data updated successfully");
        return "redirect:/emp/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session) {
        employeeService.deleteById(id);
        session.setAttribute("msg","employee deleted successfully");
        return  "redirect:/emp/home";
    }

}
