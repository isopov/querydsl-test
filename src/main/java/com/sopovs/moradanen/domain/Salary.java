package com.sopovs.moradanen.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Salary {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Employee employee;
	@ManyToOne
	private SalaryDay salaryDay;

	private Long value;

	public Salary(Employee employee, SalaryDay salaryDay, Long value) {
		this.employee = employee;
		this.salaryDay = salaryDay;
		this.value = value;
	}

	public Salary() {
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public SalaryDay getSalaryDay() {
		return salaryDay;
	}

	public void setSalaryDay(SalaryDay salaryDay) {
		this.salaryDay = salaryDay;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
