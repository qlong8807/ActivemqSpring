package com.cyber.mybatis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cyber.dao.entity.Person;

public class MybatisTest {
	ApplicationContext ctx = null;
	@Before
	public void Init(){
		ctx = new ClassPathXmlApplicationContext("mybatis-applicationContext.xml");
	}
	@Test
	public void test(){
        MyBatisPersonDao personDao=(MyBatisPersonDao) ctx.getBean("personDao");
        Person person=new Person();
        //�����������
        person.setId(2);
        person.setName("Jessica");
        person.setSex(1);
        personDao.addPerson(person);
        person.setId(3);
        person.setName("Jessica2");
        person.setSex(2);
        personDao.addPerson(person);
        System.out.println("��ӳɹ�");
        //��ѯ����
        person.setName("Jessica");
        person.setSex(1);
        System.out.println(personDao.getPerson(person).toString());
        person.setName("Jessica2");
        person.setSex(2);
        System.out.println(personDao.getPerson(person).toString());
        //�޸�����
        person.setId(2);
        person.setSex(5);
        personDao.updatePerson(person);
        System.out.println("�޸ĳɹ�");
        //ɾ������
        personDao.deletePerson(1);
        System.out.println("ɾ���ɹ�");
	}
}
