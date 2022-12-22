package kosa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kosa.vo.Employee;

@Controller
public class AjaxController {
	
	@RequestMapping("response.kosa")
	public @ResponseBody Employee add(HttpServletRequest request, HttpServletResponse response) {
		//HttpServletRequest request, HttpServletResponse response 가장 전통적인 방법
		
		Employee employee = new Employee();
		employee.setFirstname(request.getParameter("firstName"));
		employee.setLastname(request.getParameter("lastName"));
		employee.setEmail(request.getParameter("email"));
		System.out.println(employee.toString());
		
		return employee; //Employee employee객체를 리턴 > {"firstName":"a", "lastName":"b"...}
	}
	
	//1. 클라이언트에서 전송된 데이터를 객체로 받기 :@RequestBody
	//2. 서버에서 클라이언트에 객체 전송하기	 :@RequestBody
	@RequestMapping("response2.kosa")
	public @ResponseBody Employee add(@RequestBody Employee emp) {
		
		System.out.println("response2.kosa");
		System.out.println(emp.toString());
		
		return emp;
	}
	
	//Java Api객체로 가능합니다
	@RequestMapping("response3.kosa")
	public @ResponseBody Map<String, Object> add(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "data");
		map.put("hello", "world");
		
		return map;
		//{"result":"data", "hello":"world"}
		//map.put("result":"success")활용...
	}
}
