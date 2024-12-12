package net.skhu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.Product;




@RestController
@RequestMapping("first")
public class FirstController {

	@GetMapping("test1")
	public String test1() {

		return "Hello!";
	}

	@GetMapping("test2")
	public String[] test2() {

		return new String[] { "월", "화", "수", "목", "금", "토", "일" };
	}

	@GetMapping("test3")
	public Product test3() {

		return new Product("맥주", 23400);
	}

	@GetMapping("test4")
	public Product[] test4() {

		return new Product[] {
				new Product("소주", 10000	),
				new Product("맥주", 20000	),
				new Product("양주", 30000)
		};
	}

}
