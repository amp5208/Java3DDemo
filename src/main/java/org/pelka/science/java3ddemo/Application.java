package org.pelka.science.java3ddemo;

import org.pelka.science.java3ddemo.ball.Ball;
import org.pelka.science.java3ddemo.ball.PictureBall;

/**
 * This application is meant to utilize the Java3D and OpenGL core artifacts to
 * demonstrate the use of 3D applications. This is currently meant purely for
 * educational purposes.
 * 
 * @author arnoldpelka
 *
 */
public class Application {

	/**
	 * Main method for orchestrating main Java thread
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//System.loadLibrary("jawt");
		Ball ball = new PictureBall();
		ball.generateBall();
	}

}
