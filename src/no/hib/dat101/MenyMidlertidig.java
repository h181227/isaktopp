package no.hib.dat101;

import java.util.Scanner;

public class MenyMidlertidig {

	private CDArkivADT cda;
	private Tekstgrensesnitt tekst;
	Scanner tast;
	int valg;
	String delstreng;
	Fil fil = new Fil();

	public MenyMidlertidig(CDArkivADT cda) {
		this.cda = cda;
		tekst = new Tekstgrensesnitt();
	}

	public void start() {
		System.out.println("Hei og velkommen til CD-arkiv-oppgaven i DAT102! - Isak");
		tast = new Scanner(System.in);
		hovedmeny();
		tast.close();
	}

	public void hovedmeny() {
		// opprette ett nytt arkiv

		// øpne arkiv fra fil
		String meny = "\n1 - Opprette nytt arkiv" + "\n2 - Les fra eksisterende arkiv" + "\n3 - Avslutt" + "\nValg: ";

		do {
			System.out.print(meny);
			valg = tast.nextInt();
			switch (valg) {
			case 1:
				// opprette nytt arkiv
				oppretteNyttArkiv();
				break;
			case 2:
				// Eksisterende arkiv
				eksisterendeArkiv();
				break;
			case 3:
				break;
			default:
				System.out.println("Ukjent mneyvalg");
			}
		} while (valg != 3);

	}

	public void undermeny() {
		// alle valg

		String meny = "\n1 - Hent CD-tabell" + "\n2 - Legg til CD" + "\n3 - Slett CD" + "\n4 - Søk etter CD ved tittel"
				+ "\n5 - Søk etter CD ved artist" + "\n6 - Hent antall CD-er" + "\n7 - Hent antall innenfor sjanger"
				+ "\nValg: ";
		System.out.println("");
		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1:
				// hent CD-tabell
				cda.hentCdTabell();
				fil.lesFraFil("fil.txt");
				break;
			case 2:
				// Legg til CD
				cda.leggTilCd(tekst.lesCD());
				fil.skrivTilFil(cda, "fil.txt", false);
				break;
			case 3:
				// Slett CD
				System.out.print("Skriv inn CD-nummeret til den CD-en du vil slette: ");
				valg = tast.nextInt();
				cda.slettCd(valg);
				fil.skrivTilFil(cda, "fil.txt", false);
				break;
			case 4:
				// S�k etter CD med tittel
				System.out.print("Søk etter tittel: ");
				tekst.skrivUtCdDelstrengITittel(cda, tast.next());
				break;
			case 5:
				// Søk etter CD med artist
				System.out.print("Søk etter artist: ");
				delstreng = tast.next();
				tekst.skrivUtCdArtist(cda, delstreng);

				break;
			case 6:
				// Hent antall CD-er
				System.out.print("Hvor mange CD-er det er i arkivet: " + cda.hentAntall());
				break;

			case 7:

				System.out.println("Sjanger: ");
				Sjanger sjanger = Sjanger.valueOf(tast.next().toUpperCase());
				System.out.println("Det er " + cda.hentAntall(sjanger) + " CD-er med denne sjanger");

				break;
			default:
				System.out.println("Ukjent menyvalg. ");
			}
		} while (valg != 7);
	}
	
	
	

	public void oppretteNyttArkiv() {

		undermeny();
	}

	public void eksisterendeArkiv() {
		undermeny();
	}

}
