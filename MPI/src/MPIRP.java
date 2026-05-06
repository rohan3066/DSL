import mpi.*;

public class MPIRP {

    public static void main(String[] args) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int sendArray[] = new int[size];

        int receiveBuffer[] = new int[1];

        double reciprocal;

        double resultArray[] = new double[size];

        // Root process initializes array
        if(rank == 0) {

            System.out.println("Root Process Initializing Array:");

            for(int i = 0; i < size; i++) {

                sendArray[i] = (i + 1) * 2;

                System.out.print(sendArray[i] + " ");
            }

            System.out.println();
        }

        // Scatter one element to each process
        MPI.COMM_WORLD.Scatter(
                sendArray,
                0,
                1,
                MPI.INT,
                receiveBuffer,
                0,
                1,
                MPI.INT,
                0
        );

        int localValue = receiveBuffer[0];

        // Calculate reciprocal
        reciprocal = 1.0 / localValue;

        System.out.println(
                "Process "
                        + rank
                        + " received value : "
                        + localValue
                        + " Reciprocal : "
                        + reciprocal
        );

        // Gather reciprocals at root
        MPI.COMM_WORLD.Gather(
                new double[]{reciprocal},
                0,
                1,
                MPI.DOUBLE,
                resultArray,
                0,
                1,
                MPI.DOUBLE,
                0
        );

        // Root displays resultant array
        if(rank == 0) {

            System.out.println("\nResultant Reciprocal Array:");

            for(int i = 0; i < size; i++) {

                System.out.print(
                        resultArray[i] + " "
                );
            }

            System.out.println();
        }

        MPI.Finalize();
    }
}