package com.sopovs.moradanen.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SalaryDay {

	@Id
	@GeneratedValue
	private Long id;

}
