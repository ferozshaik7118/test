package com.github.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.entities.Palindrome;
import com.github.services.PalindromeService;

@RestController
@RequestMapping("palindrome")
public class PalindromeController {

	@Autowired
	private PalindromeService palindromeService;

	@PostMapping
	public ResponseEntity<Palindrome> savePalindrome(String input) {
		return new ResponseEntity<Palindrome>(palindromeService.findLongestPalindromSubstring(input),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Palindrome>> getAll() {
		return new ResponseEntity<List<Palindrome>>(palindromeService.getAll(), HttpStatus.OK);
	}
}
