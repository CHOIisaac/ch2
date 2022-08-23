package com.fastcampus.ch2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1.원격 호출 가능한 프로그럄으로 등록
@Controller
public class Hello {
	int iv = 10; //인스턴스 변수 
	static int cv = 20; //스태틱 변수 
	
	//2. URL과 메서드를 연결
	@RequestMapping("/hello") //인스턴스 메서드는 iv, cv 둘 다 사용 가능
	public static void main() {
		System.out.println("Hello - static");
		//System.out.println(iv);
		System.out.println(cv);
		
	}
	
	public static void main2() { //스태틱메서드는 cv만 사용 가능 
		System.out.println(cv);
		//System.out.println(iv);//에러 
	}
}
