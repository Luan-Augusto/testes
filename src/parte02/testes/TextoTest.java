package parte02.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parte02.Texto;

class TextoTest {

	@Test
	void testParaMaiusculas() {
		Texto t = new Texto("teste");
		assertEquals("TESTE", t.paraMaiusculas());
	}

	@Test
	void testParaMinusculas() {
		Texto t = new Texto("Outro Teste");
		assertEquals("outro teste", t.paraMinusculas());
	}

	@Test
	void testGetQuantidadeDeCaracteres() {
		Texto t = new Texto("abcd");
		assertEquals(4, t.getQuantidadeDeCaracteres());
	}

	@Test
	void testGetExtensao() {
		Texto t = new Texto("relatorio.doc");
		assertEquals("doc", t.getExtensao());
	}

	@Test
	void testEhIgual() {
		Texto t = new Texto("abc");
		assertTrue(t.ehIgual("abc"));
		assertFalse(t.ehIgual("Abc"));
	}

	@Test
	void testComecaCom() {
		Texto t = new Texto("prefixo");
		assertTrue(t.comecaCom("pre"));
		assertTrue(t.comecaCom("p"));
		assertTrue(t.comecaCom("prefix"));
		assertFalse(t.comecaCom("ref"));
	}

	@Test
	void testTerminaCom() {
		// esse metodo em particular havia um bug e pensei e modificar
		// antes havia "prefixo"
		Texto t = new Texto("sufixo");
		assertTrue(t.terminaCom("ixo"));
		assertTrue(t.terminaCom("fixo"));
		assertFalse(t.terminaCom("suf"));
	}
}
