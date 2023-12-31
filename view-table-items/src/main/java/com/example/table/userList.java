package com.example.table;

import java.util.ArrayList;
import java.util.List;

public class userList {
	
	List<User> users = new ArrayList<User>();
	
	userList(){
		addUsers();
		printListOfUsers();
	}
	
	public void addUsers() {

		users.add(new User("Tiger Nixon","System Architect","tnixon12@example.com",61,"Edinburgh","$320,800"));
		users.add(new User("Sonya Frost","System Administrator","sonaya@example.com",21,"London","$120,800"));
		users.add(new User("Jena Gaines","Office Manager","jena@example.com",31,"New Castle","$400,900"));
		users.add(new User("Quinn Flynn","Support Lead","quinn@example.com",42,"Southampton","$300,900"));
		users.add(new User("Haley Kennedy","Senior Marketing Designer","hkennedy63@example.com",52,"Southampton","$313,500"));
	}
	
	List<User> printListOfUsers(){
		return users;
	}

	@Override
	public String toString() {
		return "userList [users=" + users + "]";
	}
	
}
