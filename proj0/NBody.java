public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int numberOfPlanets = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int numberOfPlanets = in.readInt();
        double universeRadius = in.readDouble();

        Planet[] planets = new Planet[numberOfPlanets];
        for (int i = 0; i < numberOfPlanets; i++) {
            double x = in.readDouble();
            double y = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(x, y, xVel, yVel, mass, imgFileName);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        double universeRadius = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);

        StdDraw.setScale(-universeRadius, universeRadius);
		StdDraw.clear();
        StdDraw.picture(0, 0,"images/starfield.jpg");
        for (Planet p : planets) {
            p.draw();
        }
        StdDraw.show();
        
        double time = 0;
        StdDraw.enableDoubleBuffering();
        while (time < T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            StdDraw.picture(0, 0,"images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
    }
}