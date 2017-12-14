package ua.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import ua.annotation.Handler;

@Handler("/*")
@Service
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -1904631909048608006L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>Hello</h1><form method='POST'><input name='name'></form>");
		response.getWriter().println("session=" + request.getSession(true).getId());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("name");
		System.out.println(parameter);
		resp.sendRedirect("/");
	}
}