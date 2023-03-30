import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.*;



public class insert extends GenericServlet
{
    public void service (ServletRequest req,ServletResponse res)
    throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        
        pw.println("<html><body bgcolor='red'>");
        pw.println("<h1>Welcome to ITM university</h1>");
        pw.println("</body></html>");

        String s1=req.getParameter("t1");
        String s2= req.getParameter("t2");
        String s3= req.getParameter("t3");
        String s4= req.getParameter("t4");
        String s5= req.getParameter("t5");
         
        pw.println("data Recived");

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            pw.println("Driver Loaded Successfully\n");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mydb", "anu");
                    pw.println("connected with oracle Successfully12345\n");
                     // String query="insert into regform values(?,?,?,?)";
                      PreparedStatement ps=con.prepareStatement("insert into regform values(?,?,?,?,?)");
pw.println("Statement ctreated Successfully12345\n");
                      ps.setInt(1,Integer.parseInt(s1));
			pw.println("Line-1\n");
                      ps.setString(2,s2);
		pw.println("Line-2\n");
                      ps.setString(3,s3);
                      ps.setInt(4,Integer.parseInt(s4));
		pw.println("Line-3\n");
                      ps.setString(5,s5);
		pw.println("Line-4\n");
pw.println("data Replaced Successfully12345\n");
                      
                      int i=ps.executeUpdate();
                      if(i>0){
                         pw.println("Registration is successfull");
                      }
        }
        catch (ClassNotFoundException e){
            pw.println("Driver Problem"+e.getMessage());
        }
        catch(SQLException e){
            pw.println("record with given ID already exist"+e.getMessage());
        }
        pw.close();
    }

    
}
