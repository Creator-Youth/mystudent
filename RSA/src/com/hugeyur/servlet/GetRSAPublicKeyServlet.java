package com.hugeyur.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hugeyurt.util.RSAEncrypt;

/**
 * Servlet implementation class GetRSAPublicKeyServlet
 */
@WebServlet("/getpublic")
public class GetRSAPublicKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public GetRSAPublicKeyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("hello");
		PrintWriter out=response.getWriter();
		out.write(RSAEncrypt.keyMap.get(0));
	}

}
