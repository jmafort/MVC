package trabalho_final;

import java.util.HashMap;
import java.util.TreeMap;

public class Controlador{
    private final TreeMap<String, Vendedor> vendedores = new TreeMap<String, Vendedor>();
    private final TreeMap<String, Cliente> clientes = new TreeMap<String, Cliente>();
    private final HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>();

    public boolean cadastrarProduto(String nome, int id, double preco, int qtd_estoque, boolean mostruario){
        if (produtos.containsKey(id)){
            return false;
        }
        else{
            Produto p = new Produto(nome, id, preco, qtd_estoque, mostruario);
            produtos.put(id, p);
            return true;
        }
    }

    public Produto getProduto(int id){
        Produto produto = null;
        if (produtos.get(id) != null){
            produto = produtos.get(id);
        }
        return produto;
    }

    public boolean cadastrarCliente(String nome, String CPF, String endereco, String telefone){
        if (clientes.containsKey(CPF)){
            return false;
        }
        else{
            Cliente c = new Cliente(nome, CPF, endereco, telefone);
            clientes.put(CPF, c);
            return true;
        }
    }

    public Cliente getCliente(String CPF){
        Cliente cliente = null;
        if (clientes.get(CPF) != null){
            cliente = clientes.get(CPF);
        }
        return cliente;
    }


    public boolean cadastrarVendedor(float salario_base, String nome, String CPF, String endereco, String telefone){
        if (vendedores.containsKey(CPF)){
            return false;
        }
        else{
            Vendedor v = new Vendedor(salario_base, nome, CPF, endereco, telefone);
            vendedores.put(CPF, v);
            return true;
        }
    }

    public Vendedor getVendedor(String CPF){
        Vendedor vendedor = null;
        if(vendedores.get(CPF) != null){
            vendedor = vendedores.get(CPF);
        }
        return vendedor;
    }
    

    public void Vender(int id, String date, String CPFvendedor, int IDproduto, String CPFcliente) throws Exception{
        Vendedor vendedor = getVendedor(CPFvendedor);
        if( vendedor == null){
            throw new Exception("Vendedor nao existe.");
        }
        Cliente cliente = getCliente(CPFcliente);
        if( cliente == null){
            throw new Exception("Cliente nao existe.");
        }
        Produto produto = getProduto(IDproduto);
        if( produto == null){
            throw new Exception("Produto nao existe.");
        }

        if(produto.getQtd_estoque() > 0){
            if(vendedor.getVenda(id) == null){
                Venda venda = new Venda(id, date);
                venda.addProdutos(produto);
                produto.setQtd_estoque(produto.getQtd_estoque() - 1);
                if(produto.isMostruario()){
                    venda.setTotal(produto.getPreco()*0.8);
                }
                else{
                    venda.setTotal(produto.getPreco());
                }
                
                vendedor.addVenda(venda);
                cliente.addVenda(venda);
                System.out.println("Venda Criada !");
            }
            else{
                Venda venda = vendedor.getVenda(id);
                venda.addProdutos(produto);
                produto.setQtd_estoque(produto.getQtd_estoque() - 1);
                
                if(produto.isMostruario()){
                    venda.setTotal(venda.getTotal()+0.8*produto.getPreco());
                }
                else{
                    venda.setTotal(venda.getTotal()+produto.getPreco());
                }

                //Atualiza venda no cliente e vendedor
                for(Venda v : vendedor.getVendas()){
                    if(v.getId() == venda.getId()){
                        int index = vendedor.getVendas().indexOf(v);
                        vendedor.atualizaVenda(venda, index);
                        System.out.println("Venda (vendedor) atualizada !");
                    }
                }

                for(Venda v : cliente.getVendas()){
                    if(v.getId() == venda.getId()){
                        int index = cliente.getVendas().indexOf(v);
                        cliente.atualizaVenda(venda, index);
                        System.out.println("Venda atualizada !");
                    }
                }
            }
        }
        else{
            throw new Exception("Quantidade insuficiente em estoque.");
        }
    }
}