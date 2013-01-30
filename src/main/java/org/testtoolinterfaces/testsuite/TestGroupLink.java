package org.testtoolinterfaces.testsuite;

import java.io.File;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;


/**
 * Class for a link to a Test Group.
 * TestGroupLinks all have an Id, a Type, a sequenceNr, and a link to a File.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupLink extends TestEntryImpl
{
	public static final String TYPE_TTI = "tti";

	private TestLink myLink;
	
	@Deprecated // Use constructor without anyAttributes and anyElements
	/**
	 * Constructor
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTgLink			Link to Test Group File
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      TestLink aTgLink,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		super(aTestGroupId, TestEntry.TYPE.GroupLink, "", aSequenceNr );

		Trace.println( Trace.CONSTRUCTOR,
					   "TestGroupLinkImpl( " + aTestGroupId + ", " 
					   						 + aSequenceNr + ", "
					   						 + aTgLink.getPath() + ", "
					   						 + anAnyAttributes.size() + ", "
					   						 + anAnyElements.size() + " )",
					   true );
		
		myLink = aTgLink;
		this.setAnyAttributes(anAnyAttributes);
		this.setAnyElements(anAnyElements);
	}

	@Deprecated // Use constructor without anyAttributes and anyElements
	/**
	 * Constructor
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTgLinkName		Test Group File Name
	 * @param aType				Type of the TG File
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      String aTgLinkName,
	                      String aType,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		this( aTestGroupId,
		      aSequenceNr,
		      new TestLinkImpl( aTgLinkName, aType ),
		      anAnyAttributes,
		      anAnyElements );
	}

	/**
	 * Constructor without unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTgLinkName		Test Group File Name
	 * @param aType				Type of the TG File
	 */
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      String aTgLinkName,
	                      String aType )
	{
		this( aTestGroupId,
		      aSequenceNr,
		      new TestLinkImpl( aTgLinkName, aType ),
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor for default type and without unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTgLinkName		Test Group File Name
	 */
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      String aTgLinkName )
	{
		this( aTestGroupId,
		      aSequenceNr,
		      new TestLinkImpl( aTgLinkName, TYPE_TTI ),
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestGroupLink	Test Group File
	 * @param aType				Type of the TG File
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	@Deprecated
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      File aTestGroupLink,
	                      String aType,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		this( aTestGroupId,
		      aSequenceNr,
		      new TestLinkImpl( aTestGroupLink.getPath(), aType ),
		      anAnyAttributes,
		      anAnyElements );
	}

	/**
	 * Constructor without unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestGroupLink	Test Group File
	 * @param aType				Type of the TG File
	 */
	@Deprecated
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      File aTestGroupLink,
	                      String aType )
	{
		this( aTestGroupId,
		      aSequenceNr,
		      new TestLinkImpl( aTestGroupLink.getPath(), aType ),
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor for type 'tti' without unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestGroupLink	Test Group File
	 */
	@Deprecated
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      File aTestGroupLink )
	{
		this( aTestGroupId,
		      aSequenceNr,
		      new TestLinkImpl( aTestGroupLink.getPath(), TYPE_TTI ),
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * @return the Test Group File
	 */
	public File getLink()
	{
		return myLink.getFile();
	}

	/**
	 * @param aLink	The TC Link.
	 */
	public void setLink(TestLink aLink)
	{
		myLink = aLink;
	}

	/**
	 * @return the type of the Test Group File
	 */
	public String getLinkType()
	{
		return myLink.getType();
	}

	/**
	 * Sets the directory of the TG Link.
	 * 
	 * Only if the TG Link is not already absolute.
	 * This will change the stored TG link.
	 * 
	 * @param aLinkDir	The directory to set to the TC Link.
	 */
	public void setLinkDir( File aLinkDir )
	{
		if ( ! myLink.getFile().isAbsolute() )
		{
			myLink = new TestLinkImpl( aLinkDir, myLink.getPath(), myLink.getType() );
		}
	}
}
