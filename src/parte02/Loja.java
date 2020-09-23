package parte02;

import java.util.ArrayList;
import java.util.List;

public class Loja {
	private String nome;
	private List<Produto> produtos;

	public Loja(String nome) {
		this.nome = nome;
		this.produtos = new ArrayList<Produto>();
	}

	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	public int getQuantidadeDeProdutos() {
		int qntd = 0;
		for (Produto p : produtos) {
			qntd++;
		}
		return qntd;
	}

	public Produto getProdutoMaisBarato() {
		Produto maisBarato = null;
		for (Produto p : produtos) {
			if (maisBarato == null) {
				maisBarato = p;
			} else if (p.getValor() < maisBarato.getValor()) {
				maisBarato = p;
			}
		}
		return maisBarato;
	}

	public Produto getProdutoMaisCaro() {
		Produto maisCaro = null;
		for (Produto p : produtos) {
			if (maisCaro == null) {
				maisCaro = p;
			} else if (p.getValor() > maisCaro.getValor()) {
				maisCaro = p;
			}
		}
		return maisCaro;
	}

	public double getValorTotalLoja() {
		double total = 0;
		for (Produto p : produtos) {
			total += p.getValor();
		}
		return total;
	}

	// Pq ta rodando?
	public double getValorMedioDosProdutos() {
		// TODO - Implementar	
		double media = 0;
		for (Produto p : produtos) {
			media += p.getValor();
			media /= media;
		}
		return media;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}
}
