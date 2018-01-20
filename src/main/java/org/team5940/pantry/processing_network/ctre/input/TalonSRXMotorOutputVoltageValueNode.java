package org.team5940.pantry.processing_network.ctre.input;

import org.team5940.pantry.logging.loggers.Logger;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ValueNode;
import org.team5940.pantry.processing_network.ProcessingNetworkUtils;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * This returns the voltage going to a motor based on what the TalonSRX says.
 * 
 * @author mbent
 *
 */
public class TalonSRXMotorOutputVoltageValueNode extends ValueNode<Double> {

	/**
	 * The Talon to measure the voltage of.
	 */
	TalonSRX talon;

	/**
	 * Returns the volts going to a TalonSRX using
	 * {@link TalonSRX#getMotorOutputVoltage()}. The value could be up to around 12
	 * Volts depending on the speed of the talon and charge of the battery.
	 * 
	 * @param network
	 *            This' Network.
	 * @param logger
	 *            This' Logger.
	 * @param talon
	 *            The talon to measure the voltage of.
	 */
	public TalonSRXMotorOutputVoltageValueNode(Network network, Logger logger, TalonSRX talon)
			throws IllegalArgumentException, IllegalStateException {
		super(network, logger);
		ProcessingNetworkUtils.checkArgument(talon);
		this.talon = talon;
	}

	@Override
	protected Double updateValue() {
		return this.talon.getMotorOutputVoltage();
	}

}
