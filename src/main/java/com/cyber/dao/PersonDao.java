package com.cyber.dao;

import java.util.List;

import com.cyber.dao.entity.Person;

public interface PersonDao {
	public boolean insertPerson(Person person); // ���

	public boolean deleteById(int id); // ɾ��

	public boolean updatePerson(Person person); // �޸�

	public Person queryById(int id); // ����ID��ѯ

	public List<Person> queryAllPerson(); // ��ѯȫ��
}
