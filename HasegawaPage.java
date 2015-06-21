import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class SrvTest
 */
public class HasegawaPage extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response)
      throws IOException, ServletException {

  request.setAttribute("title", "Compass");
    Connection conn = null;
    String url = "jdbc:mysql://localhost/compasshp";
    String user = "root";
    String password = "root";
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      //out.println("OK<br>");
      conn = (Connection) DriverManager.getConnection(url, user, password);



      Statement stmt = conn.createStatement();
      String sql = "SELECT * FROM image";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
        int num = rs.getInt("num");
        String n = String.valueOf(num);
        String path = rs.getString("path");
        request.setAttribute(n, path);
      }

    }catch (ClassNotFoundException e){

    }catch (Exception e){

    }




    getServletConfig().getServletContext().
    getRequestDispatcher("/HasegawaPage.jsp").
    forward( request, response );

  }


}



