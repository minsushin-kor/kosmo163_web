package com.google.app.departments;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DepartmentUpdateController
 */
@WebServlet("/dept/update")
public class DepartmentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터를 꺼내오는 과정
		// url에 update만 입력하는 경우 exception이 발생하는 이유 : 데이터가 없어 null값이 되는데 이를 int로 변경하는 과정에서 예외가 발생
		String id = request.getParameter("departmentId");
		int n = Integer.parseInt(id);
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		try {
			DepartmentDTO departmentDTO = departmentDAO.detail(n);
			// JSP 경로로 보내주는 역할
			request.setAttribute("dto", departmentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// JSP 경로
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/dept/update.jsp");
		view.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepartmentDTO departmentDTO = new DepartmentDTO();
		int i = Integer.parseInt(request.getParameter("departmentId"));
		String n = request.getParameter("departmentName");
		String m = request.getParameter("managerId");
		int mid = Integer.parseInt(m);
		String l = request.getParameter("locationId");
		int lid = Integer.parseInt(l);
		
		departmentDTO.setDepartmentId(i);
		departmentDTO.setDepartmentName(n);
		departmentDTO.setManagerId(mid);
		departmentDTO.setLocationId(lid);
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		try {
			int result = departmentDAO.update(departmentDTO);
			if(result > 0) {
				response.sendRedirect("./list");
			}
			else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
