import mpi.*;

public class MPIMulti {

    public static void main(String[] args) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int sendArray[] = new int[size];
        int recvArray[] = new int[1];

        // Root process initializes array
        if(rank == 0) {

            System.out.println("Root Process Initializing Array:");

            for(int i = 0; i < size; i++) {

                sendArray[i] = i + 2;

                System.out.println(
                        "Element for Process "
                                + i
                                + " : "
                                + sendArray[i]
                );
            }
        }

        // Scatter elements to all processors
        MPI.COMM_WORLD.Scatter(
                sendArray,
                0,
                1,
                MPI.INT,
                recvArray,
                0,
                1,
                MPI.INT,
                0
        );

        int localValue = recvArray[0];

        // Calculate intermediate multiplication
        int multiplication = 1;

        for(int i = 0; i <= rank; i++) {
            multiplication *= localValue;
        }

        // Display result
        System.out.println(
                "Process "
                        + rank
                        + " received value : "
                        + localValue
                        + " Intermediate Multiplication : "
                        + multiplication
        );

        MPI.Finalize();
    }
}