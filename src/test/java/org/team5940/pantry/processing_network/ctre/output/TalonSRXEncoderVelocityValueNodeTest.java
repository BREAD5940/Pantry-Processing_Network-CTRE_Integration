package org.team5940.pantry.processing_network.ctre.output;

import org.junit.Test;
import org.team5940.pantry.processing_network.FullSystemTest;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ctre.input.TalonSRXEncoderVelocityValueNode;

public class TalonSRXEncoderVelocityValueNodeTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void talonSRXEncoderVelocityValueNode_NullCANTalon_IllegalArgumentException() {
		Network network = new Network(2000, FullSystemTest.defaultLogger);
		new TalonSRXEncoderVelocityValueNode(network, FullSystemTest.defaultLogger, FullSystemTest.defaultLabel, null);
	}

}
