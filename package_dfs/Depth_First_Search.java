package package_dfs;

import java.io.*;
import java.util.*;

class Depth_First_Search {

	// Aluno: Ryan Pereira Lima
	// Matrícula: 2020109850
	// Professor: MARCOS JOSE CANEJO ESTEVÃO DE AZEVEDO

	static void put_edge(int t, int s) {
		adj_matrix[t][s] = 1;
		adj_matrix[s][t] = 1;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String nomearquivo = "C:\\pequenoG.txt";
		Scanner scanner = new Scanner(new FileReader(nomearquivo)).useDelimiter("\\s+|\\n");
		Scanner sc = new Scanner(System.in);
		String edge = scanner.next();
		String vertex = scanner.next();
		int k = Integer.parseInt(vertex);
		adj_matrix = new int[k][k];
		int j = Integer.parseInt(edge);

		while (scanner.hasNext()) {
			String vertex2 = scanner.next();
			String vertex1 = scanner.next();
			int column_v = Integer.parseInt(vertex2);
			int line_v = Integer.parseInt(vertex1);
			put_edge(line_v, column_v);
		}
		boolean[] initiate = new boolean[k];
		System.out.println("===========M.A.T.R.I.Z===========");
		System.out.println("        Matriz de Adjacencia  ");
		System.out.println("==============D.F.S==============");
		System.out.println(" ");

		dfs(3, initiate); // <-- Mudar o número do vértice(c) inicial para vizualizar os outros -- Change
							// the starting vertex number to preview.

		System.out.println("<-- Pesquisa em profundidade! ");
		for (int p = 0; p < adj_matrix.length; p++) {
			System.out.println(" ");
			for (int c = 0; c < adj_matrix[0].length; c++) {

				System.out.print(adj_matrix[p][c] + " ");
			}
			System.out.println(" ");
		}
	}

	static void dfs(int go, boolean[] initiate) {

		System.out.print(go + " ");
		initiate[go] = true;
		for (int c = 0; c < adj_matrix[go].length; c++) {
			if (adj_matrix[go][c] == 1 && (!initiate[c])) {
				dfs(c, initiate);
			}
		}
	}

	static int[][] adj_matrix;

}