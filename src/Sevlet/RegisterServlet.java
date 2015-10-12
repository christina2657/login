package Sevlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.user;
	public class RegisterServlet extends HttpServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//获取请求的参数值
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");		
					
			user user=new user();
			System.out.println(username+password + phone);
			try {
				user.sentdata(username,password,phone);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
	}
}
