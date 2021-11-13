import java.util.Scanner;
public class NBody{
	public static double readRadius(String filename){
		In in = new In(filename);
        int num = in.readInt();
        return in.readDouble();
	}
	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int num = in.readInt();
		in.readDouble();
		Planet[] p = new Planet[num];
		for(int i = 0; i < num ;i ++){
			p[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		}
		return p;
	}
	public static void main(String[] args){
		double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		// drawing the background
		StdDraw.enableDoubleBuffering();
		String imageToDraw = "images/starfield.jpg";
		
		for(double t = 0; t <= T; t += dt){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for(int i = 0; i < planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
				planets[i].update(dt, xForces[i], yForces[i]);
			}
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, imageToDraw);
		for(Planet p:planets){
			p.draw();
		}
		StdDraw.show();
		StdDraw.pause(10);
		}
		
	}
}