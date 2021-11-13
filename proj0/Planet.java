public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dx = p.xxPos - this.xxPos;
		double dy = p.yyPos - this.yyPos;
		double distance = dx * dx + dy * dy;
		return Math.sqrt(distance);
	}

	public double calcForceExertedBy(Planet p){
		double force = (6.67e-11 * this.mass *p.mass) / (this.calcDistance(p) * this.calcDistance(p));
		return force;
	}

	public double calcForceExertedByX(Planet p){
		double forceX = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
		return forceX; 
	}

	public double calcForceExertedByY(Planet p){
		double forceY = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
		return forceY; 
	}

	public double calcNetForceExertedByX(Planet[] all){
		double forceX = 0;
		for(Planet p : all){
			if(p != this){
				forceX = forceX + this.calcForceExertedByX(p);
			}
			else
				continue;

		}
		return forceX;
	}
	public double calcNetForceExertedByY(Planet[] all){
		double forceY = 0;
		for(Planet p : all){
			if(p != this){
				forceY = forceY + this.calcForceExertedByY(p);
			}
			else
				continue;

		}
		return forceY;
	}
    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }
    public void draw(){
    	StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}