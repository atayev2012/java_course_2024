package lab_04;
import java.util.Random;

public class Main {
    static int totalFloors = 4;
    private static final int elevatorQty = 2, maxPeopleQty = 6;
    static Elevator[] elevators;

    public static void main(String[] args) {
        placeElevators(elevatorQty, maxPeopleQty);
        randomPassengerGenerator();
        programTerminator();
    }

    // listen for ENTER to exit the program
    private static void programTerminator() {
        Thread listener = new Thread(() -> {
            try {
                System.in.read();
            } catch (Exception ignored) {
            }
            System.exit(0);
        });
        listener.start();
    }

    public static void randomPassengerGenerator() {
        Thread generator = new Thread(() -> {
            Random randNum = new Random();
            while (true) {
                Passenger p = new Passenger(randNum.nextInt(totalFloors) + 1, randNum.nextInt(totalFloors) + 1,
                        elevators[randNum.nextInt(elevators.length)]);
                Thread thread = new Thread(p);
                thread.start();

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        generator.start();
    }

    public static void placeElevators(int elevatorQty, int peopleQty) {
        elevators = new Elevator[elevatorQty];
        for (int i = 0; i < elevatorQty; i++) {
            Elevator newElevator = new Elevator(i + 1, totalFloors, peopleQty);
            elevators[i] = newElevator;

            Thread thread = new Thread(newElevator);
            thread.start();
        }
    }

}
