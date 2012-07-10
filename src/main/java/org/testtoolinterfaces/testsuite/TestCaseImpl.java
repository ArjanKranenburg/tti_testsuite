/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for Default (i.e. TTI) Test Cases.
 * TestCaseImpls all have an Id, a sequenceNr and may have a description and a list of Requirements.
 * And they all have collections of prepare, execution, and restore steps.
 * (These collections may be empty as well.)
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestCaseImpl extends TestEntryImpl implements TestCase
{
    private ArrayList<String> myRequirementIds;

    private TestStepSequence myPrepareSteps;
    private TestStepSequence myExecutionSteps;
    private TestStepSequence myRestoreSteps;

	/**
	 * Constructor
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param anExecutionSteps	Collection of execution steps
	 * @param aRestoreSteps		Collection of Restore steps
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestCaseImpl(
			String aTestCaseId,
			String aDescription,
			int aSequenceNr,
			ArrayList<String> aRequirementIds,
			TestStepSequence aPrepareSteps,
			TestStepSequence anExecutionSteps,
			TestStepSequence aRestoreSteps,
            Hashtable<String, String> anAnyAttributes,
			Hashtable<String, String> anAnyElements )
	{
		super( aTestCaseId,
		       TestEntry.TYPE.Case,
		       aDescription,
		       aSequenceNr,
		       anAnyAttributes,
		       anAnyElements );
		Trace.println( Trace.CONSTRUCTOR,
					   "TestCaseImpl( " + aTestCaseId + ", "
										+ aDescription + ", "
										+ aSequenceNr + ", "
										+ aRequirementIds.hashCode() + ", "
										+ aPrepareSteps + ", "
										+ anExecutionSteps + ", "
										+ aRestoreSteps + " )",
						true );

		myRequirementIds = aRequirementIds;

		myPrepareSteps = aPrepareSteps;
		myExecutionSteps = anExecutionSteps;
		myRestoreSteps = aRestoreSteps;
	}

	/**
	 * Constructor without unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param anExecutionSteps	Collection of execution steps
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestCaseImpl(
			String aTestCaseId,
			String aDescription,
			int aSequenceNr,
			ArrayList<String> aRequirementIds,
			TestStepSequence aPrepareSteps,
			TestStepSequence anExecutionSteps,
			TestStepSequence aRestoreSteps )
	{
		this( aTestCaseId,
		      aDescription,
		      aSequenceNr,
		      aRequirementIds,
		      aPrepareSteps,
		      anExecutionSteps,
		      aRestoreSteps,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor without description and unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param anExecutionSteps	Collection of execution steps
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestCaseImpl(
			String aTestCaseId,
			int aSequenceNr,
			ArrayList<String> aRequirementIds,
			TestStepSequence aPrepareSteps,
			TestStepSequence anExecutionSteps,
			TestStepSequence aRestoreSteps )
	{
		this( aTestCaseId,
		      "",
		      aSequenceNr,
		      aRequirementIds,
		      aPrepareSteps,
		      anExecutionSteps,
		      aRestoreSteps,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor without requirements and unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param anExecutionSteps	Collection of execution steps
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestCaseImpl(
			String aTestCaseId,
			String aDescription,
			int aSequenceNr,
			TestStepSequence aPrepareSteps,
			TestStepSequence anExecutionSteps,
			TestStepSequence aRestoreSteps )
	{
		this( aTestCaseId,
		      aDescription,
		      aSequenceNr,
		      new ArrayList<String>(),
		      aPrepareSteps,
		      anExecutionSteps,
		      aRestoreSteps,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor without description, requirements, and unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param anExecutionSteps	Collection of execution steps
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestCaseImpl(
			String aTestCaseId,
			int aSequenceNr,
			TestStepSequence aPrepareSteps,
			TestStepSequence anExecutionSteps,
			TestStepSequence aRestoreSteps )
	{
		this( aTestCaseId,
		      "",
		      aSequenceNr,
		      new ArrayList<String>(),
		      aPrepareSteps,
		      anExecutionSteps,
		      aRestoreSteps,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	public TestStepSequence getPrepareSteps()
	{
		return myPrepareSteps;
	}

	public TestStepSequence getExecutionSteps()
	{
		return myExecutionSteps;
	}

	public ArrayList<String> getRequirements()
	{
		return myRequirementIds;
	}

	public TestStepSequence getRestoreSteps()
	{
		return myRestoreSteps;
	}
}