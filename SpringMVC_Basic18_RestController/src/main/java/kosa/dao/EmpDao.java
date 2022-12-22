package kosa.dao;

import java.util.List;

import kosa.vo.Emp;

public interface EmpDao {
	//전체조회
	public List<Emp> getEmpList() throws Exception;
	
	//조건조회
	public List<Emp> getEmp(String ename) throws Exception;
	
	//추가
	public int insert(Emp emp) throws Exception;
	
	//삭제
	public int delete(int empno) throws Exception;
	
	//수정
	public int update(Emp emp) throws Exception;
}
