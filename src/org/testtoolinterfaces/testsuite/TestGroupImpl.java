package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for Default (i.e. TTI) Test Groups.
 * TestGroupImpls all have an Id, a sequenceNr and may have a description and a list of Requirements.
 * And they all have collections of prepare steps, execution entries, and restore steps.
 * (These collections may be empty as well.)
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupImpl extends TestEntryImpl implements TestGroup
{
    private ArrayList<String> myRequirementIds;

	private TestStepCollection myInitializationSteps;
	private TestEntryArrayList myExecutionEntries;
    private TestStepCollection myRestoreSteps;
    
	/**
	 * Constructor
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestGroupImpl( String aTestGroupId,
	                      String aDescription,
	                      int aSequenceNr,
	                      ArrayList<String> aRequirementIds,
	                      TestStepCollection aPrepareSteps,
	                      TestEntryArrayList aTestEntries,
	                      TestStepCollection aRestoreSteps,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		super( aTestGroupId,
		       TestEntry.TYPE.Group,
		       aDescription,
		       aSequenceNr,
		       anAnyAttributes,
		       anAnyElements );
		Trace.println( Trace.CONSTRUCTOR,
					   "TestGroupImpl( " + aTestGroupId + ", "
					   					 + aDescription + ", "
					   					 + aSequenceNr + ", "
					   					 + aRequirementIds.hashCode() + ", "
					   					 + aPrepareSteps + ", "
					   					 + aTestEntries + ", "
					   					 + aRestoreSteps + " )",
						true );

		myRequirementIds = aRequirementIds;

		myInitializationSteps = aPrepareSteps;
		myExecutionEntries = aTestEntries;
		myRestoreSteps = aRestoreSteps;
	}

	/**
	 * Constructor without unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestGroupImpl( String aTestGroupId,
	                      String aDescription,
	                      int aSequenceNr,
	                      ArrayList<String> aRequirementIds,
	                      TestStepCollection aPrepareSteps,
	                      TestEntryArrayList aTestEntries,
	                      TestStepCollection aRestoreSteps )
	{
		this( aTestGroupId,
		      aDescription,
		      aSequenceNr,
		      aRequirementIds,
		      aPrepareSteps,
		      aTestEntries,
		      aRestoreSteps,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor without description and unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestGroupImpl( String aTestGroupId,
	                      int aSequenceNr,
	                      ArrayList<String> aRequirementIds,
	                      TestStepCollection aPrepareSteps,
	                      TestEntryArrayList aTestEntries,
	                      TestStepCollection aRestoreSteps )
	{
		this( aTestGroupId,
		      "",
		      aSequenceNr,
		      aRequirementIds,
		      aPrepareSteps,
		      aTestEntries,
		      aRestoreSteps,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor without requirements and unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestGroupImpl( String aTestGroupId,
	                      String aDescription,
	                      int aSequenceNr,
	                      TestStepCollection aPrepareSteps,
	                      TestEntryArrayList aTestEntries,
	                      TestStepCollection aRestoreSteps )
	{
		this( aTestGroupId,
		      aDescription,
		      aSequenceNr,
		      new ArrayList<String>(),
		      aPrepareSteps,
		      aTestEntries,
		      aRestoreSteps,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor without description, requirements, and unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestGroupImpl( String aTestGroupId,
	                      int aSequenceNr,
	                      TestStepCollection aPrepareSteps,
	                      TestEntryArrayList aTestEntries,
	                      TestStepCollection aRestoreSteps )
	{
		this( aTestGroupId,
		      "",
		      aSequenceNr,
		      new ArrayList<String>(),
		      aPrepareSteps,
		      aTestEntries,
		      aRestoreSteps,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	@Override
	public TestStepCollection getPrepareSteps()
	{
		return myInitializationSteps;
	}

	@Override
	public TestEntryArrayList getExecutionEntries()
	{
		return myExecutionEntries;
	}

	@Override
	public TestStepCollection getRestoreSteps()
	{
		return myRestoreSteps;
	}

	@Override
	public ArrayList<String> getRequirements()
	{
		return myRequirementIds;
	}

	@Override
	public boolean hasGroupId(String aGroupId)
	{
		if (this.getId().equals(aGroupId))
		{
			return true;
		}

		for (int key = 0; key < myExecutionEntries.size(); key++)
    	{
			TestEntry entry = myExecutionEntries.get(key);
			if ( entry.getType() == TestEntry.TYPE.Group )
			{
				if ( ((TestGroup) entry).hasGroupId(aGroupId) )
				{
					return true;
				}
			}
			else if ( entry.getType() == TestEntry.TYPE.GroupLink )
			{
				if ( entry.getId().equals( aGroupId ) )
				{
					return true;
				}
			}
    	}

		return false;
	}
}
