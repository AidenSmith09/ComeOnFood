package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.CheckTableDao;
import com.amaker.dao.UpdateDao;
import com.amaker.dao.impl.CheckTableDaoImpl;
import com.amaker.dao.impl.UpdateDaoImpl;
import com.amaker.util.DBUtil;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateDao dao = new UpdateDaoImpl();
		// 获得菜谱列表
		List list = dao.getMenuList();
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		
		// 转换为字符串
		String msg = DBUtil.buildJson(list);
		// 返回给客户端
		out.print(msg);
		out.flush();
		out.close();
	}

}
