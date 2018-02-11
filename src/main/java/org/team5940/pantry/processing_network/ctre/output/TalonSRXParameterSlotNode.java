package org.team5940.pantry.processing_network.ctre.output;

import org.team5940.pantry.logging.LoggingUtils;
import org.team5940.pantry.logging.loggers.Logger;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ValueNode;
import org.team5940.pantry.processing_network.functional.ChangeDetectorValueNode;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Sets the ProfileSlot of Talons using
 * {@link TalonSRX#selectProfileSlot(int, int)}. This only sets the Profile slot
 * when the value of the ValueNode that determines the slot changes.
 * 
 * @author Michael Bentley
 *
 */
public class TalonSRXParameterSlotNode extends ChangeDetectorValueNode<Integer, Integer> {

	/**
	 * The talons to set the slots of.
	 */
	TalonSRX[] talons;

	/**
	 * The ValueNode that determines the slot.
	 */
	ValueNode<Integer> slotParameterValueNode;

	/**
	 * The current slot set for the talons.
	 */
	int currentSlot = 0;

	/**
	 * Creates a new {@link TalonSRXParameterSlotNode}
	 * 
	 * @param network
	 *            This' Network
	 * @param logger
	 *            This' Logger
	 * @param label
	 *            This' Label
	 * @param requireUpdate
	 *            Whether this should be updated every cycle.
	 * @param slotParameterValueNode
	 *            Determines the current ProfileSlot.
	 * @param talons
	 *            The talons to set the ProfileSlot of.
	 */
	public TalonSRXParameterSlotNode(Network network, Logger logger, String label, boolean requireUpdate,
			ValueNode<Integer> slotParameterValueNode, TalonSRX... talons) {
		super(network, logger, label, requireUpdate, slotParameterValueNode);
		LoggingUtils.checkArrayArguments(talons);

		this.slotParameterValueNode = slotParameterValueNode;
	}

	@Override
	protected void valueChanged(Integer newValue) {
		this.currentSlot = newValue;
		for (TalonSRX talon : this.talons) {
			talon.selectProfileSlot(newValue, 0);
		}
	}

	@Override
	protected Integer updateValue() {
		return this.currentSlot;
	}

}
