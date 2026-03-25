package com.google.app.departments;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/dept/list")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getMethod());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRequestURL());
		
		DepartmentDAO dao = new DepartmentDAO();
		
		try {
			ArrayList<DepartmentDTO> ar = dao.list();
			
			// 응답을 내보내기 위한 메서드			
//			PrintWriter out = response.getWriter();
//			for(int i = 0;i<ar.size();i++) {
//				out.println("<h4>");
//				out.println(ar.get(i).getDepartmentName());
//				out.println("</h4>"); 
//			}
			request.setAttribute("list", ar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/dept/list.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
