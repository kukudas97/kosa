package kr.or.kosa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosa.dto.Emp;
import kr.or.kosa.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	//controller는 서비스에 의존합니다
	private EmpService empService;

	@Autowired
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	/*
	Restful방식의 annotation도 존재합니다
	@GetMapping
	@PostMapping
	@DeleteMapping
	@PutMapping
	@PatchMapping
	*/
	/*
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Emp> emplist(){
		return empService.select();
	}
	*/
	//전체조회
	@RequestMapping(value="",method=RequestMethod.GET)
	public ResponseEntity<List<Emp>> emplist(){
		List<Emp> list = new ArrayList<Emp>();
		
		try {
			System.out.println("정상실행");
			list = empService.select();
			return new ResponseEntity<List<Emp>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Emp>>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
	//조건조회
	@RequestMapping(value="{empno}",method=RequestMethod.GET)
	public Emp emplistByempno(@PathVariable("empno") int empno) {
		return empService.selectByEmpno(empno);
	}
	
	//삽입(POST)	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> insert(Emp emp){
		
		try {
			System.out.println("insert실행");
			empService.insert(emp);
			return new ResponseEntity<String>("insert success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("insert fail",HttpStatus.BAD_REQUEST);
		}
	}
	
	//수정(put)
	@RequestMapping(value="", method=RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestBody Emp emp){
		System.out.println(emp);
		try {
			System.out.println("update 실행");
			empService.update(emp);
			return new ResponseEntity<String>("update success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("update fail",HttpStatus.BAD_REQUEST);
		}
	}
	
	//삭제
	@RequestMapping(value="{empno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> Delete(@PathVariable("empno") int empno){
		try {
			System.out.println("delete 실행");
			empService.delete(empno);
			return new ResponseEntity<String>("delete success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("delete fail",HttpStatus.BAD_REQUEST);
		}
	}
}
