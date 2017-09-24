package dao;

import java.util.List;

import entity.Orderdetailtbl;


public interface OrderdetailDao {
		public List<Orderdetailtbl> findAll();
		   
		public void delete(Orderdetailtbl detail);
		   
		public int save(Orderdetailtbl detail);
		   
		public void update(Orderdetailtbl detail);
		   
		public Orderdetailtbl findById(int id);
}
