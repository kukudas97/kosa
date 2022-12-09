package ncontroller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	public CustomerController() {
		System.out.println("controller");
	}
	
	private NoticeDao noticedao;
	
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	@RequestMapping("notice.htm")
	public String notice(String pg, String f, String q, Model model) {
		
		int page = 1;
		String field = "TITLE";
		String query = "%%";
		
		if(pg != null   && ! pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(f!= null   && !f.equals("")) {
			field = f;
		}
		
		if(q!= null   && !q.equals("")) {
			query  = q;
		}
		
		
		List<Notice> list = null;
		try {
			list = noticedao.getNotices(page, field, query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("list", list);
		
		return "notice";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq, Model model) {
		
		Notice notice = null;
		
		try {
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("notice", notice);
		
		return "noticeDetail";
	}
}
