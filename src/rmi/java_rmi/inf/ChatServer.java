package rmi.java_rmi.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.java_rmi.inf.ChatClient;

public interface ChatServer extends Remote{

	// 사용자 추가
	public void addClient(ChatClient client, String name) throws RemoteException;
	public void disconnect(ChatClient client, String name) throws RemoteException;
	public void say(String message) throws RemoteException;
	
	
	
	
}
