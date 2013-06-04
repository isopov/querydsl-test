package com.sopovs.moradanen;

import static com.sopovs.moradanen.domain.QSalary.salary;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.jpa.impl.JPAQuery;
import com.sopovs.moradanen.domain.Employee;
import com.sopovs.moradanen.domain.Salary;
import com.sopovs.moradanen.domain.SalaryDay;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springContext.xml")
@Transactional
public class QueryDslTest {

	@PersistenceContext
	private EntityManager em;

	@Before
	public void setup() {
		Employee smith = new Employee("Smith");
		Employee anderson = new Employee("Anderson");
		
		em.persist(smith);
		em.persist(anderson);
		
		SalaryDay first = new SalaryDay();
		SalaryDay second = new SalaryDay();
		SalaryDay third = new SalaryDay();
		
		em.persist(first);
		em.persist(second);
		em.persist(third);
		
		em.persist(new Salary(smith,first,5L));
		em.persist(new Salary(smith,second,10L));
		em.persist(new Salary(smith,third,15L));
		
		
		em.persist(new Salary(anderson,first,15L));
		em.persist(new Salary(anderson,second,10L));
		em.persist(new Salary(anderson,third,5L));
	}

	@Test
	public void testSize() {
		assertEquals(6l, new JPAQuery(em).from(salary).count());
	}

}
