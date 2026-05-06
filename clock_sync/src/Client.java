import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try{
            Socket socket= new Socket("127.0.0.1",5000);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos= new DataOutputStream(socket.getOutputStream());
            String msg= dis.readUTF();

            if(msg.equals("SEND_TIME")){
                Thread.sleep(2000);

                long clientTime=System.currentTimeMillis();
                System.out.println("Client Time :"+clientTime);

                dos.writeLong(clientTime);

                long offset=dis.readLong();

                long newTime=clientTime+offset;
                System.out.println("Adjusted Client time : "+newTime);

            }

            socket.close();
            Thread.sleep(5000);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
