package com.java.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account {
	@Id
	int accountNumber;
	float balance;
}
