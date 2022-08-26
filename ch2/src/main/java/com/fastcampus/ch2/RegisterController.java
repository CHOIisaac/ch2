package com.fastcampus.ch2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o 자동 임포트
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
//		System.out.println("conversionService= "+conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator());// UserValidator를 WebDataBinder의 로컬validator로 등록 
//		binder.addValidators(new UserValidator());// UserValidator를 WebDataBinder의 로컬validator로 등록 
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList= "+validatorList);
		
	}
	
	
	@RequestMapping(value="/add", method= RequestMethod.GET) // 신규회원 가입
//	@GetMapping("/add") // 4.3부터 추가
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // 신규회원 가입
// 	@PostMapping("/register/save")
	@PostMapping("/add")
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		
		//수동검증  
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result);
		
		//User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여줘야 함. 
		if(result.hasErrors()) {
			return "registerForm";
		}
		
//		//유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "forward:/register/add"; // 신규회원 가입화면으로 이동(redirect)
//		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
	
}