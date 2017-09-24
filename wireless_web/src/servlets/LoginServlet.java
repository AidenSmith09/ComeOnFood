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

public class LoginServlet extends HttpServlet {


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
		UsertblDao userDao = new UsertblDaoImpl();
		Usertbl user = userDao.checkLogin(name, pwd);
		JSONObject json = null;
		if(user != null){
			json = JSONObject.fromObject(user);
			HttpSession session = request.getSession();
			session.setAttribute("loginer", user);
		}else{
			json = new JSONObject();
			json.put("errorMsg","登录失败");
		}
		out.print(json);
	}

}
