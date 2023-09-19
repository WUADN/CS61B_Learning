import java.lang.Math;
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p1){
        double distance = 0;
        double xdistance = xxPos - p1.xxPos;
        double ydistance = yyPos - p1.yyPos;
        distance = Math.sqrt(xdistance * xdistance + ydistance * ydistance);
        return distance;
    }

    public double calcForceExertedBy(Planet p1){
        final double G = 6.67e-11;
        double distance = calcDistance(p1);
        return (G * mass * p1.mass)/(distance * distance);
    }

    public double calcForceExertedByX(Planet p1){
        double absF = calcForceExertedBy(p1);
        double dx = p1.xxPos - xxPos;
        double distance = calcDistance(p1);
        double Fx = absF * dx / distance;
        return Fx;
    }

    public double calcForceExertedByY(Planet p1){
        double absF = calcForceExertedBy(p1);
        double dy = p1.yyPos - yyPos;
        double distance = calcDistance(p1);
        double Fy = absF * dy / distance;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] p1){
        double sum = 0.0;
        for (Planet p : p1){
            if (!equals(p)){
                sum += calcForceExertedByX(p);
            }
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] p1){
        double sum = 0.0;
        for (Planet p : p1){
            if (!equals(p)){
                sum += calcForceExertedByY(p);
            }
        }
        return sum;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel = xxVel + ax * dt;
        yyVel = yyVel + ay * dt;
        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }

    public void draw(){
        String fullpath = "images/"+ imgFileName;  
        StdDraw.picture(xxPos, yyPos, fullpath);
        StdDraw.show();
    }
}
