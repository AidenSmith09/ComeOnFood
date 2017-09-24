package dao;

import java.util.List;

import entity.Ordertbl;

public interface OrdertblDao {
		public List<Ordertbl> findAll();
		   
		public void delete(Ordertbl order);
		   
		public int save(Ordertbl order);
		   
		public void update(Ordertbl order);
		   
		public Ordertbl findById(int id);
}
