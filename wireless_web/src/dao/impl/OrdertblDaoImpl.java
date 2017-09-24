package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateSessionFactory;

import dao.OrdertblDao;
import entity.Orderdetailtbl;
import entity.Ordertbl;

public class OrdertblDaoImpl implements OrdertblDao {

	public List<Ordertbl> findAll() {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		List<Ordertbl> menutblList=session.createQuery("from Ordertbl").list();
		tran.commit();
		session.close();
		return menutblList;
	}

	public void delete(Ordertbl order) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.delete(order);
		tran.commit();
		session.close();
	}

	public int save(Ordertbl order) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(order);
		tran.commit();
		session.close();
		return order.getId();
	}

	public void update(Ordertbl order) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.update(order);
		tran.commit();
		session.close();
	}

	public Ordertbl findById(int id) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		Ordertbl order=(Ordertbl) session.createQuery("from Ordertbl where id=?").setInteger(0, id).uniqueResult();
		tran.commit();
		session.close();
		return order;
	}

}
