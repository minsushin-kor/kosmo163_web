package com.google.app.community;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Servlet implementation class CommunityCreateController
 */
@WebServlet("/comm/create")
public class CommunityCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/community/create.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String contents = request.getParameter("contents");
		String star = request.getParameter("star");
		
				
		CommunityDTO communityDTO = new CommunityDTO();
		
		communityDTO.setNum(Long.parseLong(num));
		communityDTO.setTitle(title);
		communityDTO.setName(name);
		communityDTO.setContents(contents);
		communityDTO.setStar(Integer.parseInt(star));
		
		CommunityDAO communityDAO = new CommunityDAO();
		
		try {
	        int result = communityDAO.update(communityDTO);
	        
	        if(result > 0) {
	            // 성공 시 상세 페이지나 목록으로 이동
	            response.sendRedirect("./list");
	        } else {
	            // 실패 시 다시 수정 폼으로 이동하거나 메시지 처리
	        	response.sendRedirect("./update?num=" + num);
	        }
	    } 
		catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
