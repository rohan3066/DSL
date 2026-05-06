import mpi.*;
import java.util.Random;

public class MPIAvg {

    public static void main(String[] args) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int elementsPerProcess = 2;

        int sendBuffer[] = new int[size * elementsPerProcess];
        int receiveBuffer[] = new int[elementsPerProcess];

        double localAverage;
        double gatheredAverages[] = new double[size];

        // Root process generates random array
        if(rank == 0) {

            Random random = new Random();

            System.out.println("Generated Random Array:");

            for(int i = 0; i < sendBuffer.length; i++) {

                sendBuffer[i] = random.nextInt(100);

                System.out.print(sendBuffer[i] + " ");
            }

            System.out.println();
        }

        // Scatter data equally to all processes
        MPI.COMM_WORLD.Scatter(
                sendBuffer,
                0,
                elementsPerProcess,
                MPI.INT,
                receiveBuffer,
                0,
                elementsPerProcess,
                MPI.INT,
                0
        );

        // Display received elements
        System.out.print(
                "Process "
                        + rank
                        + " received: "
        );

        int localSum = 0;

        for(int i = 0; i < elementsPerProcess; i++) {

            System.out.print(receiveBuffer[i] + " ");

            localSum += receiveBuffer[i];
        }

        // Calculate local average
        localAverage =
                (double)localSum / elementsPerProcess;

        System.out.println(
                " Local Average = "
                        + localAverage
        );

        // Gather averages at root
        MPI.COMM_WORLD.Gather(
                new double[]{localAverage},
                0,
                1,
                MPI.DOUBLE,
                gatheredAverages,
                0,
                1,
                MPI.DOUBLE,
                0
        );

        // Root computes final average
        if(rank == 0) {

            double finalAverage = 0;

            System.out.println("\nGathered Averages:");

            for(int i = 0; i < size; i++) {

                System.out.println(
                        "From Process "
                                + i
                                + " : "
                                + gatheredAverages[i]
                );

                finalAverage += gatheredAverages[i];
            }

            finalAverage =
                    finalAverage / size;

            System.out.println(
                    "\nFinal Average = "
                            + finalAverage
            );
        }

        MPI.Finalize();
    }
}