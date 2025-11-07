public class EmployeeServlet {
    
}
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empid = request.getParameter("empid");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");

            Statement st = con.createStatement();
            String query;

            if (empid != null && !empid.isEmpty()) {
                query = "SELECT * FROM Employee WHERE EmpID=" + empid;
            } else {
                query = "SELECT * FROM Employee";
            }

            ResultSet rs = st.executeQuery(query);

            out.println("<h2>Employee Records</h2>");
            out.println("<table border='1'><tr><th>EmpID</th><th>Name</th><th>Salary</th></tr>");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2)
                        + "</td><td>" + rs.getDouble(3) + "</td></tr>");
            }

            out.println("</table>");
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
