package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Product;


@Controller
@RequestMapping("second")
public class SecondController {

	@GetMapping("test1")
	public String test1(Model model) {

		model.addAttribute("message", "hello, second world!");

		return "second/test1";
	}

	@GetMapping("test2")
	public String test2(Model model) {

		Product product = new Product("소주", 4000);

		model.addAttribute("product", product);

		return "second/test2";
	}

}
