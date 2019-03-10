package com.xiaaman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaaman.dao.RelationDao;
import com.xiaaman.domain.Relation;
import com.xiaaman.service.RelationService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("relationService")
public class RelationServiceImpl implements RelationService{
	@Autowired
	private RelationDao relationDao;
	@Override
	public void addRelation(Relation relation) {
		// TODO Auto-generated method stub
		relationDao.addRelation(relation);
	}

}
