package org.team5940.pantry.processing_network.ctre.input;

import org.team5940.pantry.logging.loggers.Logger;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ProcessingNetworkUtils;
import org.team5940.pantry.processing_network.ValueNode;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TalonSRXEncoderPositionValueNode extends ValueNode<Integer> {

	TalonSRX encoderTalon;

	/**
	 * Stores the position of the encoder in whatever unit the encoder uses.
	 * Value is used from {@link CANTalon#getEncPosition()}. This does not do
	 * any conversion for you. This should have some unit conversion done on top
	 * of it.
	 * 
	 * @param network
	 *            Nodes network
	 * @param encoderTalon
	 *            The talon that stores the encoder.
	 * @throws IllegalArgumentException
	 *             If the talon is null.
	 * @throws IllegalStateException
	 *             If the network has started already.
	 */
	public TalonSRXEncoderPositionValueNode(Network network, Logger logger, TalonSRX encoderTalon)
			throws IllegalArgumentException, IllegalStateException {
		super(network, logger);
		ProcessingNetworkUtils.checkArgument(encoderTalon);
		this.encoderTalon = encoderTalon;
	}

	@Override
	protected Integer updateValue() {
		// TODO figure out what the 0 is. 
		return this.encoderTalon.getSelectedSensorPosition(0);
	}

}
