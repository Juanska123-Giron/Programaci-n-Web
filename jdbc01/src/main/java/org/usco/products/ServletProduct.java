package org.usco.products;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.usco.utils.DataBase;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProduct
 */
@WebServlet("/ServletProduct")
public class ServletProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletProduct() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		try {
		    DataBase database = new DataBase();
		    Connection con1 = database.getConnection();
		    Statement stm1 = con1.createStatement();
//_____________________Agregar datos a la tabla productos_______________//
		    
		    String sql = "INSERT INTO public.products(category, name, price, photo)";
		    sql += "VALUES (1, 'Pollo', 13000, 'pollo.jpeg')";
		    int insertados = stm1.executeUpdate(sql);
		    
		    
//_____________________Para leer productos_____________________//		    
		    sql = "select * from products";
		    ResultSet rs1 = stm1.executeQuery(sql);
		    //BOF Begining of file
		    while(rs1.next()) {
		    	int id = rs1.getInt("id");
		    	int category = rs1.getInt("category");
		    	String name = rs1.getString("name");
		    	double price = rs1.getDouble("price");
		    	String foto = rs1.getString("photo");
		    	
		    	out.println("<p>" + id + "</p>");
		    	out.println("<p>" + category + "</p>");
		    	out.println("<p>" + name + "</p>");
		    	out.println("<p>" + price + "</p>");
		    	out.println("<p>" + foto + "</p>");
		    	
		    }
		    
		    
		    
		    
		    //EOF End
		}
		catch(Exception e){
			System.out.println("Error:" + e.toString());
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
