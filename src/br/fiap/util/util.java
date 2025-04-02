package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

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
                produtoPorNome();
                break;
            case 3:
                fornecedorCnpj();
        }
        }while(opc != 4);
    }

    public void cadastraProduto(){

    }

    public void produtoPorNome(){

    }

    public Fornecedor fornecedorCnpj(){
            long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
            for(int i = 0; i < idxfornecedor; i++){
                if(fornecedor[i].getCnpj() == cnpj){
                    return fornecedor[i];
                }
                showMessageDialog(null, "CNPJ " + cnpj + " não cadastrado");
                return null;
            }
    }
}
