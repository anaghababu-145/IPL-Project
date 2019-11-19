package com.face.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.face.bo.PlayerBO;


public class PlayerDAO 
{
	public static boolean insert(Connection connection,PlayerBO plbo) throws SQLException//method for data insertion
	   {
		   Statement st=connection.createStatement();
		   String query="insert into player(player_name,player_country,skill,team) values('"+plbo.getPlayerName()+"','"+plbo.getCountry()+"','"+plbo.getSkillns()+"','"+plbo.getTeamlns()+"')";
	       int resultset=st.executeUpdate(query);
	       boolean status;
		if(resultset==1)
	       {
	    	   System.out.println("Data inserted successfully");
	    	   status=true;
	       }
	       else
	       {
	    	   System.out.println("Please check");
	    	   status=false;
	       }
		return status;
	   
	   }
	
	public void display(Connection connection) throws SQLException//method for display
	{
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery("select * from player");
		System.out.println("Player Name"+"\t\t"+"Player Country"+"\t\t"+"Skill"+"\t\t"+"Team");
		System.out.println("-------------------------------------------------------------------------------");
		while(rs.next())
		{
			
			System.out.println(rs.getString("player_name")+"\t\t"+rs.getString("player_country")+"\t\t\t"+rs.getString("skill")+"\t\t"+rs.getString("team"));
		}
	}
	
	public void search(Connection connection) throws SQLException//method for search
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter skill");
		String skilll=sc.next();
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery("select * from player");
		while(rs.next())
		{
			if(rs.getString("skill").equalsIgnoreCase(skilll))
			{
		
			System.out.println(rs.getString("player_name")+"\t"+rs.getString("player_country")+"\t"+rs.getString("skill")+"\t"+rs.getString("team"));
		}
	}
		
	}
}
