import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/Shopping_Cart.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		PrintWriter out = response.getWriter();
		System.out.println("Filter Called");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","");
			Statement stmt = con.createStatement();
			String user = request.getParameter("username");
			String pass = request.getParameter("pass");
			
			String query = "SELECT * FROM login_info WHERE user_name='"+user+"'";
			try {
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					if(pass.compareTo(rs.getString("password")) == 0) {
						out.println("User Login");
						
						request.setAttribute("user", user);
						
						// pass the request along the filter chain
						chain.doFilter(request, response);
										
					}
					else {
						RequestDispatcher dis = request.getRequestDispatcher("Error.jsp");
						dis.forward(request, response);
					}
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("User Does Not Exist");
				out.println("User Does Not Exist");
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in Connection With Database ");
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}

