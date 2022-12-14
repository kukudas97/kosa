package service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmpDao;
import dto.Emp;


@Service
public class EmpService {
	private SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// = = List = =
		public List<Emp> empList(String pg, String f,String p) {
			
			//DAO 작업
			List<Emp> list = null;
			try {
				EmpDao empdao = sqlSession.getMapper(EmpDao.class);
				list = empdao.getNotices(Integer.parseInt(pg), f, p);
			} catch (ClassNotFoundException e) {e.printStackTrace();
			} catch (SQLException e) {e.printStackTrace();}
			
			return list;
		}
		//Detail 상세보기
		public Emp noticeDetail(int empno) {

			Emp emp = null;
			try {
				EmpDao empdao = sqlSession.getMapper(EmpDao.class);
				emp = empdao.getNotice(empno);
			} catch (ClassNotFoundException e) {e.printStackTrace();
			} catch (SQLException e) {e.printStackTrace();	}
			
			return emp;
		}

		//글쓰기 처리 서비스
		public String noticeWriteOk(Emp emp) {
			
			
			
			return "redirect:notice.htm";
		}
		
		//수정 처리
		public Emp noticeEdit(int empno) {

			Emp emp = null;
			try {
				EmpDao empdao =  sqlSession.getMapper(EmpDao.class);
				emp = empdao.getNotice(empno);
			} catch (ClassNotFoundException e) {e.printStackTrace();
			} catch (SQLException e) {e.printStackTrace();	}
			
			
			return emp;
		}
		
		//수정 처리
		public String noticeEditOk(Emp emp) {
			int row = 0;
			
			try {
				EmpDao empdao =  sqlSession.getMapper(EmpDao.class);
				row = empdao.update(emp);
			} catch (ClassNotFoundException e) {e.printStackTrace();
			} catch (SQLException e) {e.printStackTrace();
			}
			
			return "redirect:noticeDetail.htm";
		}
		
		//글 삭제하기 처리 서비스
		public String noticeDel(int empno) {
			
			try {
				EmpDao empdao =  sqlSession.getMapper(EmpDao.class);
				empdao.delete(empno);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:emp.do";
		}
}
