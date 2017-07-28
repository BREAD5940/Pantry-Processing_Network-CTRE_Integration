package org.team5940.pantry.processing_network.ctre;

import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.Node;
import org.team5940.pantry.processing_network.ValueNode;

import com.ctre.CANTalon;

/**
 * This class accepts input from various source nodes provided on initialization and uses their values (or defaults if null) to control one of more CANTalon objects.
 * @author David Boles
 *
 */
public class TalonSRXNode extends Node {

	/**
	 * Stores the array of talons to control.
	 */
	CANTalon[] talons;
	
	/**
	 * Stores the ValueNode for .set()
	 */
	ValueNode<? extends Double> setValue;
	
	/**
	 * Constructs a new {@link TalonSRXNode}. Calls {@link Node#Node(Network, boolean, ValueNode...)} with (network, true, provided value nodes).
	 * @param network The network that this node will be a member of.
	 * @param A source for the value to .set() the talons. Default is 0 if null.
	 * @param talons One or more talons that this controls.
	 * @throws IllegalArgumentException talons contains null or thrown by super constructor.
	 * @throws IllegalStateException super constructor throws it.
	 */
	public TalonSRXNode(Network network, ValueNode<? extends Double> setValue, CANTalon... talons)
			throws IllegalArgumentException, IllegalStateException {
		super(network, true);//TODO add sources
		
		for(CANTalon talon : talons) {
			if(talon == null) {
				throw new IllegalArgumentException("Null Talon");
			}
		}
		this.talons = talons;
	}

	@Override
	protected void doUpdate() {
		for(CANTalon talon : this.talons) {
			talon.set((this.setValue == null) ? 0 : this.setValue.getValue());
		}
	}

}