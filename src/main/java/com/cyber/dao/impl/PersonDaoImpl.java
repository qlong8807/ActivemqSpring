package com.cyber.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.cyber.dao.PersonDao;
import com.cyber.dao.entity.Person;

public class PersonDaoImpl extends SqlMapClientDaoSupport implements PersonDao{

	@Override
	public boolean insertPerson(Person person) {
		System.out.println(person.toString());
		getSqlMapClientTemplate().insert("insertPerson",person);
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		getSqlMapClientTemplate().delete("deleteById", id);
		return false;
	}

	@Override
	public boolean updatePerson(Person person) {
		return false;
	}

	@Override
	public Person queryById(int id) {
		List queryForList = getSqlMapClientTemplate().queryForList("queryById", id);
		if(null != queryForList && queryForList.size() > 0){
			return (Person) queryForList.get(0);
		}
		return null;
	}

	@Override
	public List<Person> queryAllPerson() {
		List<Person> persons = getSqlMapClientTemplate().queryForList("queryAllPerson");
		return persons;
	}

}
