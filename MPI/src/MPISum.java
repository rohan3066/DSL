import mpi.*;

public class MPISum {

    public static void main(String[] args) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int sendArray[] = new int[size];
        int recvArray[] = new int[1];

        // Root process initializes array
        if(rank == 0) {

            System.out.println("Root process initializing array:");

            for(int i = 0; i < size; i++) {
                sendArray[i] = (i + 1) * 10;

                System.out.println(
                        "Element for Process " + i +
                                " : " + sendArray[i]
                );
            }
        }

        // Scatter one element to each process
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

        // Calculate intermediate sum
        int intermediateSum = 0;

        for(int i = 0; i <= rank; i++) {
            intermediateSum += localValue;
        }

        System.out.println(
                "Process " + rank +
                        " received value : " + localValue +
                        " Intermediate Sum : " + intermediateSum
        );

        MPI.Finalize();
    }
}