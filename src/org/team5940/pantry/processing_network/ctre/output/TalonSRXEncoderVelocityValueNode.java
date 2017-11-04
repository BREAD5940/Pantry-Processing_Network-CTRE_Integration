package org.team5940.pantry.processing_network.ctre.output;

import org.team5940.pantry.logging.loggers.Logger;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ProcessingNetworkUtils;
import org.team5940.pantry.processing_network.ValueNode;

import com.ctre.CANTalon;

public class TalonSRXEncoderVelocityValueNode extends ValueNode<Integer> {

	CANTalon encoderTalon;

	/**
	 * Stores the velocity of the encoder for the talon. This uses
	 * {@link CANTalon#getEncVelocity()} to find the velocity. Does not do
	 * anything to change it after that.
	 * 
	 * @param network
	 * @param encoderTalon
	 * @throws IllegalArgumentException
	 * @throws IllegalStateException
	 */
	public TalonSRXEncoderVelocityValueNode(Network network, Logger logger, CANTalon encoderTalon)
			throws IllegalArgumentException, IllegalStateException {
		super(network, logger);
		// TODO Auto-generated constructor stub
		ProcessingNetworkUtils.checkArgument(encoderTalon);
		this.encoderTalon = encoderTalon;
	}

	@Override
	protected Integer updateValue() {
		return this.encoderTalon.getEncVelocity();
	}

}
