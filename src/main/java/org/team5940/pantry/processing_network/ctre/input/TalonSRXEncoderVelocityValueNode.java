package org.team5940.pantry.processing_network.ctre.input;

import org.team5940.pantry.logging.loggers.Logger;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ProcessingNetworkUtils;
import org.team5940.pantry.processing_network.ValueNode;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Returns the value of a velocity encoder from a TalonSRX. 
 * 
 * @author Michael Bentley
 *
 */
public class TalonSRXEncoderVelocityValueNode extends ValueNode<Integer> {

	/**
	 * The talon that we measure the speed of. 
	 */
	TalonSRX encoderTalon;

	/**
	 * Stores the velocity of the encoder for the talon. This uses
	 * {@link TalonSRX#getSelectedSensorVelocity()} to find the velocity. Does not do anything
	 * to change it after that.
	 * 
	 * @param network
	 *            This' Network
	 * @param logger
	 *            This' Logger
	 * @param encoderTalon
	 *            The talon to measure the velocity of.
	 */
	public TalonSRXEncoderVelocityValueNode(Network network, Logger logger, TalonSRX encoderTalon)
			throws IllegalArgumentException, IllegalStateException {
		super(network, logger);
		ProcessingNetworkUtils.checkArgument(encoderTalon);
		this.encoderTalon = encoderTalon;
	}

	@Override
	protected Integer updateValue() {
		// TODO figure out what the 0 is.
		return this.encoderTalon.getSelectedSensorVelocity(0);
	}

}
