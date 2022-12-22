package kr.or.kosa.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosa.dao.EmpDao;
import kr.or.kosa.dto.Emp;

@Service
public class EmpService {
	
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	public List<Emp> select(){
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);
		//인터페이스를  mapper가 구현했다(mybatis)
		List<Emp> emplist = empdao.select();
		return emplist;
	}
	
	public Emp selectByEmpno(int empno){
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);
		
		Emp emp = empdao.selectByEmpno(empno);
		
		return emp;
	}
	
	public int insert(Emp emp) {
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);
		
		int result = empdao.insert(emp);
		return result;
	}
	
	public int update(Emp emp) {
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);
		
		int result = empdao.update(emp);
		return result;
	}
	
	public int delete(int empno) {
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);
		
		int result = empdao.delete(empno);
		return result;
	}
}
