package com.github.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.services.BinaryReversalServiceImpl;

public class BinaryReversalServiceTest {
	
	private BinaryReversalServiceImpl binaryReversalServiceImpl;
	
	@Before
	public void setup() {
		binaryReversalServiceImpl = new BinaryReversalServiceImpl();
	}
	
	@Test
	public void testBinaryReversal() {
		Assert.assertEquals("244", binaryReversalServiceImpl.getBinaryReversal(47));
	}

}
