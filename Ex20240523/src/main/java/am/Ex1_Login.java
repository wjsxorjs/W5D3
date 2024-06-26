package am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.MemberVO;

/**
 * Servlet implementation class Ex1_Login
 */
public class Ex1_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 보통 로그인을 수행할 때 로그인과 비밀번호는 한글로 하는 경우가 없으므로
		// 요청 시 한글처리는 생략하겠다.
		// 1. 파라미터들(mid,mpw)받기
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		// DB로부터 인증받기 위해 login mapper를 호출해야한다.
		
		Map<String, String> l_map = new HashMap<>();
		l_map.put("mid",mid);
		l_map.put("mpw",mpw);
		
		Reader r = Resources.getResourceAsReader("am/config/config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		r.close();
		
		SqlSession ss = factory.openSession();
		MemberVO mvo = ss.selectOne("member.login",l_map);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(mvo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("mvo", mvo); // (key, value)
			response.sendRedirect("Ex1_Service");
//			out.println("<h2>로그인 성공</h2>");
//			out.println("<button type='button'");
//			out.println("onclick='javascript:location.href=\"Ex1_Service\"'>");
//			out.println("홈으로</button>");
		} else {
			out.println("<h2>로그인 실패</h2>");
			out.println("<button type='button'");
			out.println("onclick='javascript:location.href=\"Ex1_Service\"'>");
			out.println("홈으로</button>");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
