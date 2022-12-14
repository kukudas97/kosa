package dao;

import java.sql.SQLException;
import java.util.List;

import dto.Emp;

public interface EmpDao {
		//전체 회원
		public List<Emp> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException;
		
		//회원 상세
		public Emp getNotice(int empno) throws ClassNotFoundException, SQLException;
		
		//회원 삭제
		public int delete(int empno) throws ClassNotFoundException, SQLException;
		
		//회원 수정
		public int update(Emp emp) throws ClassNotFoundException, SQLException;

		//회원 추가
		public int insert(Emp emp) throws ClassNotFoundException, SQLException ;
}
