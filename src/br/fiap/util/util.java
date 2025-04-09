package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class util {
    private Produto[] produto = new Produto[5];
    private Fornecedor[] fornecedor = new Fornecedor[5];
    private int idxProduto = 0;
    private int idxfornecedor = 0;


    public void menu(){
        int opc = 0;
        String msg = "1. Cadastar Produto\n2. Produto por nome\n3. Fornecedor por CNPJ\n4. Finalizar";

        do {
        opc = parseInt(showInputDialog(msg));
        if(opc < 1 || opc > 4){
            showMessageDialog(null, "Opção Invalída");
        }

        switch (opc){
            case 1:
                cadastraProduto();
                break;
            case 2:
                pesquisarProduto();
                break;
            case 3:
                pesquisar();
                fornecedorCnpj();
        }
        }while(opc != 4);
    }

    private void pesquisar() {
        Fornecedor fornecedor = fornecedorCnpj();
        String msg = "";
        if(fornecedor != null) {
            msg += "Fornecedor: " + fornecedor.getNome() + "\n";
            msg += "CNPJ: " + fornecedor.getCnpj() + "\n";
            showMessageDialog(null, msg);
         }

    }

    public void cadastraProduto(){
        String nome;
        int quantidadeEstoque;
        double valorUnitario;
        Fornecedor fornecedor = fornecedorCnpj();
        if (fornecedor == null){
            fornecedor = cadastrarFornecedor();
        }
        nome = showInputDialog("Nome do produto");
        quantidadeEstoque = parseInt(showInputDialog("Quantidade em estoque"));
        valorUnitario = parseDouble(showInputDialog("Valor unitário"));
        produto[idxProduto++] = new Produto(nome, quantidadeEstoque, valorUnitario, fornecedor);
    }


     private Fornecedor cadastrarFornecedor(){
        Fornecedor fornecedor = null;
        long cnpj = parseInt(showInputDialog("CNPJ do fornecedor"));
        String nome = showInputDialog("Nome do fornecedor");
        fornecedor = new Fornecedor(nome, cnpj);
        this.fornecedor[idxfornecedor++] = fornecedor;
        return fornecedor;
     }

    public void pesquisarProduto(){
        DecimalFormat df = new DecimalFormat("0.00");
        String msg = "Produto não cadastrado";
        String nome = showInputDialog("Nome do produto");

        for (int i = 0; i < idxProduto; i++){
            if(produto[i].getNome().equalsIgnoreCase(nome)){
                msg = "";
                msg += "Nome do produto: " + nome + '\n';
                msg += "Valor unitario: "  + df.format(produto[i].getValorUnitario()) + "\n";
                msg += "Fornecedor: "  + produto[i].getFornecedor().getNome();
            }
        }
        showMessageDialog(null, msg);
    }

    public Fornecedor fornecedorCnpj() {
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
        for (int i = 0; i < idxfornecedor; i++) {
            if (fornecedor[i].getCnpj() == cnpj) {
                return fornecedor[i];
            }

        }
        showMessageDialog(null, "CNPJ " + cnpj + " não cadastrado");
        return null;
    }

}
