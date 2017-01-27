package no.hib.dat101;

import java.util.Scanner;

public class Tekstgrensesnitt {

	Scanner tast = new Scanner(System.in);

	// lese opplysningene om en CD fra tastatur
	public CD lesCD() {

		System.out.println("CDnummer: ");
		int cdNummer = tast.nextInt();

		System.out.println("Artistnavn: ");
		String artist = tast.next();

		System.out.println("Albumnavn:  ");
		String tittel = tast.next();

		System.out.println("Utgivelsesår: ");
		int lanseringsaar = tast.nextInt();

		System.out.println("Sjanger: ");
		System.out.println("ROCK, POP, OPERA, CLASSIC");
		Sjanger sjanger = Sjanger.valueOf(tast.next().toUpperCase());

		System.out.println("Plateselskap: ");
		String plateselskap = tast.next();

		// Oppdretter nytt CD-objekt
		CD nyCD = new CD(cdNummer, tittel, artist, lanseringsaar, sjanger, plateselskap);

		return nyCD;

	}

	// vise en CD med alle opplysninger p� skjerm (husk tekst for sjanger)
	public void visCD(CD cd) {

		System.out.println("--------------------------------------");
		System.out.println("CD-nummer: " + cd.getCdNummer());
		System.out.println("Tittel: " + cd.getTittel());
		System.out.println("Artist: " + cd.getArtist());
		System.out.println("Utgivelsesaar: " + cd.getLanseringsaar());
		System.out.println("Sjanger: " + cd.getSjanger());
		System.out.println("Plateselskap: " + cd.getPlateselskap());
		System.out.println("--------------------------------------");

	}

	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng) {

		// Lager ny array
		CD[] cdTabell = cda.sokTittel(delstreng);

		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i] != null) {
				visCD(cdTabell[i]);
			}
		}
	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDArkivADT cda, String delstreng) {

		CD[] cdTabell = cda.sokArtist(delstreng);

		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i] != null) {
				visCD(cdTabell[i]);
			}
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(CDArkivADT cda) {
		System.out.println("                 Antall");
		System.out.println("CD-er	:	 " + cda.hentAntall());
		System.out.println("Classic	:	 " + cda.hentAntall(Sjanger.CLASSIC));
		System.out.println("Rock	:	 " + cda.hentAntall(Sjanger.ROCK));
		System.out.println("Pop	:	 " + cda.hentAntall(Sjanger.POP));
		System.out.println("Opera	:	 " + cda.hentAntall(Sjanger.OPERA));

	}
	// � Ev. andre metoder

	public void visTab(CD[] cda) {

		for (int i = 0; i < cda.length; i++) {
			if (cda[i] != null) {
				visCD(cda[i]);
			}
		}
	}

}
