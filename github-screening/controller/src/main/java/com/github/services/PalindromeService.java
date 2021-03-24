package com.github.services;

import java.util.List;

import com.github.entities.Palindrome;

public interface PalindromeService {
	
	Palindrome findLongestPalindromSubstring(String input);
	
	List<Palindrome> getAll();
	
}
