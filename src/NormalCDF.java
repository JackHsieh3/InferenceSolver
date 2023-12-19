import org.apache.commons.math3.distribution.NormalDistribution;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

public class NormalCDF implements Userfunction {

	static NormalDistribution normalDistribution = new NormalDistribution();
	
	/*
	 * Accepts the upper bound
	 * Set with mean = 0, stdev = 1
	 * Returns normalCdf(lower=-inf, upper=upper)
	 */
	@Override
	public Value call(ValueVector valueVector, Context context) throws JessException {
		double upperBound = valueVector.get(1).floatValue(context);
		
		return new Value(normalDistribution.cumulativeProbability(upperBound), RU.FLOAT);
	}

	@Override
	public String getName() {
		return "normalCDF";
	}

}
