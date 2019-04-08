
import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Getparam extends HttpServlet {

public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException

{

response.setContentType("text/html");
System.out.println("hi");
PrintWriter out = response.getWriter();
String username=request.getParameter("t1");
String password=request.getParameter("t2");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement pst = conn.prepareStatement("Select username,password from login where username=? and password=?");
            pst.setString(1, username);
            pst.setString(2, password);
			Cookie c=new Cookie("name",username);
			response.addCookie(c);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                out.println("You are authenticate user\n");
				Cookie c1[]=request.getCookies();
				out.println("Welcome "+c1[0].getValue());
            } 
            else {
                out.println("Incorrect login credentials");
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
