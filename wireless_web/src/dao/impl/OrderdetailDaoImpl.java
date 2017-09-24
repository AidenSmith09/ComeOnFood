package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateSessionFactory;

import dao.OrderdetailDao;
import entity.Menutbl;
import entity.Orderdetailtbl;

public class OrderdetailDaoImpl implements OrderdetailDao {

	public List<Orderdetailtbl> findAll() {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		List<Orderdetailtbl> menutblList=session.createQuery("from Orderdetailtbl").list();
		tran.commit();
		session.close();
		return menutblList;
	}

	public void delete(Orderdetailtbl detail) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.delete(detail);
		tran.commit();
		session.close();

	}

	public int save(Orderdetailtbl detail) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(detail);
		tran.commit();
		session.close();
		return detail.getId();
	}

	public void update(Orderdetailtbl detail) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.update(detail);
		tran.commit();
		session.close();

	}

	public Orderdetailtbl findById(int id) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		Orderdetailtbl detail=(Orderdetailtbl) session.createQuery("from Orderdetailtbl where id=?").setInteger(0, id).uniqueResult();
		tran.commit();
		session.close();
		return detail;
	}
	

}
