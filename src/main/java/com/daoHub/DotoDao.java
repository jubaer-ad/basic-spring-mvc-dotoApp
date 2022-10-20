package com.daoHub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entityHub.Doto;

@Component
public class DotoDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public int save(Doto doto) {
		return (Integer) hibernateTemplate.save(doto);
	}
	
	public List<Doto> getAll() {
		return hibernateTemplate.loadAll(Doto.class);
	}

}
