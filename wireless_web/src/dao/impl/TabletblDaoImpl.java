package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateSessionFactory;

import dao.TabletblDao;
import entity.Orderdetailtbl;
import entity.Ordertbl;
import entity.Tabletbl;

public class TabletblDaoImpl implements TabletblDao {

	public List<Tabletbl> findAll() {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		List<Tabletbl> menutblList=session.createQuery("from Tabletbl").list();
		tran.commit();
		session.close();
		return menutblList;
	}

	public void delete(Tabletbl table) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.delete(table);
		tran.commit();
		session.close();

	}

	public int save(Tabletbl table) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(table);
		tran.commit();
		session.close();
		return table.getId();
	}

	public void update(Tabletbl table) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.update(table);
		tran.commit();
		session.close();

	}

	public Tabletbl findById(int id) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		Tabletbl table=(Tabletbl) session.createQuery("from Tabletbl where id=?").setInteger(0, id).uniqueResult();
		tran.commit();
		session.close();
		return table;
	}

}
