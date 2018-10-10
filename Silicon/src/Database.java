

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Database extends HttpServlet {
	public static Connection co;
	public static Statement st;
	void connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		co=DriverManager.getConnection("jdbc:mysql://localhost:3306/malai","root","root");
		System.out.println("connected");
	}
	void insert(String name,String lastname,String gmail,String phone,String address)throws SQLException {
		st=co.createStatement();
		st.execute("insert into feed(name,lastname,gmail,phone,address) values('"+name+"','"+lastname+"','"+gmail+"','"+phone+"','"+address+"')");
		System.out.println(name);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String s=request.getParameter("nme");
		String s1=request.getParameter("lm");
		String s2=request.getParameter("gmail");
		String s3=request.getParameter("phne");
		String s4=request.getParameter("adds");
		//String s5=request.getParameter("file");
		String s6=request.getParameter("feedback");
		PrintWriter out=response.getWriter();
		out.print("successfully added feedback");
		try {
			connect();
			insert(s,s1,s2,s3, s4);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
response.sendRedirect("https://www.google.co.in/search?q=silicon+software+services+google+reviews&oq=sili&aqs=chrome.0.69i59j0l2j69i60j69i61j69i60.2319j0j7&sourceid=chrome&ie=UTF-8#lrd=0x3b00c595cee2c13b:0x4c8201e5753378d1,3,,,"+s6 );		
	}

}
