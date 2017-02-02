package no.hib.dat101;

import java.util.Scanner;

public class CDArkivKlient {

	public static void main(String[] args) {

		Fil fil = new Fil();

		Tekstgrensesnitt tekst = new Tekstgrensesnitt();

		Scanner tast = new Scanner(System.in);

		CDArkivADT cda = new CDArkiv(10);

		// TEST
		// CD cd = new CD(0, "eli", "eli", 2000, Sjanger.POP, "plateselskap");
		// CD cd1 = new CD(1, "isak", "isak", 2009, Sjanger.POP,
		// "plateselskap");
		// CD cd2 = new CD(2, "eirik", "eirik", 2009, Sjanger.ROCK,
		// "plateselskap");
		// CD cd3 = new CD(3, "oskar", "oskar", 2009, Sjanger.OPERA,
		// "plateselskap");
		//
		// cda.leggTilCd(cd);
		// cda.leggTilCd(cd1);
		// cda.leggTilCd(cd2);
		// cda.leggTilCd(cd3);
		// System.out.println(cd.getCdNummer());
		// fil.skrivTilFil(cda, "fil.txt", false);
		// cda.slettCd(0);
		// fil.skrivTilFil(cda, "fil.txt", false);
		// System.out.println(cd.getCdNummer());
		//
		// tekst.skrivUtStatistikk(cda);

		// System.out.println("Sjanger: ");
		// Sjanger sjanger = Sjanger.valueOf(tast.next().toUpperCase());
		// System.out.println(cda.hentAntall(sjanger));
		//

		// System.out.print("Søk etter tittel: ");
		// String delstreng = tast.next();
		// cda.sokTittel(delstreng);
		// tekst.visTab(cda.sokTittel(delstreng));

		// Lager ny tabell med CD-er med delstrengen i tittelen
		// CD[] cdArkivTittel = cda.sokTittel(delstreng);
		// System.out.println(cdArkivTittel);
		// tekst.visTab(cdArkivTittel);

		// G�r gjennom, printer ut CDene.

		// tekstg.skrivUtCdDelstrengITittel(cda, delstreng);

		// cda.leggTilCd(tekst.lesCD());
		// System.out.println(cda.hentAntall());
		// System.out.println(cda.hentAntall());

		// cda.sokTittel("isak");
		// String delstreng = tast.next();
		// tekst.skrivUtCdDelstrengITittel(cda, "isak");
		// tekst.skrivUtCdArtist(cda, "isak");

		// fil.lesFraFil("fil.txt");

		Meny meny = new Meny(cda);
		meny.start();
		// fil.lesFraFil("fil.txt");
	}

}
