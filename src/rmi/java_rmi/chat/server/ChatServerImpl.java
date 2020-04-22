package rmi.java_rmi.chat.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import rmi.java_rmi.inf.ChatClient;
import rmi.java_rmi.inf.ChatServer;


public class ChatServerImpl extends UnicastRemoteObject implements ChatServer{
   
   Vector<ChatClient> clientList = new Vector<>();
   
   public static void main(String[] args) {
      try {
         ChatServer chatServer = new ChatServerImpl();
         
         Registry reg = LocateRegistry.createRegistry(8888);
         reg.rebind("chatServer", chatServer);
         
         System.out.println("서버 실행중");
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   
   public ChatServerImpl() throws RemoteException {
      super();
   }
   
   @Override
   public void addClient(ChatClient client, String name) throws RemoteException {
      
      clientList.add(client);
      
      say(name + "님이 접속하셨습니다.");
      
      System.out.println("새로운 접속자 추가됨 : " + clientList.size());
      
   }
   
   @Override
   public void disconnect(ChatClient client, String name) throws RemoteException {
      
      int i = clientList.indexOf(client);
      
      if(i>=0) {
         say(name + "님이 퇴장하셨습니다.");
         clientList.removeElementAt(i);
         System.out.println("사용자가 나갔습니다." + clientList.size());
      }else {
         System.out.println("해당 사용자가 존재하지 않습니다.");
      }
      
   }
   
   @Override
   public void say(String message) throws RemoteException {
      int numOfConnect = clientList.size();
      
      for(int i = 0 ; i < numOfConnect; i++) {
         ((ChatClient) clientList.elementAt(i)).printMessage(message);
      }
      
   }
   
}