package org.team5940.pantry.processing_network.ctre.output;

import org.junit.Test;
import org.team5940.pantry.processing_network.Network;

public class TalonSRXEncoderVelocityValueNodeTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void talonSRXEncoderVelocityValueNode_NullCANTalon_IllegalArgumentException() {
		Network network = new Network(2000);
		new TalonSRXEncoderVelocityValueNode(network, null);
	}

}
