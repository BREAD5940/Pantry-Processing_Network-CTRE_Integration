package org.team5940.pantry.processing_network.ctre.input;

import org.team5940.pantry.logging.loggers.Logger;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ProcessingNetworkUtils;
import org.team5940.pantry.processing_network.ValueNode;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TalonSRXEncoderVelocityValueNode extends ValueNode<Integer> {

	TalonSRX encoderTalon;

	// TODO comment
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
	public TalonSRXEncoderVelocityValueNode(Network network, Logger logger, TalonSRX encoderTalon)
			throws IllegalArgumentException, IllegalStateException {
		super(network, logger);
		ProcessingNetworkUtils.checkArgument(encoderTalon);
		this.encoderTalon = encoderTalon;
	}

	@Override
	protected Integer updateValue() {
		// TODO figure out if this works. 
		return this.encoderTalon.getSelectedSensorVelocity(0);
	}

}
