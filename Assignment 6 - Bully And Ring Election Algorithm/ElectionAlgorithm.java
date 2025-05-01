import java.util.Scanner;

public class ElectionAlgorithm {
    static final int MAX = 20;
    static int[] pStatus = new int[MAX];
    static int coordinator = 0, n;

    static void display() {
        System.out.print("PROCESS:   ");
        for (int i = 0; i < n; i++) System.out.print((i + 1) + "\t");
        System.out.print("\nALIVE:     ");
        for (int i = 0; i < n; i++) System.out.print(pStatus[i] + "\t");
        System.out.println("\nCOORDINATOR IS: " + (coordinator + 1));  // Displaying as 1-based ID
        System.out.println("---------------------------------------------");
    }

    static void bullyElection(int initiator) {
        int newCoordinator = initiator;
        for (int i = initiator + 1; i < n; i++) {
            if (pStatus[i] == 1) {
                System.out.println("Message sent from " + (initiator + 1) + " to " + (i + 1));
                System.out.println("Response from " + (i + 1) + " to " + (initiator + 1));
                newCoordinator = i;
            }
        }
        coordinator = newCoordinator;
        System.out.println("New Coordinator: " + (coordinator + 1));
    }

    static void ringElection(int initiator) {
        int newCoordinator = initiator;
        for (int i = 1; i < n; i++) {
            int id = (initiator + i) % n;
            if (pStatus[id] == 1 && id > newCoordinator) {
                newCoordinator = id;
            }
            System.out.println("Election message passed from " + (id + 1));
        }
        coordinator = newCoordinator;
        System.out.println("New Coordinator: " + (coordinator + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Is process " + (i + 1) + " alive? (0/1): ");
            pStatus[i] = sc.nextInt();
        }

        // Initial coordinator: highest numbered alive process
        for (int i = n - 1; i >= 0; i--) {
            if (pStatus[i] == 1) {
                coordinator = i;
                break;
            }
        }

        display();

        System.out.println("Choose Algorithm: 1.Bully  2.Ring");
        int algo = sc.nextInt();

        System.out.print("Enter process to crash (1 to " + n + "): ");
        int crash = sc.nextInt();
        pStatus[crash - 1] = 0;

        System.out.print("Enter initiator ID (1 to " + n + "): ");
        int initiator = sc.nextInt() - 1;

        if (algo == 1) bullyElection(initiator);
        else ringElection(initiator);

        display();
        sc.close();
    }
}
