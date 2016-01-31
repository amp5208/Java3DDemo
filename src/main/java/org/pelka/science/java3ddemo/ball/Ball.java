package org.pelka.science.java3ddemo.ball;

import javax.vecmath.Color3f;

/**
 * Use this as an interface to create a ball-type object. There may be many
 * kinds of balls, but this should be a local implementation starting point for
 * balls of all sorts.
 * 
 * @author arnoldpelka
 *
 */
public interface Ball {
	/**
	 * Generates ball based on available settings
	 */
	public void generateBall();

	/**
	 * Destroys ball instance
	 */
	public void destroyBall();

	/**
	 * Sets standard black color based on custom floating point values. In RGB
	 * format.
	 * 
	 * @param r
	 *            Red floating point value
	 * @param g
	 *            Green floating point value
	 * @param b
	 *            Black floating point value
	 */
	public void setBlackColor(float r, float g, float b);

	/**
	 * Sets standard white color based on custom floating point values. In RGB
	 * format.
	 * 
	 * @param r
	 *            Red floating point value
	 * @param g
	 *            Green floating point value
	 * @param b
	 *            Black floating point value
	 */
	public void setWhiteColor(float r, float g, float b);

	/**
	 * Sets standard red color based on custom floating point values. In RGB
	 * format.
	 * 
	 * @param r
	 *            Red floating point value
	 * @param g
	 *            Green floating point value
	 * @param b
	 *            Black floating point value
	 */
	public void setRedColor(float r, float g, float b);

	/**
	 * Retrieves set black color as a Color object
	 * 
	 * @return Color3f object of set color
	 */
	public Color3f getBlackColor();

	/**
	 * Retrieves set white color as a Color object
	 * 
	 * @return Color3f object of set color
	 */
	public Color3f getWhiteColor();

	/**
	 * Retrieves set red color as a Color object
	 * 
	 * @return Color3f object of set color
	 */
	public Color3f getRedColor();

	/**
	 * Sets a texture on a sphere for custom rendering
	 * 
	 * @param filePathToImage
	 *            A stringified file path to an image. Direct paths should have
	 *            escaped characters embedded, and local files will be
	 *            accessible in classpath if they are located with the Maven
	 *            resources directories.
	 */
	public void setTexture(String filePathToImage);
}
