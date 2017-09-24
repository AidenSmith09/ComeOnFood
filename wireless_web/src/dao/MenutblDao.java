package dao;

import java.util.List;

import entity.Menutbl;

public interface MenutblDao {
		public List<Menutbl> findAll();
		   
		public void delete(Menutbl menu);
		   
		public int save(Menutbl menu);
		   
		public void update(Menutbl menu);
		   
		public Menutbl findById(int id);
}
