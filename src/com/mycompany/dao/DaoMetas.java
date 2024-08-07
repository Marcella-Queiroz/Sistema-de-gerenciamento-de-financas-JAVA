package com.mycompany.dao;

import com.mycompany.utilidades.BancoDeDadosMySql;
import java.sql.ResultSet;

public class DaoMetas extends BancoDeDadosMySql {
    private String sql;
    
    public Boolean inserir(String nome, Double valor,int meses, String data_inicial){
    try{
        sql = "INSERT INTO METAS (NOME, VALOR,MESES, DATA_INICIAL, VALOR_DEPOSITADO) VALUES (?,?,?,?,0)";
        
         setStatement(getConexao().prepareStatement(sql));
         
         getStatement().setString(1, nome);
         getStatement().setDouble(2, valor);
         getStatement().setInt(3, meses);
         getStatement().setString(4, data_inicial);
         
         getStatement().executeUpdate();
         
         return true;
         
    }catch(Exception e){
        System.err.println(e.getLocalizedMessage());
        
        return false;
    }
}
    public int buscarProximoID(){
        int id =0;
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM METAS";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
public ResultSet ListarTodos(){
    try{
        sql = "SELECT ID, NOME, VALOR, MESES, DATA_INICIAL, VALOR_DEPOSITADO FROM METAS";

        setStatement(getConexao().prepareStatement(sql));
        
         setResultado(getStatement().executeQuery());  
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return getResultado();
}
   
    public ResultSet listarPorId(int id){
    try{
        sql = "SELECT ID, NOME, VALOR, MESES, DATA_INICIAL, VALOR_DEPOSITADO FROM METAS WHERE ID = ?";
            
        setStatement(getConexao().prepareStatement(sql));
            
        getStatement().setInt(1, id);
        
            
        setResultado(getStatement().executeQuery());
    }catch(Exception e){
            System.out.println(e.getMessage());
      }
        return getResultado();
    }
    public ResultSet ListarPorNome(String nome){
    try{
        sql = "SELECT ID, NOME, VALOR, MESES, DATA_INICIAL, VALOR_DEPOSITADO FROM METAS WHERE NOME LIKE ?";
        
        setStatement(getConexao().prepareStatement(sql));
        
        getStatement().setString(1, nome+ "%");
        
        setResultado(getStatement().executeQuery());
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    return getResultado();
    }
    
    public Boolean alterar(int ID, String nome, Double valor,int meses, String data_inicial ){
        try{
            sql = "UPDATE METAS SET NOME = ?, VALOR = ?,MESES = ?,DATA_INICIAL = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            getStatement().setInt(5,ID);
            getStatement().setString(1, nome);
            getStatement().setDouble(2, valor);
            getStatement().setInt(3, meses);
            getStatement().setString(4, data_inicial);
            
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterarValorDepositado(int ID, Double valorDepositado){
        try{
            sql = "UPDATE METAS SET VALOR_DEPOSITADO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            getStatement().setInt(2,ID);
            getStatement().setDouble(1, valorDepositado);
            
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    public Boolean excluir (int id ){
     try{
         sql = "DELETE FROM METAS WHERE ID = ?";
         setStatement(getConexao().prepareCall(sql));
         getStatement().setInt(1, id);
         getStatement().executeUpdate();
         
         return true;
     }catch(Exception e){
         System.out.println(e.getMessage());
         return false;
     }
     
    }
}
