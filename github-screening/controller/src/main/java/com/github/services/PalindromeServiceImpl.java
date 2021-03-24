package com.github.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dao.PalindromeDao;
import com.github.entities.Palindrome;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PalindromeServiceImpl implements PalindromeService {

	@Autowired
	private PalindromeDao palindromeDao;

	@Override
	public Palindrome findLongestPalindromSubstring(String input) {
		log.info("Input string {}", input);
		Palindrome palindromeSubString = new Palindrome();
		palindromeSubString.setInput(input);
		palindromeSubString.setLongestPalindrome(getLongestPalindrome(input));
		return palindromeDao.savePalindrome(palindromeSubString);
	}

	@Override
	public List<Palindrome> getAll() {
		return palindromeDao.getAll();
	}

	public String getLongestPalindrome(String input) {
		if (input.length() == 1) {
			return input;
		}
		
		// Starting with one character
		String longest = input.substring(0, 1);
		for (int i = 0; i < input.length(); i = i + 1) {

			// fetching longest palindrome for odd length
			String tmp = checkForEquality(input, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// fetching longest palindrome for even length
			tmp = checkForEquality(input, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}

		return longest;
	}

	private String checkForEquality(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

}
