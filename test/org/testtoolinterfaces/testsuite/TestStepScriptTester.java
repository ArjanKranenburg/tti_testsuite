package org.testtoolinterfaces.testsuite;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestEntry;

public class TestStepScriptTester extends TestCase
{
	ParameterArrayList myParamTable = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");

		if ( myParamTable == null )
		{
			myParamTable = new ParameterArrayList();
			
			ParameterImpl param_e = new ParameterImpl("-e", "e-parameter");
			param_e.setIndex(0);
			myParamTable.add(param_e);
		}
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepScript#TestStepScript()}.
	 */
	@Test
	public void testConstructor1()
	{
		TestStepScript testStep = new TestStepScript(
				0,
				"An extensive description",
				"script",
				"bash",
				myParamTable );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertEquals("Incorrect Description", "An extensive description", testStep.getDescription());
		Assert.assertEquals("Incorrect Parameters", "e-parameter", ((ParameterImpl) testStep.getParameters().get("-e")).getValue());

		Assert.assertEquals("Incorrect Script", "script", testStep.getScript());
		Assert.assertEquals("Incorrect Script Type", "bash", testStep.getScriptType());
		Assert.assertEquals("Incorrect Display Name", "script", testStep.getDisplayName());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepScript#TestStepScript()}.
	 */
	@Test
	public void testConstructor2()
	{
		TestStepScript testStep = new TestStepScript(
				0,
				"An extensive description",
				"script",
				"bash" );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertEquals("Incorrect Description", "An extensive description", testStep.getDescription());
		Assert.assertTrue(  "Incorrect Parameters", testStep.getParameters().isEmpty());

		Assert.assertEquals("Incorrect Script", "script", testStep.getScript());
		Assert.assertEquals("Incorrect Script Type", "bash", testStep.getScriptType());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepScript#TestStepScript()}.
	 */
	@Test
	public void testConstructor3()
	{
		TestStepScript testStep = new TestStepScript(
				0,
				"script",
				"bash",
				myParamTable );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertEquals("Incorrect Description", "", testStep.getDescription());
		Assert.assertEquals("Incorrect Parameters", "e-parameter", ((ParameterImpl) testStep.getParameters().get("-e")).getValue());

		Assert.assertEquals("Incorrect Script", "script", testStep.getScript());
		Assert.assertEquals("Incorrect Script Type", "bash", testStep.getScriptType());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepScript#TestStepScript()}.
	 */
	@Test
	public void testConstructor4()
	{
		TestStepScript testStep = new TestStepScript(
				0,
				"script",
				"bash" );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertEquals("Incorrect Description", "", testStep.getDescription());
		Assert.assertTrue(  "Incorrect Parameters", testStep.getParameters().isEmpty());

		Assert.assertEquals("Incorrect Script", "script", testStep.getScript());
		Assert.assertEquals("Incorrect Script Type", "bash", testStep.getScriptType());
	}
}