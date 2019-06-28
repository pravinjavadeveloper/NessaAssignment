package com.pravin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pravin.nessa.model.LeadUtm;
import com.pravin.nessa.model.ResponseBean;
import com.pravin.nessa.model.Token;

/**
 * 
 * @author Pravin C
 *
 */
@WebServlet("/add_lead_utm")
public class Resource extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg_class", "d-none");
		request.setAttribute("err_msg_class", "d-none");
		RequestDispatcher rd=request.getRequestDispatcher("/"); 
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		LeadUtm leadUtm = new LeadUtm(request.getParameter("fullName"), request.getParameter("email"), request.getParameter("phoneType_N"), request.getParameter("phoneNo"));
		leadUtm.setUtmContent(request.getParameter("utmContent"));
		leadUtm.setUtmMedium(request.getParameter("utmMedium"));
		leadUtm.setUtmTerm(request.getParameter("utmTerm"));
		leadUtm.setNotes(request.getParameter("notes"));
		leadUtm.setUtmUrl(request.getParameter("utmUrl"));
		
		String responseToken = new ServiceCaller().getAccessToken();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Token token = objectMapper.readValue(responseToken, Token.class);
			String responseData = new ServiceCaller().addLeadUtm(leadUtm, token.getAccess_token());
			ResponseBean responseBean = objectMapper.readValue(responseData, ResponseBean.class);
			if(responseBean.getSuccess()){
				request.setAttribute("msg", "Thank you! your data has been saved successfully.");
				request.setAttribute("msg_class", "d-block");
				request.setAttribute("err_msg_class", "d-none");
			}else{
				request.setAttribute("err_msg", "Please correct the error. "+responseBean.getMessage());
				request.setAttribute("msg_class", "d-none");
				request.setAttribute("err_msg_class", "d-block");
			}
		} catch (JsonParseException e) {
			request.setAttribute("err_msg", "Error occurred. "+e.getMessage());
			request.setAttribute("msg_class", "d-none");
			request.setAttribute("err_msg_class", "d-block");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			request.setAttribute("err_msg", "Error occurred. "+e.getMessage());
			request.setAttribute("msg_class", "d-none");
			request.setAttribute("err_msg_class", "d-block");
			e.printStackTrace();
		} catch (IOException e) {
			request.setAttribute("err_msg", "Error occurred. "+e.getMessage());
			request.setAttribute("msg_class", "d-none");
			request.setAttribute("err_msg_class", "d-block");
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/");  
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}