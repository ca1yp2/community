package net.ca1yps.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.ca1yps.community.dto.BoardAdminDTO;
import net.ca1yps.community.dto.Users;
import net.ca1yps.community.mapper.UsersMapper;
import net.ca1yps.community.service.BoardAdminService;

@Controller
public class HomeController {
	
	@Autowired
	private UsersMapper userMapper;
	
	@Autowired
	private BoardAdminService baService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("로그인 정보 : " + auth.getName());
		
		if(auth != null) {
			Users user = userMapper.getUserForUserid(auth.getName());
			model.addAttribute("user", user);
		}
		List<BoardAdminDTO> baList = baService.getAllList();
		model.addAttribute("balists", baList);
		
		return "main.home";
	}
	
	@GetMapping("/login")
	public String loginForm(@RequestParam(value="error", required=false) String error, Model model) {
		if(error != null) model.addAttribute("errorMessage", "아이디 또는 비밀번호가 틀렸습니다.");
		List<BoardAdminDTO> baList = baService.getAllList();
		model.addAttribute("balists", baList);
		return "main.login";
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		List<BoardAdminDTO> baList = baService.getAllList();
		model.addAttribute("balists", baList);
		return "main.register";
	}
	
	@PostMapping("/register")
	public String register() {
		return "redirect: /";
	}
	
}
