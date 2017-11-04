package org.team5940.pantry.processing_network.ctre.input;

import org.junit.Test;
import org.team5940.pantry.processing_network.FullSystemTest;
import org.team5940.pantry.processing_network.Network;
import org.team5940.pantry.processing_network.functional.ConstantValueNode;

public class TalonSRXNodeTest {
	
	@Test
	public void talonSRXNode_EmptyCANTalonArray() throws InterruptedException {
		Network network = new Network(100, FullSystemTest.defaultLogger);
		new TalonSRXNode(network, FullSystemTest.defaultLogger, true, new ConstantValueNode<Number>(network, FullSystemTest.defaultLogger,  0.5));
		network.start();
		Thread.sleep(400);
		network.interrupt();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void talonSRXNode_EmptyCANTalonArray_IllegalArgumentException() throws InterruptedException {
		Network network = new Network(100, FullSystemTest.defaultLogger);
		new TalonSRXNode(network, FullSystemTest.defaultLogger, true, new ConstantValueNode<Number>(network, FullSystemTest.defaultLogger, 0.5), null);
	}
}
