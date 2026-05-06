import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started at local host........");

            Socket socket = serverSocket.accept();
            System.out.println("Connected to server.....");

            DataInputStream dis=new DataInputStream(socket.getInputStream());
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());

            long serverTime=System.currentTimeMillis();
            System.out.println("Server time: "+serverTime);

            dos.writeUTF("SEND_TIME");


            long clientTime=dis.readLong();
            System.out.println("Client time : "+clientTime);

            long avgTime=(serverTime+clientTime)/2;

            System.out.println("Average time :"+avgTime);

            long clientOffset=avgTime-clientTime;
            long serverOffset=avgTime-serverTime;

            dos.writeLong(clientOffset);


            long newServerTime=serverTime+serverOffset;

            System.out.println("Adjusted server time :"+newServerTime);
            socket.close();
//            serverSocket.close();

            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}