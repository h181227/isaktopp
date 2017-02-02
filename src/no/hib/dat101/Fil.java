package no.hib.dat101;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ole Olsen
 * 
 */
public class Fil {

	Tekstgrensesnitt tekst = new Tekstgrensesnitt();

	private static String SKILLE = "#";

	/**
	 * @param filnavn
	 * @return Referansen til CD-arkivet
	 * @throws java.io.IOException
	 */
	public CDArkivADT lesFraFil(String filnavn) {

		CDArkivADT cda = null;

		try {
			// // 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);

			// 2 - BufferedReader
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser første linje som er "antall" som sier hvor mange CD-er
			// det er i arkivet
			// Setter n som antall
			String linje = innfil.readLine();
			int antall = Integer.parseInt(linje);

			// Oppretter CDarkiv med plass til n som er antall CD-er i arkivet
			cda = new CDArkiv(antall);

			// 4 - Les postene, en hel post om gangen
			// itererer igjennom arkivet som er lest
			for (int i = 0; i < antall; i++) {

				String post = innfil.readLine(); // lager post som første linje,
													// også første CD i arkivet
				String[] felt = post.split(SKILLE); // Lager en String[] kalt
													// felt, splitter hvert
													// String hver gang det
													// kommer et "SKILLE" #. og
													// setter det inn i arrayen
				int nr = Integer.parseInt(felt[0]); // setter nr til det første
													// elementet i arrayen
				String artist = felt[1]; // setter artist til det andre element
											// i array
				String tittel = felt[2]; // setter tittel til det tredje element
											// i array
				int aar = Integer.parseInt(felt[3]); // setter aar til det
														// fjerde element i
														// array
				Sjanger sjanger = Sjanger.valueOf(felt[4].toUpperCase()); // setter
																			// sjanger
																			// som
																			// det
																			// 5
																			// element
																			// i
																			// array
				String plselskap = felt[5]; // Setter det 5 feltet til
											// plateselskap

				CD cd = new CD(nr, artist, tittel, aar, sjanger, plselskap); // all
																				// denne
																				// //
																				// her

				cda.leggTilCd(cd); // her legger den infoen inn

				tekst.visCD(cd);

			}

			// 4 - Lukk filen
			innfil.close();

		} catch (FileNotFoundException unntak) {// arver fra IOException m� st�
												// f�rst
												// hvis ikke vil unntaket for
												// IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}

		return cda;
	}

	public void skrivTilFil(CDArkivADT cda, String filnavn, boolean utvid) {
		CD[] cdTab = cda.hentCdTabell();
		try {
			PrintWriter f;

			f = new PrintWriter(new FileWriter("fil.txt"));

			// CD nyCD = tekst.lesCD();
			// cda.leggTilCd(nyCD);
			f.println(cda.hentAntall());
			System.out.println(cda.hentAntall());
			for (int i = 0; i < cda.hentAntall(); i++) {
				if (cdTab[i] != null) {
					f.print(cdTab[i].getCdNummer() + SKILLE);
					f.print(cdTab[i].getArtist() + SKILLE);
					f.print(cdTab[i].getTittel() + SKILLE);
					f.print(cdTab[i].getLanseringsaar() + SKILLE);
					f.print(cdTab[i].getSjanger() + SKILLE);
					f.print(cdTab[i].getPlateselskap());
					f.println();
				}
			}
			f.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}// class
