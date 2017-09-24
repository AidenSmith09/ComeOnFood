package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import shopping.CarItemBean;
import shopping.ShoppingCar;
import dao.impl.OrderdetailDaoImpl;
import dao.impl.OrdertblDaoImpl;
import entity.Menutbl;
import entity.Orderdetailtbl;
import entity.Ordertbl;
import entity.Usertbl;

public class OrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String personNum = request.getParameter("personNum");
		String remark = request.getParameter("remark");
		HttpSession session = request.getSession();
		ShoppingCar car = (ShoppingCar) session.getAttribute("caritems");
		
		Usertbl user = (Usertbl) session.getAttribute("loginer");
		Ordertbl order = new Ordertbl();
		order.setIsPay(0);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-ss hh:mm:ss");
		order.setOrderTime(sf.format(new Date()));
		if(personNum != null){
			order.setPersonNum(Integer.parseInt(personNum));
		}else{
			order.setPersonNum(0);
		}
		order.setRemark(remark);
		order.setUserId(user.getId());
		OrdertblDaoImpl imp = new OrdertblDaoImpl();
		int id = imp.save(order);
		
		//插入订单明细
		OrderdetailDaoImpl detailDao = new OrderdetailDaoImpl();
		
		HashMap<Integer, CarItemBean> items = car.getItems();
		Collection<CarItemBean> cols = items.values();
		for(CarItemBean bean:cols){
			Menutbl menu = bean.getMenu();
			Orderdetailtbl detail = new Orderdetailtbl();
			detail.setMenuId(menu.getId());
			detail.setNum(bean.getNumber());
			detail.setOrderId(order.getId());
			detail.setRemark("");
			detailDao.save(detail);
		}
		
		JSONObject json = new JSONObject();
		json.put("success", "成功");
		json.put("id", id);
		PrintWriter out = response.getWriter();
		session.removeAttribute("caritems");
		out.print(json);
	}

}
