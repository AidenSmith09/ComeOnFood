package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import dao.UsertblDao;
import dao.impl.UsertblDaoImpl;
import entity.Usertbl;

public class RegisterServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		Usertbl user = new Usertbl();
		user.setName(name);
		user.setAccount(name);
		user.setPassword(pwd);
		user.setPermission(2);
		
		UsertblDao userDao = new UsertblDaoImpl();
		userDao.save(user);
		JSONObject json = null;
		
		json = new JSONObject();
		json.put("success","注册成功，请登录!");
		
		out.print(json);
	}

}
