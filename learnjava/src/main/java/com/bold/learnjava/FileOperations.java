package com.bold.learnjava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.Files;

public class FileOperations {

	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String sampleText = "Hi, My name is vishal";
	//Files.writeFile(  sampleText, Paths.get("src\\test\\resources\\Writefile.txt"));

	  Files.writeFile("Hi, My name is vishal", new File("src\\test\\resources\\Writefile.txt"));
	String dataFromFile = Files.readFile(new File ("src\\test\\resources\\Writefile.txt"));
	
	System.out.println(dataFromFile);
	}*/
	
	
	
	@Test
	public void method1() throws InterruptedException {
		Thread.sleep(1000);
		//SoftAssert sa = new SoftAssert();
		//sa.assertEquals(true, false);
		Assert.fail();
		System.err.println("Using throws");
		//sa.assertAll();
	}
	
	
	@Test
	public void method2() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		Assert.fail();
		System.err.println("Using try catch");
	}

}
