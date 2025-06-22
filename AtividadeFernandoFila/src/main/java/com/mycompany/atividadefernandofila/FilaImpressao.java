/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadefernandofila;

/**
 *
 * @author iagom
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FilaImpressao {
    private Deque<Documento> filaDeImpressao;
    private Set<Integer> idsGerados; // Para garantir IDs únicos
    private Random random;

    private static final String[] TIPOS_DOCUMENTO = {"PDF", "TXT", "JPG", "PNG", "DOCX", "XLSX"};

    public FilaImpressao() {
        this.filaDeImpressao = new ArrayDeque<>();
        this.idsGerados = new HashSet<>();
        this.random = new Random();
    }

    private int gerarIdUnico() {
        int id;
        do {
            id = random.nextInt(1000) + 1; // IDs entre 1 e 1000
        } while (idsGerados.contains(id));
        idsGerados.add(id);
        return id;
    }
    private String gerarTipoDocumentoAleatorio() {
        return TIPOS_DOCUMENTO[random.nextInt(TIPOS_DOCUMENTO.length)];
    }
    private int gerarQuantidadePaginasAleatoria() {
        return random.nextInt(100) + 1; // Páginas entre 1 e 100
    }
    public void adicionarDocumentoNormal() {
        int id = gerarIdUnico();
        String tipo = gerarTipoDocumentoAleatorio();
        int paginas = gerarQuantidadePaginasAleatoria();
        Documento documento = new Documento(id, tipo, paginas);
        filaDeImpressao.addLast(documento);
        System.out.println("ADICIONADO (NORMAL): " + documento);
    }
    public void adicionarDocumentoUrgente() {
        int id = gerarIdUnico();
        String tipo = gerarTipoDocumentoAleatorio();
        int paginas = gerarQuantidadePaginasAleatoria();
        Documento documento = new Documento(id, tipo, paginas);
        filaDeImpressao.addFirst(documento);
        System.out.println("ADICIONADO (URGENTE): " + documento);
    }
    public Documento processarProximo() {
        if (fila_vazia()) {
            System.out.println("A fila de impressão está vazia. Nenhum documento para processar.");
            return null;
        }
        Documento documentoProcessado = filaDeImpressao.removeFirst();
        idsGerados.remove(documentoProcessado.getId()); // Remove o ID para que possa ser reutilizado no futuro, se necessário
        System.out.println("PROCESSADO (INÍCIO): " + documentoProcessado);
        return documentoProcessado;
    }
    public Documento processarUltimo() {
        if (fila_vazia()) {
            System.out.println("A fila de impressão está vazia. Nenhum documento para processar.");
            return null;
        }
        Documento documentoProcessado = filaDeImpressao.removeLast();
        idsGerados.remove(documentoProcessado.getId()); // Remove o ID para que possa ser reutilizado no futuro, se necessário
        System.out.println("PROCESSADO (FINAL): " + documentoProcessado);
        return documentoProcessado;
    }
    public void visualizarFila() {
        if (fila_vazia()) {
            System.out.println("A fila de impressão está vazia.");
            return;
        }
        System.out.println("\n--- Documentos na Fila de Impressão ---");
        int i = 1;
        for (Documento doc : filaDeImpressao) {
            System.out.println(i++ + ". " + doc);
        }
        System.out.println("-------------------------------------\n");
    }
    public boolean fila_vazia() {
        return filaDeImpressao.isEmpty();
    }
    public int totalDocumentos() {
        return filaDeImpressao.size();
    }
    public int totalPaginas() {
        int total = 0;
        for (Documento doc : filaDeImpressao) {
            total += doc.getPaginas();
        }
        return total;
    }
}
