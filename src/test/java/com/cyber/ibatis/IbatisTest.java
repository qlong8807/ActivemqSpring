package com.cyber.ibatis;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cyber.dao.PersonDao;
import com.cyber.dao.entity.Person;

public class IbatisTest {
	private static ApplicationContext applicationContext = null; // �ṩ��̬ApplicationContext
	private static PersonDao personDao;
	static {
		applicationContext = new ClassPathXmlApplicationContext(
				"ibatis-applicationContext.xml"); // ʵ����

		personDao = (PersonDao) applicationContext.getBean("personDao");
	}

	// ��Ӳ���
	@Test
	public void testInsertPerson() {
		personDao.insertPerson(new Person(1, "zhangsan", 2));
	}

	// ɾ������
	@Test
	public void testDeletePerson() {
		personDao.deleteById(1);
	}

	// ��ѯȫ��
	@Test
	public void testQueryAllPerson() {
		List<Person> persons = personDao.queryAllPerson();
		// System.out.println(persons.size());
		Iterator<Person> ite = persons.iterator();
		while (ite.hasNext()) {
			Person person = ite.next();
			System.out.print("ID: " + person.getId());
			System.out.print(" --Name: " + person.getName());
			System.out.print(" --Sex: " + person.getSex());
			System.out.println();
		}
	}
	
	@Test
	public void testQueryById(){
		Person person = personDao.queryById(1);
		System.out.println(person.toString());
	}
}
