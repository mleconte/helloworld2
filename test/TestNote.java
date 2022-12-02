package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import metier.NoteExamen;

public class TestNote {
	private NoteExamen calcul;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testCalculerGrade() {
		NoteExamen calcul = new NoteExamen();
		try {	
			calcul.calculerGrade("15", null);
			fail("devrait ne pas laisser note controle a null");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testCalculerGradeBorneLimite() {
		NoteExamen calcul = new NoteExamen();
			assertEquals('A', calcul.calculerGrade("75", "25"));
	}
	@Test
	public void testCalculerGradeBorneLimiteBasse() {
		NoteExamen calcul = new NoteExamen();
			assertEquals('D', calcul.calculerGrade("0", "0"));
	}
	@Test
	public void testCalculerGradeErreurExamNeg() {
		NoteExamen calcul = new NoteExamen();
		try {
			char grad =  calcul.calculerGrade("-1", "0");
			fail("Ne doit pas permettre de note exam negative");
		} catch(Exception e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testCalculerGradeErreurExamalpha1() {
		NoteExamen calcul = new NoteExamen();
		try {
			char grad =  calcul.calculerGrade("toto", "0");
			fail("Ne doit pas permettre de note exam alpha");
		} catch(Exception e) {
			assertTrue(true);
		}
		
	}

}
