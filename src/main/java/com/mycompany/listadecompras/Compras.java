package com.mycompany.listadecompras;

public class Compras {
    private String name;
    private int quantidade;
    private double valor;
     private String tipo;
    
 
    public Compras(){}
    
    public Compras(String name, int quantidade,  double valor, String tipo){
        this.quantidade = quantidade;
        this.name = name;
        this.valor = valor;
        this.tipo = tipo;
    }
    
      public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
  
    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
   
     public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }
    
       public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
  
      public String ImprimiDados(){
        return "Nome: "  + name + "  Quantidade: " + quantidade + "\n";
    }
      
      public String ConsultaDados(){
        return "Nome: "  + name + "\n" + "Quantidade: " + quantidade + "\n" + "Valor pretendido: " + valor +"R$" + "\n" + "Tipo de produto: " + tipo;
    }
}

