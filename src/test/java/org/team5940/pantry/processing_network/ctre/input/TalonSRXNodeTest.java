package org.team5940.pantry.processing_network.ctre.input;

import org.junit.Test;
import org.team5940.pantry.processing_network.FullSystemTest;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.ctre.output.TalonSRXNode;
import org.team5940.pantry.processing_network.functional.ConstantValueNode;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class TalonSRXNodeTest {

	@Test
	public void talonSRXNode_EmptyCANTalonArray() throws InterruptedException {
		Network network = new Network(100, FullSystemTest.defaultLogger);
		ConstantValueNode<ControlMode> controlMode = new ConstantValueNode<ControlMode>(network,
				FullSystemTest.defaultLogger, FullSystemTest.defaultLabel, ControlMode.PercentOutput);
		new TalonSRXNode(network, FullSystemTest.defaultLogger, FullSystemTest.defaultLabel, true, controlMode,
				new ConstantValueNode<Number>(network, FullSystemTest.defaultLogger, FullSystemTest.defaultLabel, 0.5));
		network.start();
		Thread.sleep(400);
		network.interrupt();
	}

	@Test(expected = IllegalArgumentException.class)
	public void talonSRXNode_EmptyCANTalonArray_IllegalArgumentException() throws InterruptedException {
		Network network = new Network(100, FullSystemTest.defaultLogger);
		ConstantValueNode<ControlMode> controlMode = new ConstantValueNode<ControlMode>(network,
				FullSystemTest.defaultLogger, FullSystemTest.defaultLabel, ControlMode.PercentOutput);
		new TalonSRXNode(network, FullSystemTest.defaultLogger, FullSystemTest.defaultLabel, true, controlMode,
				new ConstantValueNode<Number>(network, FullSystemTest.defaultLogger, FullSystemTest.defaultLabel, 0.5),
				null);
	}
}
