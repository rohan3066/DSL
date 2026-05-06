import java.util.Scanner;

public class TokenRingElection {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter no of process :");
        int n=sc.nextInt();
        int process[]=new int[n];
        boolean active[]=new boolean[n];

        for(int i=0;i<n;i++){
            process[i]=i+1;
            active[i]=true;
        }

        System.out.print("Processes in Ring :");
        for(int i=0;i<n;i++){
            System.out.print("P"+process[i]+" ");
        }
        System.out.println();
        int coordinator=n;
        System.out.println("Initial Coordinator P"+coordinator);

        System.out.print("Enter process want to crash :");
        int crash=sc.nextInt();
        active[crash-1]=false;
        System.out.println("Process P"+crash+" crashed.........");

        System.out.print("Choose new initiator :");
        int initiator=sc.nextInt();
        int current=initiator-1;
        String ele_msg="";

        do {
            if(active[current]){
                ele_msg+="P"+(current+1)+" ";
                int next=(current+1)%n;
                while(!active[next]){
                    next=(next+1)%n;
                }
                System.out.println("P"+process[current]+"----->ELECTION MSG----->P"+process[next]);

            }
            current=(current+1)%n;

        }while(current!=initiator-1);

        int newCoordinator=-1;
        for(int i=0;i<n;i++){
            if(active[i]){
                newCoordinator=Math.max(newCoordinator,process[i]);
            }

        }

        System.out.println("Processes in election msg :"+ele_msg);
        System.out.println("New coordinator process P:"+newCoordinator);

        current=newCoordinator-1;

        do{
            int next = (current+1)%n;
            while(!active[next]){
                next=(next+1)%n;
            }
            if(process[current]!=newCoordinator){
                System.out.println("P"+newCoordinator+" Coordinator sends msg to P"+process[current]);

            }

            current=next;


        }while (current!=newCoordinator-1);




    }
}
