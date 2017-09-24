package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.Contants;
import utils.HibernateSessionFactory;

import dao.UsertblDao;
import entity.Ordertbl;
import entity.Usertbl;

public class UsertblDaoImpl implements UsertblDao {

	public List<Usertbl> findAll() {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		List<Usertbl> menutblList=session.createQuery("from Usertbl").list();
		tran.commit();
		session.close();
		return menutblList;
	}

	public void delete(Usertbl user) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.delete(user);
		tran.commit();
		session.close();

	}

	public int save(Usertbl user) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(user);
		tran.commit();
		session.close();
		return user.getId();
	}

	public void update(Usertbl user) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.update(user);
		tran.commit();
		session.close();

	}

	public Usertbl findById(int id) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		Usertbl user=(Usertbl) session.createQuery("from Usertbl where id=?").setInteger(0, id).uniqueResult();
		tran.commit();
		session.close();
		return user;
	}

	public Usertbl checkLogin(String name, String pwd) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		Usertbl user=(Usertbl) session.createQuery("from Usertbl where name = ? and password = ? and permission = ?").setString(0, name).setString(1, pwd).setInteger(2, Contants.CUSTOMER).uniqueResult();
		tran.commit();
		session.close();
		return user;
	}
	public static void main(String[] args) {
		UsertblDaoImpl imp = new UsertblDaoImpl();
		Usertbl user = new Usertbl();
		user.setName("nqr");
		user.setPassword("nqr");
		user.setAccount("nqr");
		user.setPermission(Contants.CUSTOMER);
		imp.save(user);
	}

}
