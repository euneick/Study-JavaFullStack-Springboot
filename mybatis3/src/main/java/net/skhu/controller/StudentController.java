package net.skhu.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.model.StudentEdit;




@Controller
@RequestMapping("student")
@Slf4j
public class StudentController {

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private DepartmentMapper departmentMapper;

	// 두 객체간의 데이터를 자동으로 복사해주는 도구
	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("list")
	public String list(Model model, @RequestParam(value="name", defaultValue = "") String name) {

		List<Student> students = studentMapper.selectSearchedStudent(name + "%");

		model.addAttribute("students", students);
		model.addAttribute("name", name);

		return "student/list";
	}

	@GetMapping("create")
	public String create(Model model) {

		StudentEdit studentEdit = new StudentEdit();

		model.addAttribute("studentEdit", studentEdit);
		model.addAttribute("departments", departmentMapper.selectDepartments());

		return "student/edit";
	}

	@PostMapping("create")
	public String create(Model model, @Valid StudentEdit studentEdit, BindingResult bindingResult) {

		try {
			if (bindingResult.hasErrors()) {
				throw new Exception("입력한 형식이 올바르지 않습니다.");
			}

			studentMapper.insertStudent(modelMapper.map(studentEdit, Student.class));

			return "redirect:list";
		}
		catch (Exception e) {
			bindingResult.reject("", null, e.getMessage());
			model.addAttribute("departments", departmentMapper.selectDepartments());
			return "student/edit";
		}
	}

	@GetMapping("edit")
	public String edit(Model model, @RequestParam int id) {

		Student student = studentMapper.selectStudentById(id);

		model.addAttribute("studentEdit", modelMapper.map(student, StudentEdit.class));
		model.addAttribute("departments", departmentMapper.selectDepartments());

		return "student/edit";
	}

	@PostMapping(value = "edit", params = "cmd=save")
	public String edit(Model model, @Valid StudentEdit studentEdit, BindingResult bindingResult) {

		try {
			if (bindingResult.hasErrors()) {
				throw new Exception("입력한 형식이 올바르지 않습니다.");
			}

			studentMapper.updateStudent(modelMapper.map(studentEdit, Student.class));

			return "redirect:list";
		}
		catch (Exception e) {
			bindingResult.reject("", null, e.getMessage());
			return "student/edit";
		}
	}

	@PostMapping(value = "edit", params = "cmd=delete")
	public String delete(Model model, @Valid StudentEdit studentEdit, BindingResult bindingResult) {

		try {
			studentMapper.deleteStudentById(studentEdit.getId());
			return "redirect:list";
		}
		catch (Exception e) {
			bindingResult.reject("", null, e.getMessage());
			return "student/edit";
		}
	}

}
