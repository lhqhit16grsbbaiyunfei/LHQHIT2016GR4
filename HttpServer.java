package service.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class HttpServer {
	 public static int add(int a,int b){
		 int c = 0;
		 c= a+b;
		return c;}
	 public static int mult(int a,int b){
		 int c = 0;
		 c= a*b;
		return c;}	 
	 public static int division(int a,int b){
			 int c = 0;
			 c= a/b;
			return c;}
	 public static int subtraction(int a,int b){
		 int c = 0;
		 c= a-b;
		return c;}
    public static void main(String[] args) {
        
        try {
            // ����8080�˿�
            ServerSocket server = new ServerSocket(80);
            
            
            while (1 == 1) {
                // ���տͻ�����������
                Socket socket = server.accept();
                HttpServer s = new HttpServer();
         
                // ��ȡ
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // д��
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                
                String line = input.readLine();
                
                while (line != null) {
                    System.out.println(line);
                    
                    output.flush();
                    line = input.readLine();
                    return;
                }
                //����ر�
                input.close();
                output.close();
                
                socket.close();
            }
        } catch (IOException e) {
           System.out.println("Error binding the specified port.");
        }
    }
   
}