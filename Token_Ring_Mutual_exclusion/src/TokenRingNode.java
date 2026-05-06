import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TokenRingNode {
    private int myPort;
    private int nextPort;
    private Boolean hasToken;

    public TokenRingNode(int myPort,int nextPort,Boolean hasToken){
        this.myPort=myPort;
        this.nextPort=nextPort;
        this.hasToken=hasToken;
    }

    public void startNode() throws Exception{
        ServerSocket serverSocket = new ServerSocket(myPort);
        System.out.println("Node Started at port "+myPort);

        new Thread(()->{
            try{
                while(true){
                    Socket socket = serverSocket.accept();
                    BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String token = bf.readLine();

                    if("TOKEN".equals(token)){
                        System.out.println("\nPort "+myPort+" received TOKEN");
                        enterCriticalSection();
                        sendToken();

                    }
                    socket.close();
                }

            }catch (Exception e){
                e.printStackTrace();

            }
        }).start();

        if(hasToken){
            Thread.sleep(2000);
            sendToken();
        }


    }


    public void enterCriticalSection(){
        try{
            System.out.println("Port "+myPort + " ENTERING CRITICAL SECTION");
            Thread.sleep(3000);
            System.out.println("Port "+ myPort + " EXITING CRITICAL SECTION ");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  void sendToken() throws IOException {
        try {
            Socket socket =new Socket("Localhost",nextPort);
            PrintWriter pw =new PrintWriter(socket.getOutputStream(),true);
            System.out.println("Port "+myPort+ " Sending Token to port "+nextPort);
            pw.println("TOKEN");
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws Exception {
        if(args.length<3){
            System.out.println("USAGES: Java TokenRingNode uses argument <myPort> <nextPort> <hasToken>");

        }

        int myPort=Integer.parseInt(args[0]);
        int nextPort=Integer.parseInt(args[1]);
        Boolean hasToken=Boolean.parseBoolean(args[2]);
       TokenRingNode tokenRingNode=new  TokenRingNode(myPort,nextPort,hasToken);
       tokenRingNode.startNode();



    }
}