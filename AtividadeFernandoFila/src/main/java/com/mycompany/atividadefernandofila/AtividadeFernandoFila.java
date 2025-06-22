/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atividadefernandofila;

/**
 *
 * @author iagom
 */
public class AtividadeFernandoFila {

    public static void main(String[] args) {
        FilaImpressao impressora = new FilaImpressao();

        System.out.println("--- Testando a Fila de Impressão ---");

        // Adicionando documentos
        impressora.adicionarDocumentoNormal();
        impressora.adicionarDocumentoUrgente();
        impressora.adicionarDocumentoNormal();
        impressora.adicionarDocumentoUrgente();
        impressora.adicionarDocumentoNormal();

        impressora.visualizarFila();
        System.out.println("Total de documentos: " + impressora.totalDocumentos());
        System.out.println("Total de páginas: " + impressora.totalPaginas());
        System.out.println("Fila está vazia? " + impressora.fila_vazia());

        System.out.println("\n--- Processando Impressões ---");
        impressora.processarProximo();
        impressora.processarUltimo();
        impressora.processarProximo();

        impressora.visualizarFila();
        System.out.println("Total de documentos: " + impressora.totalDocumentos());
        System.out.println("Total de páginas: " + impressora.totalPaginas());

        impressora.processarProximo();
        impressora.processarUltimo(); // Tentando processar o último quando a fila está quase vazia

        impressora.visualizarFila();
        System.out.println("Total de documentos: " + impressora.totalDocumentos());
        System.out.println("Total de páginas: " + impressora.totalPaginas());
        System.out.println("Fila está vazia? " + impressora.fila_vazia());

        System.out.println("\n--- Testando fila vazia ---");
        impressora.processarProximo();
        impressora.processarUltimo();
    }
}
