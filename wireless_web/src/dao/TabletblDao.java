package dao;

import java.util.List;

import entity.Tabletbl;

public interface TabletblDao {
		public List<Tabletbl> findAll();
		   
		public void delete(Tabletbl table);
		   
		public int save(Tabletbl table);
		   
		public void update(Tabletbl table);
		   
		public Tabletbl findById(int id);
}
