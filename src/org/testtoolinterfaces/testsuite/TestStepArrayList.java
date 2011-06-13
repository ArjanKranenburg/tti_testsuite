package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;
import org.testtoolinterfaces.utils.Warning;


public class TestStepArrayList extends ArrayList<TestStep>
{
	private static final long	serialVersionUID	= 1L;

	public TestStepArrayList()
	{
		super();
	}
	
	public TestStepArrayList( int aSize )
	{
		super( aSize );
	}
	
	/**
	 * Sorts the Entries in the ArrayList.
	 * @return a new sorted TestEntryArrayList
	 * 
	 *  Note: the old ArrayList remains unchanged
	 */
	public TestStepArrayList sort()
	{
		Trace.println(Trace.UTIL);
		Trace.println(Trace.ALL, "Array size is " + this.size());

		TestStepArrayList newSteps = new TestStepArrayList(this.size());
		for (int old_i = 0; old_i < this.size(); old_i++)
	    {
			int new_i = 0;
			while (new_i < newSteps.size() &&
					this.get(old_i).getSequenceNr() >= newSteps.get(new_i).getSequenceNr())
			{
				new_i++;
			}
    		Trace.println(Trace.ALL, "inserting " + this.get(old_i).getStepType() + " at location " + new_i);
			newSteps.add(new_i, this.get(old_i));

			if (new_i>0 && 
					newSteps.get(new_i).getSequenceNr() == newSteps.get(new_i-1).getSequenceNr())
			{
				Warning.println("Steps found with same sequence numbers: " +
						newSteps.get(new_i-1).getStepType() + " and " +
						newSteps.get(new_i).getStepType() + "\n" +
						"         Order of execution is undetermined...");
			}
	    }
	    
		Trace.println(Trace.ALL, "New Array size is " + newSteps.size());
		return newSteps;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString()
	{
		return this.size() + " TestStep";
	}
}
