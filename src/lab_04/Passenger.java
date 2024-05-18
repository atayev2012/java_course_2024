package lab_04;

public  class Passenger implements Runnable {
    int callFloor, destination;
    Elevator lift;

    Passenger(int callFloor, int destination, Elevator elevator) {
        this.callFloor = callFloor;
        this.destination = destination;
        this.lift = elevator;
    }

    public void run() {

        // Call Elevator to come take passenger
        lift.externalElevatorCallButton(callFloor);
        while (lift.currentFloor != callFloor) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }

        // Passenger enters elevator
        while (!lift.passengerEnter()) {
            try {
                Thread.sleep(2000);
                lift.externalElevatorCallButton(callFloor);
            } catch (InterruptedException e) {
                return;
            }
        }

        // Passenger call from inside elevator
        lift.internalElevatorCallButton(destination);

        while (lift.currentFloor != destination) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }

        // Passenger leaves the elevator
        if (!lift.passengerExit()){
            System.out.println("Passenger cannot exit the elevator with id: " + lift.elevatorId + " ,because it is empty!");
        }
    }

}