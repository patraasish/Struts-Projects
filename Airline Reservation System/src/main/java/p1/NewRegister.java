package p1;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class NewRegister extends ActionSupport implements ServletRequestAware,ServletResponseAware
	{
	HttpServletRequest req;
	HttpServletResponse res;
	Connection con=null;
	ResultSet rs=null;
	Statement st=null;
	
	public void setServletRequest(HttpServletRequest req)
		{
		this.req=req;
		}
	public void setServletResponse(HttpServletResponse res)
		{
		this.res=res;
		}
	
	
	public String execute() throws Exception
		{
	//	String s1="";
		PrintWriter out=res.getWriter();
		String name=req.getParameter("nm");
		System.out.println(name);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","air","air");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select USERNAME from USER_LOGIN where USERNAME='"+name+"'");
			if(rs.next())
				{
				System.out.println("111111");
				String s2="<font color='red'>Username is not available</font>";
				out.println(s2);
				}
			else
				{
				
				System.out.println("222222");
				String s2="<font color='green'>Username is available</font>";
				out.println(s2);
				}
			rs.close();
	//		out.println(s1);
						
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		}
	
	
	public String CheckFlightid() throws Exception
		{
		PrintWriter out=res.getWriter();
		Long fid=Long.parseLong(req.getParameter("fid"));
		System.out.println(fid);
			try{
			ResultSet rs=DbConnect.getStatement().executeQuery("select FLIGHTID from FLIGHT_INFO where FLIGHTID='"+fid+"'");
			if(rs.next())
				{
				System.out.println("111111");
				String s2="<font color='red'>Flightid is not available</font>";
				out.println(s2);
				}
			else
				{
				
				System.out.println("222222");
				String s2="<font color='green'>Flightid is available</font>";
				out.println(s2);
				}
			rs.close();
						
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		}
	
	public String GetFlightid() throws Exception
		{
		PrintWriter out=res.getWriter();
		Long fid=Long.parseLong(req.getParameter("fid"));
		System.out.println(fid);
		out.println(fid);
		return null;
		}
	
	
	}
