
package trabalho_final;
import java.util.Scanner;

public class View {
    private final Controlador ctrl = new Controlador();
    public static void main(String[] args) {
        View v = new View();
        Scanner sc = new Scanner(System.in);
        String option= "";
        String value1, value2, value3, value4, value5, value6 = "";
        while( !option.equals("4")){
            System.out.println("##### MENU ##### \n"
                    + "DIGITE A OPÇÃO DESEJADA: \n"
                    + "1 - CADASTRO \n"
                    + "2 - CONSULTA \n"
                    + "3 - VENDA \n"
                    + "4 - SAIR \n");
            option = sc.next();
            System.out.println("\n\n\n");
            
            
            
            
            
            
            // AREA DE CADASTRO
            if(option.equals("1")){
                System.out.println("##### CADASTRO #####");
                System.out.println("##### DIGITE O QUE DESEJA CADASTRAR ##### \n");
                System.out.println("1 - PRODUTO \n"
                    + "2 - CLIENTE \n"
                    + "3 - VENDEDOR \n"
                    + "4 - VOLTAR \n"
                    + "5 - SAIR \n");
                option = sc.next();
               if(option.equals("4")){
                   option = "";
               }
               else if (option.equals("5")){
                   option = "4";
               }
               
               if(option.equals("1")){
                   v.cadastrarProduto();
               }
               if(option.equals("2")){
                   v.cadastrarCliente();
               }
               if(option.equals("3")){
                   v.cadastrarVendedor();
               }  
            }
            
            
            
            
            
            
            // AREA DE CONSULTA
            else if(option.equals("2")){
                System.out.println("##### CONSULTA #####");
                System.out.println("##### DIGITE O QUE DESEJA CONSULTAR ##### \n");
                System.out.println("1 - PRODUTO \n"
                    + "2 - VENDEDOR \n"
                    + "3 - CLIENTE \n"
                    + "4 - VOLTAR \n"
                    + "5 - SAIR \n");
                option = sc.next();
               if(option.equals("4")){
                   option = "";
               }
               else if (option.equals("5")){
                   option = "4";
               }
               else if(option.equals("1")){
                   System.out.println("DIGITE O ID DO PRODUTO: \n");
                   value1 = sc.next();
                   v.ConsultaGeral(value1, "produto");
               }
               else if(option.equals("2")){
                   System.out.println("DIGITE O CPF DO VENDEDOR: \n");
                   value1 = sc.next();
                   v.ConsultaGeral(value1, "vendedor");         
               }
               else if (option.equals("3")){
                   System.out.println("DIGITE O CPF DO CLIENTE: \n");
                   value1 = sc.next();
                   v.ConsultaGeral(value1, "cliente");  
               } 
            }
            
            
            
            
            
            
            
            // AREA DE VENDA
            else if(option.equals("3")){
                System.out.println("##### VENDA #####");
                System.out.println("##### CRIAR VENDA: ##### \n");
                v.vender();
            }
            
            
        }
    }
    
    private void cadastrarProduto(){
        Scanner sc = new Scanner(System.in);
        String option= "";
        String value1, value2, value3, value4, value5, value6 = "";
        System.out.println("DIGITE O ID DO PRODUTO: \n");
        value1 = sc.next();
        System.out.println("DIGITE O NOME DO PRODUTO: \n");
        value2 = sc.next();
        System.out.println("DIGITE O PRECO DO PRODUTO: \n");
        value3 = sc.next();
        System.out.println("DIGITE O QTD_ESTOQUE DO PRODUTO: \n");
        value4 = sc.next();
        System.out.println("É MOSTRUARIO? (S/N): \n");
        value5 = sc.next();
        int id = Integer.parseInt(value1);
        int qtd_estoque = Integer.parseInt(value4);
        double preco = Double.parseDouble(value3);
        boolean mostr = false;
        if(value5.equals("S")){
            mostr = true;
        }
        boolean bool = ctrl.cadastrarProduto(value2,id,preco, qtd_estoque, mostr);
        
        if(bool){
            System.out.println("PRODUTO CADASTRADO COM SUCESSO !!!");
        }
        else{
            System.out.println("ID DO PRODUTO JA EXISTENTE.");
        }
    }
    
    void cadastrarCliente(){
        Scanner sc = new Scanner(System.in);
        String option= "";
        String value1, value2, value3, value4, value5, value6 = "";
        System.out.println("DIGITE O NOME DO CLIENTE: \n");
        value1 = sc.next();
        System.out.println("DIGITE O CPF DO CLIENTE: \n");
        value2 = sc.next();
        System.out.println("DIGITE O ENDERECO DO CLIENTE: \n");
        value3 = sc.next();
        System.out.println("DIGITE O TELEFONE DO CLIENTE: \n");
        value4 = sc.next();
        boolean bool = ctrl.cadastrarCliente(value1,value2, value3, value4);
        if(bool){
            System.out.println("CLIENTE CADASTRADO COM SUCESSO !!!\n");
        }
        else{
            System.out.println("CPF JA EXISTENTE.");
        }
        
    }
    
    void cadastrarVendedor(){
        Scanner sc = new Scanner(System.in);
        String option= "";
        String value1, value2, value3, value4, value5, value6 = "";
        System.out.println("DIGITE O NOME DO VENDEDOR: \n");
        value1 = sc.next();
        System.out.println("DIGITE O CPF DO VENDEDOR: \n");
        value2 = sc.next();
        System.out.println("DIGITE O ENDERECO DO VENDEDOR: \n");
        value3 = sc.next();
        System.out.println("DIGITE O TELEFONE DO VENDEDOR: \n");
        value4 = sc.next();
        System.out.println("DIGITE O SALARIO DO VENDEDOR): \n");
        value5 = sc.next();
        float sal = Float.parseFloat(value5);
        boolean bool = ctrl.cadastrarVendedor(sal, value1, value2, value3, value4);
        if(bool){
            System.out.println("VENDEDOR CADASTRADO COM SUCESSO 1!!!\n");
        }
        else {
            System.out.println("VENDEDOR JA EXISTENTE 1!!!\n");
        }
    }
    
    void ConsultaGeral(String value, String thing){
        if(thing.equals("produto")){
            int id = Integer.parseInt(value);
            Produto pfounded;
            pfounded = ctrl.getProduto(id);
            System.out.println(pfounded);
        }
        if(thing.equals("vendedor")){
            Vendedor vfounded;
            vfounded = ctrl.getVendedor(value);
            System.out.println(vfounded);
        }
        if(thing.equals("cliente")){
            Cliente cfounded;
            cfounded = ctrl.getCliente(value);
            System.out.println(cfounded);
        }
        
    }
    
    
    void vender(){
        try{
            Scanner sc = new Scanner(System.in);
            String value1, value2, value3, value4, value5 = "";
            System.out.println("DIGITE O ID DA VENDA: \n");
            value1 = sc.next();
            System.out.println("DIGITE A DATA DA VENDA (DD-MM-AAAA): \n");
            value2 = sc.next();
            System.out.println("DIGITE O CPF DO VENDEDOR: \n");
            value3 = sc.next();
            System.out.println("DIGITE O ID DO PRODUTO: \n");
            value4 = sc.next();
            System.out.println("DIGITE O CPF DO CLIENTE): \n");
            value5 = sc.next();
            int id_venda = Integer.parseInt(value1);
            int id_produto = Integer.parseInt(value4);
            ctrl.Vender(id_venda, value2, value3, id_produto, value5);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

