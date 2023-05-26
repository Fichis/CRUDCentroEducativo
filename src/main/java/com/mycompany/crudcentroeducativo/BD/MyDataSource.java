/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudcentroeducativo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pc
 */
public class MyDataSource {
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/centroeducativo";
    private static final String user="usercentroeducativo";
    private static final String pass="Adolfo22";
    private static Connection cn;
    
    static{
        try{
            cn=DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    
    public static Connection getConnection(){
        try{
            if(cn==null || cn.isClosed()){
                cn=DriverManager.getConnection(url,user,pass);
            }
            
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
        return cn;
    }
}
