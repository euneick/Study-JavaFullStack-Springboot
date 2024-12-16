package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.Student;
import net.skhu.mapper.StudentMapper;


@Controller
@RequestMapping("student")
@Slf4j
public class StudentController {

	@Autowired
	private StudentMapper studentMapper;

	@GetMapping("list")
	public String list(Model model, @RequestParam(value="name", defaultValue = "") String name) {

		List<Student> students = studentMapper.selectSearchedStudent(name + "%");

		model.addAttribute("students", students);
		model.addAttribute("name", name);

		return "student/list";
	}
}
