package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateSessionFactory;
import dao.MenutblDao;
import entity.Menutbl;

public class MenutblDaoImpl implements MenutblDao {

	public List<Menutbl> findAll() {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		List<Menutbl> menutblList=session.createQuery("from Menutbl").list();
		tran.commit();
		session.close();
		return menutblList;
	}

	public void delete(Menutbl menu) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.delete(menu);
		tran.commit();
		session.close();
	}

	public int save(Menutbl menu) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(menu);
		tran.commit();
		session.close();
		return menu.getId();
	}

	public void update(Menutbl menu) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.update(menu);
		tran.commit();
		session.close();

	}

	public Menutbl findById(int id) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		Menutbl menu=(Menutbl) session.createQuery("from Menutbl where id=?").setInteger(0, id).uniqueResult();
		tran.commit();
		session.close();
		return menu;
	}
	
	public static void main(String[] args) {
		MenutblDaoImpl imp = new MenutblDaoImpl();
		int id = imp.save(new Menutbl("特色炒饭",8,"images/500034.jpg","原料：蘑菇、鸡蛋、胡萝卜、青椒、绿色蔬菜。口感极好！"));
		System.out.println(id);
	}

}
