package org.team5940.pantry.processing_network.ctre.output;

import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ProcessingNetworkUtils;
import org.team5940.pantry.processing_network.ValueNode;

import com.ctre.CANTalon;

public class TalonSRXEncoderPositionValueNode extends ValueNode<Integer> {

	CANTalon encoderTalon;

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
	public TalonSRXEncoderPositionValueNode(Network network, CANTalon encoderTalon)
			throws IllegalArgumentException, IllegalStateException {
		super(network);
		ProcessingNetworkUtils.checkArgument(encoderTalon);
		this.encoderTalon = encoderTalon;
	}

	@Override
	protected Integer updateValue() {
		return this.encoderTalon.getEncPosition();
	}

}
