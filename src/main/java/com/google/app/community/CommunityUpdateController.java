package com.google.app.community;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CommunityUpdateController
 */
@WebServlet("/comm/update")
public class CommunityUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		int n = Integer.parseInt(num);
		
		CommunityDAO dao = new CommunityDAO();
		
		try {
			CommunityDTO communityDTO = dao.detail(n);
			request.setAttribute("dto", communityDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JSP의 경로명을 써야 한다
		RequestDispatcher view	= request.getRequestDispatcher("/WEB-INF/views/community/update.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommunityDTO communityDTO = new CommunityDTO();
		
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String contents = request.getParameter("contents");
		String star = request.getParameter("star");
				
		communityDTO.setNum(Long.parseLong(num));
		communityDTO.setTitle(title);
		communityDTO.setName(name);
		communityDTO.setContents(contents);
		communityDTO.setStar(Integer.parseInt(star));
		
		CommunityDAO communityDAO = new CommunityDAO();
		
		try {
			int result = communityDAO.update(communityDTO);
			
			if(result>0) {
				response.sendRedirect("./list");
				System.out.println("수정되었습니다.");
			}else {
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


