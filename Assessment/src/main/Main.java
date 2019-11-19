package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.face.dao.PlayerDAO;
import com.face.util.ConnectionManager;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException 
	{
		PlayerDAO pdao=new PlayerDAO();//creating object for PlayerDAO class
		ConnectionManager conn=new ConnectionManager();//creating object for ConnectionManager class
		Scanner sc=new Scanner(System.in);//creating object for Scanner class
		do
		{
		System.out.println("Menu");//displaying the menu
		System.out.println("1.List all players");
		System.out.println("2.Add new player");
		System.out.println("3.Search plyer");
		System.out.println("Enter your option");
		int option=sc.nextInt();
		switch(option)
		{
		case 1:
			System.out.println("Player Details");
			pdao.display(conn.getConnection());//calling the display function
			break;
			
		case 2:
			Player pl=new Player();//calling the constructor
			break;
			
		case 3:
			
			pdao.search(conn.getConnection());//calling the search method
		}

	}while(true);

}}
