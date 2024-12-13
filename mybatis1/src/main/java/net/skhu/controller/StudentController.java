package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.Student;
import net.skhu.mapper.StudentMapper;
import net.skhu.model.StudentEdit;

@Controller
@RequestMapping("student")
@Slf4j
public class StudentController {

	@Autowired
	private StudentMapper studentMapper;

	@GetMapping("list")
	public String list(Model model) {

		List<Student> students = studentMapper.selectStudents();

		model.addAttribute("students", students);

		return "student/list";
	}

	@GetMapping("edit")
	public String edit(Model model) {

		StudentEdit studentEdit = new StudentEdit();
		studentEdit.setName("이순신");

		log.debug(studentEdit.toString());
		model.addAttribute("studentEdit", studentEdit);

		return "student/edit";
	}

	/*
	 * 	BindingResult
	 * 		@Valid 규칙을 검사하고 오류가 있으면, 그 정보를 얻는 인터페이스
	 */
	@PostMapping("edit")
	public String edit(Model model, @Valid StudentEdit studentEdit, BindingResult bindingResult) {

		try {
			log.debug(studentEdit.toString());

			if (bindingResult.hasErrors()) {
				throw new Exception("입력한 형식이 올바르지 않습니다.");
			}

			return "redirect:list";
		}
		catch (Exception e) {
			bindingResult.reject("", null, e.getMessage());
			// 첫 번째 파라미터가 "" 이면 에러메시를 속성이 아닌 StudentEdit 객체 자체에 등록

			return "student/edit";
		}
	}
}
