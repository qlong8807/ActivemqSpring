package com.cyber.mybatis;

import com.cyber.dao.entity.Person;

public interface MyBatisPersonDao {
	
	public Person getPerson(Person user);

	public void addPerson(Person user);

	public void updatePerson(Person user);

	public void deletePerson(int UserId);
}
