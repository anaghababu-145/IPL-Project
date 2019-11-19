package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.face.bo.PlayerBO;
import com.face.dao.PlayerDAO;
import com.face.util.ConnectionManager;

public class Player 
{
	String playerName;
	String country;
	 String skillns;
	 String teamlns;

	 Scanner sc=new Scanner(System.in);
	 ConnectionManager conn=new ConnectionManager();
public Player() throws ClassNotFoundException, SQLException, IOException
{
	
	System.out.println("Enter the player name");
	playerName=sc.next();
	System.out.println("Enter the country name");
	country=sc.next();
	System.out.println("Enter the skill");
	skillns=sc.next();
	System.out.println("Enter the team name");
	teamlns=sc.next();
	
	PlayerBO plbo=new PlayerBO();
	plbo.setPlayerName(playerName);
	plbo.setCountry(country);
	plbo.setSkillns(skillns);
	plbo.setTeamlns(teamlns);
	
	PlayerDAO pdao=new PlayerDAO();
	pdao.insert(conn.getConnection(),plbo);
}

public Player(String playerName,String country,String skill,String team)
{
	
}

}