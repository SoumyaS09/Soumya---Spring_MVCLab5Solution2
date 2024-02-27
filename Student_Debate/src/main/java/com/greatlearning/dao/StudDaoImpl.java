package com.greatlearning.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.entity.Stud;

@Repository
public class StudDaoImpl implements StudDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int saveStud(Stud stud) {
		int i = (Integer) hibernateTemplate.save(stud);
		return i;
	}

	public Stud getStudById(int id) {
		Stud stud = hibernateTemplate.get(Stud.class, id);
		return stud;
	}

	public List<Stud> getAllStud() {
		List<Stud> list = hibernateTemplate.loadAll(Stud.class);
		return list;
	}

	@Transactional
	public void update(Stud stud) {
		hibernateTemplate.update(stud);
	}

	@Transactional
	public void deleteStud(int id) {
		Stud stud = hibernateTemplate.get(Stud.class, id);
		hibernateTemplate.delete(stud);

	}

}
