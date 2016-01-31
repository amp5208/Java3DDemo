package org.pelka.science.java3ddemo.ball;

import java.awt.Container;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class PictureBall implements Ball {
	protected static final Logger LOGGER = LoggerFactory.getLogger(PictureBall.class);
	protected SimpleUniverse universe;
	protected BranchGroup group;
	protected Color3f black;
	protected Color3f white;
	protected Color3f red;
	protected TextureLoader loader;
	protected Texture texture;
	protected Appearance ap;
	protected Sphere sphere;

	/**
	 * Generates a picture ball instance with basic settings (use accesors /
	 * mutators to modulate these default settings)
	 */
	public PictureBall() {
		LOGGER.info("Initializing a default picture ball construct");
		// Create a world
		this.universe = new SimpleUniverse();
		this.group = new BranchGroup();
		this.black = new Color3f(0.0f, 0.0f, 0.0f);
		this.white = new Color3f(1.0f, 1.0f, 1.0f);
		this.red = new Color3f(0.7f, .15f, .15f);

		// Texturize
		this.loader = new TextureLoader("skyrim.jpg", "LUMINANCE", new Container());
		this.texture = this.loader.getTexture();
		this.texture.setBoundaryModeS(Texture.WRAP);
		this.texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
		TextureAttributes texAttr = new TextureAttributes();
		texAttr.setTextureMode(TextureAttributes.MODULATE);
		this.ap = new Appearance();
		this.ap.setTexture(this.texture);
		this.ap.setTextureAttributes(texAttr);

		// Setup material
		this.ap.setMaterial(new Material(this.red, this.black, this.red, this.black, 1.0f));
	}

	/**
	 * Constructs a picture ball based on all required mutators
	 * 
	 * @param black
	 *            Customized black color palate
	 * @param white
	 *            Customized white color palate
	 * @param red
	 *            Customized red color palate
	 * @param customTexture
	 *            A texture loader artifact that is based on an image file
	 *            (please read the interface for more details)
	 */
	public PictureBall(Color3f black, Color3f white, Color3f red, TextureLoader customTexture) {
		LOGGER.info("Initializing a specified picture ball construct");
		// Create a world
		this.universe = new SimpleUniverse();
		this.group = new BranchGroup();

		// Texturize
		loader = customTexture;
		this.texture = loader.getTexture();
		this.texture.setBoundaryModeS(Texture.WRAP);
		this.texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
		TextureAttributes texAttr = new TextureAttributes();
		texAttr.setTextureMode(TextureAttributes.MODULATE);
		this.ap = new Appearance();
		this.ap.setTexture(this.texture);
		this.ap.setTextureAttributes(texAttr);
		// Setup material
		this.ap.setMaterial(new Material(red, black, red, black, 1.0f));
	}

	@Override
	public void generateBall() {
		LOGGER.info("Generating a picture ball");
		// Add a sphere child
		int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
		Sphere sphere = new Sphere(0.5f, primflags, this.ap);
		this.group.addChild(sphere);

		// Create lights
		Color3f light1Color = new Color3f(1f, 1f, 1f);
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
		Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
		DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
		light1.setInfluencingBounds(bounds);
		this.group.addChild(light1);
		AmbientLight ambientLight = new AmbientLight(new Color3f(.5f, .5f, .5f));
		ambientLight.setInfluencingBounds(bounds);
		this.group.addChild(ambientLight);

		// Set viewing perspective
		this.universe.getViewingPlatform().setNominalViewingTransform();

		// Add the group of objects to the existing Universe
		this.universe.addBranchGraph(this.group);
	}

	@Override
	public void destroyBall() {
		LOGGER.info("Destroying all balls");
		universe.cleanup();
		universe.removeAllLocales();
		sphere.removeAllChildren();
		universe = null;
		sphere = null;
	}

	@Override
	public void setBlackColor(float r, float g, float b) {
		this.black = new Color3f(r, g, b);
	}

	@Override
	public void setWhiteColor(float r, float g, float b) {
		this.white = new Color3f(r, g, b);
	}

	@Override
	public void setRedColor(float r, float g, float b) {
		this.red = new Color3f(r, g, b);
	}

	@Override
	public Color3f getBlackColor() {
		return this.black;
	}

	@Override
	public Color3f getWhiteColor() {
		return this.white;
	}

	@Override
	public Color3f getRedColor() {
		return this.red;
	}

	@Override
	public void setTexture(String filePathToImage) {
		// Texturize
		loader = new TextureLoader(filePathToImage, "LUMINANCE", new Container());
		this.texture = loader.getTexture();
		this.texture.setBoundaryModeS(Texture.WRAP);
		this.texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
		TextureAttributes texAttr = new TextureAttributes();
		texAttr.setTextureMode(TextureAttributes.MODULATE);
		this.ap = new Appearance();
		this.ap.setTexture(this.texture);
		this.ap.setTextureAttributes(texAttr);

		// Setup material
		this.ap.setMaterial(new Material(red, black, red, black, 1.0f));
	}

}
