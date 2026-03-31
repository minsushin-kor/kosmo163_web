package com.google.app.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
		memberInfoDTO.setId(id);
		memberInfoDTO.setPassword(pw);
		
		MemberInfoDAO dao = new MemberInfoDAO();
		
		
		try {
			memberInfoDTO = dao.login(memberInfoDTO);
			HttpSession session = request.getSession();
			session.setAttribute("dto", memberInfoDTO);
			if(memberInfoDTO != null) {
				response.sendRedirect("/home");
				System.out.println("로그인 성공");
			}
			else {
				response.sendRedirect("/member/login");
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
