package com.github.services;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.dao.PalindromeDao;
import com.github.entities.Palindrome;

public class PalindromeServiceTest {
	
	@InjectMocks
	private PalindromeServiceImpl palindromeServiceImpl;
	
	@Mock
	private PalindromeDao palindromeDao;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testLongestPalindromeLogic() {
		Assert.assertEquals("anana", palindromeServiceImpl.getLongestPalindrome("banana"));
		Assert.assertEquals("aabbaa", palindromeServiceImpl.getLongestPalindrome("aaaabbaa"));
	}
	
	@Test
	public void testLongestPalindromeDbCall() {
		Palindrome palindromeSubstring = new Palindrome();
		when(palindromeDao.savePalindrome(Mockito.any(Palindrome.class))).thenReturn(palindromeSubstring);
		Assert.assertEquals(palindromeSubstring, palindromeServiceImpl.findLongestPalindromSubstring("bananas"));
		verify(palindromeDao).savePalindrome(Mockito.any(Palindrome.class));
	}
	
	@Test
	public void testGetAllPalindromeDbCall() {
		List<Palindrome> palindromeList = Stream.of(new Palindrome()).collect(Collectors.toList());
		when(palindromeDao.getAll()).thenReturn(palindromeList);
		Assert.assertEquals(palindromeList, palindromeServiceImpl.getAll());
	}
}
