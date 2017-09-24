package dao;

import java.util.List;

import entity.Usertbl;

public interface UsertblDao {
		public List<Usertbl> findAll();
		   
		public void delete(Usertbl user);
		   
		public int save(Usertbl user);
		   
		public void update(Usertbl user);
		   
		public Usertbl findById(int id);
		
		public Usertbl checkLogin(String name,String pwd);
}
