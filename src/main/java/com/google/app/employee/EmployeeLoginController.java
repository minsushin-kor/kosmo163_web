package com.google.app.employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class EmployeeLoginController
 */
@WebServlet("/emp/login")
public class EmployeeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forword 방식
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/emp/login.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("employeeId");
		String pw = request.getParameter("password");
		int i = Integer.parseInt(id);
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setEmployeeId(i);
		employeeDTO.setPassword(pw);
		
		EmployeesDAO employeesDAO = new EmployeesDAO();
		
		try {
			employeeDTO = employeesDAO.login(employeeDTO);
			
			if(employeeDTO != null) {
				System.out.println("ok");
			}
			else {
				System.out.println("fail");
			}
			//세션에 dto를 담는 과정 
			//1. session 선언
			HttpSession session = request.getSession();
			//2. 세션에 dto 담기
			session.setAttribute("dto", employeeDTO);
			//3. 리다이렉트로 보내기
			response.sendRedirect("/home");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
