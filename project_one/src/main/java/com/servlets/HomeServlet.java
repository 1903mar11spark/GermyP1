package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParser; 
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class HomeServlet extends HttpServlet {

		/**
	 * 
	 */
	private static final long serialVersionUID = 4760485627819196392L;

		public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			
			int i = Integer.parseInt(req.getParameter("num1"));
			int j = Integer.parseInt(req.getParameter("num2"));
			
			int k = i + j;
			PrintWriter out = res.getWriter();
			out.println("Result is " + k);
			
			String email = req.getParameter("email");
			String password = req.getParameter("pwd");
			
		}
}
