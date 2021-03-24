package com.github.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BinaryReversalServiceImpl implements BinaryReversalService {

	@Override
	public String getBinaryReversal(Integer input) {
		log.info("Input number {}", input);
		return reverseBinary(input);
	}
	
	private String reverseBinary(Integer input) {
		String binary = Integer.toBinaryString(input);
		log.info("Input to binary {} ", binary);
		binary = addBitsToBinary(binary);
		log.info("Added bits to input binary {} ", binary);
		String reverseBinary = reverseString(binary);
		log.info("Reversed binary {} ", binary);
		return String.valueOf(Integer.parseInt(reverseBinary, 2));
	}


	private String addBitsToBinary(String binary) {
		int bitsToAdd = getBitsToAdd(binary.length());
		for (int i = 0; i < bitsToAdd; i++)
			binary = "0" + binary;
		return binary;
	}
	
	private int getBitsToAdd(int length) {
		return 8 - (length % 8);
	}
	
	private String reverseString(String str){  
	    StringBuilder sb=new StringBuilder(str);  
	    sb.reverse();  
	    return sb.toString();  
	}  
	
	
}
