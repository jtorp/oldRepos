package com.fdm.view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.fdm.actions.Request;
import com.fdm.model.User;

public class SysAdminViewTest {
	
	SysAdminView sysadminview;
	Scanner Scanner;

	@Before
	public void setUp() {
		sysadminview = new SysAdminView();
		String details = "";
		
		Scanner scanner = new Scanner(new ByteArrayInputStream(
				details.getBytes()));
		
		sysadminview.setScanner(scanner);
		
		
	@Test
	public void testgetInputFromRequest() {
		User user = Request.getInput();
		
	}
		

	

}
