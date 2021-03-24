package com.github.dao;

import java.util.List;

import com.github.entities.Palindrome;

public interface PalindromeDao {
	
	Palindrome savePalindrome(Palindrome palindromeSubString);
	
	List<Palindrome> getAll();

}
