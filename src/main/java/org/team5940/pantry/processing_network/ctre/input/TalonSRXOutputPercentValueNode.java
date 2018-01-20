package org.team5940.pantry.processing_network.ctre.input;

import org.team5940.pantry.logging.loggers.Logger;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ValueNode;
import org.team5940.pantry.processing_network.ProcessingNetworkUtils;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Returns the percent speed a talon is set to. Uses
 * {@link TalonSRX#getMotorOutputPercent()} to measure the speed. Can be from -1
 * to 1.
 * 
 * @author Michael Bentley
 *
 */
public class TalonSRXOutputPercentValueNode extends ValueNode<Double> {

	TalonSRX talon;

	/**
	 * This returns the set speed of the TalonSRX. Could be from -1 to 1. It is the
	 * percent that the motor is set to.
	 * 
	 * @param network
	 *            This' Network
	 * @param logger
	 *            This' Logger
	 * @param talon
	 *            The TalonSRX to measure the output of.
	 */
	public TalonSRXOutputPercentValueNode(Network network, Logger logger, TalonSRX talon)
			throws IllegalArgumentException, IllegalStateException {
		super(network, logger);
		ProcessingNetworkUtils.checkArgument(talon);

	}

	@Override
	protected Double updateValue() {
		return this.talon.getMotorOutputPercent();
	}

}
