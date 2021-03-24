package com.github.repos;

import org.springframework.data.repository.CrudRepository;

import com.github.entities.Palindrome;

public interface PalindromeRepository extends CrudRepository<Palindrome, Long> {

}
