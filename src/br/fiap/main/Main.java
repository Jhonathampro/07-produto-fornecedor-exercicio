package br.fiap.main;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.util.util;


public class Main {
    public static void main(String[] args) {
        Fornecedor fornecedor = new Fornecedor("jh", 120);
        util ut = new util();

        ut.menu();

    }
}