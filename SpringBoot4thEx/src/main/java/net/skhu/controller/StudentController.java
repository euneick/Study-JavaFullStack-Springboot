package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.Student;

@Controller
@RequestMapping("student")
@Slf4j
public class StudentController {

	@GetMapping("edit")
	public String edit(Model model) {

		Student student = new Student();
		student.setName("이순신");

		log.debug(student.toString());
		model.addAttribute("student", student);

		return "student/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, Student student) {

		try {
			log.debug(student.toString());

			if (StringUtils.hasText(student.getStudentNo()) == false) {
				throw new Exception("학번을 입력하세요");
			}

			if (StringUtils.hasText(student.getName()) == false) {
				throw new Exception("이름을 입력하세요");
			}

			return "redirect:list";
		}
		catch (Exception e) {
			model.addAttribute("errorMsg",e.getMessage());

			return "student/edit";
		}
	}

	@GetMapping("list")
	public String list() {
		return "student/list";
	}


}