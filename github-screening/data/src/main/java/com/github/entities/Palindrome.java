package com.github.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name = "PALINDROME")
@Data
public class Palindrome implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "INPUT")
	private String input;
	
	@Column(name = "LONGEST_PALINDROME")
	private String longestPalindrome;

}
