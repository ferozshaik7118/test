package com.github.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.entities.Palindrome;
import com.github.repos.PalindromeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class PalindromeDaoImpl implements PalindromeDao {
	
	@Autowired
	private PalindromeRepository palindromeRepository;
	
	@Override
	public Palindrome savePalindrome(Palindrome palindromeSubString) {
		log.info("Saving palindrome substring for {} ", palindromeSubString.getInput());
		return palindromeRepository.save(palindromeSubString);
	}

	@Override
	public List<Palindrome> getAll() {
		List<Palindrome> substrings = new ArrayList<>();
		palindromeRepository.findAll().forEach(substrings::add);
		log.info("Available substrings {}", substrings.size());
		return substrings;
	}

}
