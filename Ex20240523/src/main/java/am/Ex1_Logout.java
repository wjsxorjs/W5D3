package am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Ex1_Logout
 */
public class Ex1_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 로그인 당시 저장했던 값("mvo") 삭제
		session.removeAttribute("mvo");

		response.setContentType("text/html; charset=utf-8");


		// 강제이동
		response.sendRedirect("Ex1_Service"); // request와 response를 들고가지않는다. 새로 만들어야함
		// forward: request와 response를 들고간다. 새로 만들어지지않고 이미 가지고 있던 걸 가지고 갈 수 있다.
		
		

//		PrintWriter out = response.getWriter();
//		out.println("<h2>로그아웃 성공</h2>");
//		out.println("<button type='button'");
//		out.println("onclick='javascript:location.href=\"Ex1_Service\"'>");
//		out.println("홈으로</button>");
//		out.close();

		
		
		// 세션에 저장하는 것 : 세션이 종료될 때까지, 브라우저에 저장됨, 나만 사용가능
		// 애플리케이션에 저장하는 것 : 서버가 종료될 때까지. 서버에 저장됨. 다른 사람도 이용가능
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
