package org.team5940.pantry.processing_network.ctre.output;

import org.junit.Test;
import org.team5940.pantry.processing_network.Network;

public class TalonSRXEncoderPositionValueNodeTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void talonSRXEncoderPositionValueNode_NullCANTalon_IllegalArgumentException() {
		Network network = new Network(2000);
		new TalonSRXEncoderPositionValueNode(network, null);
	}
	
}
