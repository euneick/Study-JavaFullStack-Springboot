package net.skhu.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("message", "Hello world!");
		model.addAttribute("current", new Date());

		return "index";		// src/main/resources/templates 경로 내 index.html을 실행
	}
}
