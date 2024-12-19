package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.SugangMapper;

@Controller
@RequestMapping("sugang")
public class SugangController {

	@Autowired
	private SugangMapper sugangMapper;

	@GetMapping("list")
	public String list (Model model) {

		model.addAttribute("sugangs", sugangMapper.selectSugangs());

		return "sugang/list";
	}
}
