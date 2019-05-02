import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
@WebServlet("/LoggedIn")
public class LoggedIn extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LoggedIn() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
         response.setContentType("text/html");
            //PrintWriter ps = response.getWriter();
            //String un = request.getParameter("Username");
            //String pswd = request.getParameter("pass");
            //HttpSession session=request.getSession(true);
         	String un=(String)request.getSession().getAttribute("un");
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/tbms","root","mysql");
                Statement stmt = conn.createStatement();    
                String query1 = "select * from customer where username ='"+un+"' ;";
                ResultSet rs= stmt.executeQuery(query1);
                while(rs.next())
    			{
                	RequestDispatcher red=request.getRequestDispatcher("loginpage.jsp");
                    red.forward(request, response);
    				
    			}

        
    }catch (Exception e)
        {
        e.printStackTrace();
        }
    // ps.close();       
    }}