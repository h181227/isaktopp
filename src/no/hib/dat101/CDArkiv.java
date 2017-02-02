package no.hib.dat101;

import java.util.Objects;

public class CDArkiv implements CDArkivADT {

	// Instansvariable

	private CD[] cdTabell;
	private int antall;

	public CDArkiv(int antall) {
		this.antall = antall;
		cdTabell = new CD[antall];
	}

	@Override
	public CD[] hentCdTabell() {

		return cdTabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {

		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i] == (null)) {
				cdTabell[i] = nyCd;
				break;
			}
		}
	}

	@Override
	// public boolean slettCd(int cdNr) {
	// // for (int i = 0; i < cdTabell.length; i++) {
	// // if (cdTabell[i] != null) {
	// // if (Objects.equals(cdTabell[i].getCdNummer(), cdNr)) {
	// // cdTabell[i] = null;
	// // System.out.println("Slettet: " + cdNr);
	// // return true;
	// // }
	// // }
	// // }
	// return false;
	// }

	public boolean slettCd(int cdNr) {

		boolean slettet = false;
		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i] != null) {
				if (Objects.equals(cdTabell[i].getCdNummer(), cdNr)) {
					cdTabell[i] = null;
					cdTabell[i] = cdTabell[cdTabell.length - 1];
					cdTabell[cdTabell.length - 1] = null;
					slettet = true;
				}
			}

		}

		return slettet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {

		// Lager ny array

		CD[] nyTab = new CD[antall]; // 10
		int sum = 0;

		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i] != null) {

				if (Objects.equals(delstreng, cdTabell[i].getTittel())) {

					nyTab[sum] = cdTabell[i];
					sum++;
				}

			}
		}

		return nyTab;

	}

	@Override
	public CD[] sokArtist(String delstreng) {

		// Lager ny array

		CD[] nyTab = new CD[antall]; // 10
		int sum = 0;

		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i] != null) {

				if (Objects.equals(delstreng, cdTabell[i].getArtist())) {

					nyTab[sum] = cdTabell[i];
					sum++;
				}

			}
		}

		return nyTab;

	}

	@Override
	public int hentAntall() {
		int antallCD = 0;
		for (int i = 0; i < cdTabell.length; i++) {
			if (cdTabell[i] != null) {
				antallCD++;
			}
		}

		return antallCD;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		int antallCDISjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i] != null) {
				if(Objects.equals(cdTabell[i].getSjanger(), sjanger)){
					antallCDISjanger++;
				}
			}
		}
		return antallCDISjanger;
	}

}
