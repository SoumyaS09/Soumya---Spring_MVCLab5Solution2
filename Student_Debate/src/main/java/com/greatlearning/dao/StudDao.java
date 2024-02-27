package com.greatlearning.dao;

import java.util.List;

import com.greatlearning.entity.Stud;

public interface StudDao {

	public int saveStud(Stud stud);

	public Stud getStudById(int id);

	public List<Stud> getAllStud();

	public void update(Stud stud);

	public void deleteStud(int id);
}
