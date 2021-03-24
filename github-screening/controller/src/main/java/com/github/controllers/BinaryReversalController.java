package com.github.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.services.BinaryReversalService;

@RestController
@RequestMapping("binary")
public class BinaryReversalController {

	@Autowired
	private BinaryReversalService binaryReversalService;

	@GetMapping
	public ResponseEntity<String> binaryReversal(String input) {
		try {
			Integer inputNum = Integer.parseInt(input);
			if (inputNum < 0)
				return badRequestError();
			else
				return new ResponseEntity<String>(binaryReversalService.getBinaryReversal(inputNum), HttpStatus.OK);
		} catch (NumberFormatException e) {
			return badRequestError();
		}
	}

	private ResponseEntity<String> badRequestError() {
		return new ResponseEntity<String>("Input must be a postive number", HttpStatus.BAD_REQUEST);
	}
}
