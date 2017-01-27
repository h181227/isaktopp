package no.hib.dat101;

public enum Sjanger {
	ROCK(0), POP(1), OPERA(2), CLASSIC(3);
	private int nr;

	private Sjanger(int n) { // Konstruktør
		nr = n;
	}

	public int getNr() {
		return nr;
	}
	
	public String toString() {
		switch(this){
		case ROCK :
			return "rock";
		case POP : 
			return "pop";
		case OPERA : 
			return "opera";
		case CLASSIC :
			return "classic";
		}
		return null;
	}

	public static Sjanger finnSjanger(int n) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.nr == n) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}// metode

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString() ==(navn.toUpperCase())) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}// metode
}// class