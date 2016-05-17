package com.cyber.ibatis;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cyber.dao.PersonDao;
import com.cyber.dao.entity.Person;

public class IbatisTest {
	private static ApplicationContext applicationContext = null; // 提供静态ApplicationContext
	private static PersonDao personDao;
	static {
		applicationContext = new ClassPathXmlApplicationContext(
				"ibatis-applicationContext.xml"); // 实例化

		personDao = (PersonDao) applicationContext.getBean("personDao");
	}

	// 添加操作
	@Test
	public void testInsertPerson() {
		personDao.insertPerson(new Person(1, "zhangsan", 2));
	}

	// 删除操作
	@Test
	public void testDeletePerson() {
		personDao.deleteById(1);
	}

	// 查询全部
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
