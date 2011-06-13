package org.testtoolinterfaces.testsuite;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestStep;
import org.testtoolinterfaces.testsuite.TestStepArrayList;
import org.testtoolinterfaces.testsuite.TestStepSimple;


public class TestStepArrayListTester extends TestCase
{
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor()
	{
		TestStepArrayList tsArray = new TestStepArrayList();

		Assert.assertEquals("Incorrect Size", 0, tsArray.size());
	}

	/**
	 * Test Cases
	 */
	public void testCase_sort()
	{
		TestInterface_stub iface1 = new TestInterface_stub( "interface1" );
		TestStepSimple ts1 = new TestStepCommand(TestStep.StepType.check, 3, "description", "command", iface1, new ParameterArrayList());
		TestInterface_stub iface2 = new TestInterface_stub( "interface2" );
		TestStepSimple ts2 = new TestStepCommand(TestStep.StepType.check, 2, "description2", "command2", iface2, new ParameterArrayList());
		TestStepArrayList tsArray = new TestStepArrayList();
		tsArray.add(ts1);
		tsArray.add(ts2);

		TestStepArrayList newArray = tsArray.sort();

		// Old array remains unchanged
		Assert.assertEquals("Incorrect Size", 2, tsArray.size());
		Assert.assertEquals("Incorrect SeqNr 1st step", 3, tsArray.get(0).getSequenceNr());
		Assert.assertEquals("Incorrect SeqNr 2nd step", 2, tsArray.get(1).getSequenceNr());

		Assert.assertEquals("Incorrect Size", 2, newArray.size());
		Assert.assertEquals("Incorrect SeqNr 1st step", 2, newArray.get(0).getSequenceNr());
		Assert.assertEquals("Incorrect SeqNr 2nd step", 3, newArray.get(1).getSequenceNr());
	}
}
