package metier;

public class NoteExamen {
	private int noteExamen;
	private int controleContinue;


	public int getControleContinue() {
		return controleContinue;
	}


	public void setControleContinue(int note) {
		if (note < 0) {
			throw new RuntimeException("Valeur négative impossible ");
		}
		if (note > 25) {
			throw new RuntimeException("Valeur supérieur a 25 impossible !");
		}
		this.controleContinue = note;
	}


	public int getNoteExamen() {
		return noteExamen;
	}


	public void setNoteExamen(int note) {
		if (note < 0) {
			throw new RuntimeException("Valeur négative impossible ");
		}
		if (note > 75) {
			throw new RuntimeException("Valeur supérieur a 75 impossible !");
		}
		this.noteExamen = note;
	}

	/**
	 * 
	 * @param examen
	 * @param controle
	 * @return
	 */
	public char calculerGrade(String examen, String controle) {
		attribuerValeur(examen, controle);
		int somme = getControleContinue() + getNoteExamen();
		char ret = 'D';
		if (somme >= 70) {
			ret = 'A';
		} else if (somme >= 50) {
			ret = 'B';
		} else if (somme >= 30) {
			ret = 'C';
		}
		
		return ret;
	}

	private void attribuerValeur(String examen, String controle) {
		if (examen == null) {
			throw new RuntimeException("Note d examen null");
		}
		if ("".equals(examen)) {
			throw new RuntimeException("Note d examen non renseignée !");
		}
		if (controle == null) {
			throw new RuntimeException("Note de controle continue null");
		}
		if ("".equals(controle)) {
			throw new RuntimeException("Note de controle copntinue non renseignée !");
		}
		
		int valExam = 0;
		int valControle = 0;
		try {
			valExam = Integer.parseInt(examen);
		} catch(Exception e) {
			throw new RuntimeException("Note examen invalid !!");
		}

		try {
			valControle = Integer.parseInt(controle);
		} catch(Exception e) {
			throw new RuntimeException("Note examen invalid !!");
		}
		setNoteExamen(valExam);
		setControleContinue(valControle);
	}
	
}
