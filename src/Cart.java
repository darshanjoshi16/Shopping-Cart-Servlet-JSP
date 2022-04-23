import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductInfo[]  p = new ProductInfo[4];
		p[0] = new ProductInfo("Cosmetics",2500);
		p[1] = new ProductInfo("HeadPhone Covers",1800);
		p[2] = new ProductInfo("AirPods",3000);
		p[3] = new ProductInfo("Smart Phone",25000);
		
		int[] arr = new int[4];
		int total =0;
		int tmp;
		int count =0;
		int top=-1;
		String itemName[] = new String[4];
		int itemPrice[] = new int[4];
		int itemQuantity[] = new int[4];
		
		String key;
		for(int i=0;i<4;i++) {
			key = "Product"+i;
			tmp = Integer.parseInt(request.getParameter(key));
			p[i].setQuantity(tmp);
			if(tmp != 0) {
				top++;
				itemName[top] = p[i].getProductName();
				itemPrice[top] = p[i].getPrice();
				itemQuantity[top] = p[i].getQuantity();
			}
			total = total + p[i].countPrice();
		}
		top++;
		
		
		HttpSession ses = request.getSession();
		ses.setAttribute("Total", total);
		ses.setAttribute("ProductCount", top);
		ses.setAttribute("ProductName", itemName);
		ses.setAttribute("ProductPrice", itemPrice);
		ses.setAttribute("ProductQuantity", itemQuantity);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Checkout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class ProductInfo{
	private String ProductName;
	private int price;
	private int quantity;
	
	public ProductInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductInfo(String name,int price) {
		// TODO Auto-generated constructor stub
		this.ProductName = name;
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int countPrice() {
		return this.quantity * this.price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getProductName() {
		return ProductName;
	}
}