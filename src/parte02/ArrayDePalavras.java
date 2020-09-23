package parte02;

public class ArrayDePalavras {
  private String[] palavras;
  
  public ArrayDePalavras(int tamanho) {
    palavras = new String[tamanho];
  }
  
  public void setPalavra(int indice, String palavra) {
	  palavras[indice] = palavra;
  }
  
  public String getPalavra(int indice) {
    return palavras[indice];
  }
  
  public int getTamanho() {
    return palavras.length;
  }
}
