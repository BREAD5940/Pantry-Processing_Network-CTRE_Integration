package org.team5940.pantry.processing_network.ctre.output;

import org.team5940.pantry.logging.loggers.Logger;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.Node;
import org.team5940.pantry.processing_network.ProcessingNetworkUtils;
import org.team5940.pantry.processing_network.ValueNode;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * This class accepts input from various source nodes provided on initialization
 * and uses their values (or defaults if null) to control one of more CANTalon
 * objects.
 * 
 * @author David Boles
 *
 */
public class TalonSRXNode extends Node {

	/**
	 * Stores the array of talons to control.
	 */
	TalonSRX[] talons;

	/**
	 * Stores the ValueNode for .set()
	 */
	ValueNode<? extends Number> setValue;

	/**
	 * Sets the ControlMode for the Talon when setting the speed.
	 */
	ValueNode<? extends ControlMode> controlModeValueNode;

	/**
	 * Constructs a new {@link TalonSRXNode}. Calls
	 * {@link Node#Node(Network, boolean, ValueNode...)} with (network, true,
	 * provided value nodes).
	 * 
	 * @param network
	 *            The network that this node will be a member of.
	 * @param setValue
	 *            source for the value to .set() the talons. Default is 0 if null.
	 * @param controlModeValueNode
	 *            Sets the ControlMode for the TalonSRX. May want to use a
	 *            ConstantValueNode for this.
	 * @param talons
	 *            One or more talons that this controls.
	 * @throws IllegalArgumentException
	 *             talons contains null or thrown by super constructor.
	 * @throws IllegalStateException
	 *             super constructor throws it.
	 */
	public TalonSRXNode(Network network, Logger logger, boolean requireUpdate,
			ValueNode<? extends ControlMode> controlModeValueNode, ValueNode<? extends Number> setValue,
			TalonSRX... talons) throws IllegalArgumentException, IllegalStateException {
		super(network, logger, requireUpdate, setValue, controlModeValueNode);

		ProcessingNetworkUtils.checkArrayArguments(talons);

		this.talons = talons;
		this.setValue = setValue;
		this.controlModeValueNode = controlModeValueNode;
	}

	@Override
	protected void doUpdate() {
		for (TalonSRX talon : this.talons) {
			talon.set(this.controlModeValueNode.getValue(), this.setValue.getValue().doubleValue());
		}
	}

}
