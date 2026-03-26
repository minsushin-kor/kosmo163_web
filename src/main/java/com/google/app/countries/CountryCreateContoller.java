package com.google.app.countries;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.app.departments.DepartmentDAO;
import com.google.app.departments.DepartmentDTO;

/**
 * Servlet implementation class CountryCreateContoller
 */
@WebServlet("/country/create")
public class CountryCreateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryCreateContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/country/create.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = request.getParameter("countryId");
		String name = request.getParameter("countryName");
		String rid = request.getParameter("regionId");
		
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setCountryId(cid);
		countryDTO.setCountryName(name);
		countryDTO.setRegionId(Integer.parseInt(rid));
		
		CountriesDAO countriesDAO = new CountriesDAO();
		
		try {
			int result = countriesDAO.create(countryDTO);
			if(result > 0) {
				response.sendRedirect("/country/list");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
