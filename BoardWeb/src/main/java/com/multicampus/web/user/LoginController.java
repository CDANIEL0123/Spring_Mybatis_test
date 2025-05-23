package com.multicampus.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	// 로그인 화면으로 이동
	//@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	@GetMapping("/login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) throws Exception {
		// Command 객체에 값을 설정하면 JSP에서 그 값을 이용할 수 있다. 
		vo.setId("admin");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	// 로그인 인증 처리
	//@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@PostMapping("/login.do")
	public String login(UserVO vo, HttpSession session) throws Exception {
		UserVO user = userService.getUser(vo);
		if(user != null) {
			// 로그인 성공 시, 사용자 정보를 세션에 등록한다.
			session.setAttribute("user", user);
			
			return "forward:getBoardList.do";
		}
		else return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

}
