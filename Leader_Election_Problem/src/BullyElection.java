import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BullyElection {
    static int n;
    static int processes[];
    static int coordinator;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Processes :");
        n=sc.nextInt();
        processes=new int[n];

        for(int i =0;i<n;i++){
            processes[i]=1;
        }

        System.out.println("Current processes are : ");

        for(int i=0;i<n;i++){
            System.out.print("P"+(i+1)+" ");
        }
        System.out.println();

        coordinator=n;
        System.out.println("Initial Coordinator is P"+coordinator);

        System.out.print("Which process wants to fail :");
        int fail=sc.nextInt();
        processes[fail-1]=0;
        System.out.println("Process P"+fail+" fail...");

        System.out.print("Which process wants to initiator :");
        int initiator=sc.nextInt();
        election(initiator);
        sc.close();

    }

    public static void election(int initiator){
        for(int i=initiator;i<n;i++){
            if(processes[initiator]==1){
                System.out.println("P"+initiator+" sends ELECTION msg to P"+(i+1));
                System.out.println("P"+(i+1)+" send OK msg to Initiator P"+initiator);
                election(i+1);
                return;
            }
        }
        coordinator=initiator;
        System.out.println("Process P"+coordinator+" become new coordinator");

        for(int i=0;i<n;i++){
            if(i+1!=coordinator && processes[i]!=0){
                System.out.println("P"+coordinator+" sends coordinator msg to P"+(i+1));
            }
        }


    }
}