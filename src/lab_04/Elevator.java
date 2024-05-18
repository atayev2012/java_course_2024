package lab_04;
import java.util.LinkedList;

public class Elevator implements Runnable{
    int elevatorId, floorQty, currentPeopleQty, maxPeopleQty;
    public int currentFloor;
    LinkedList<Integer> elevatorQueue;

    // Constructor
     Elevator(int elevatorId, int floorQty, int maxPeopleQty) {
        this.elevatorId = elevatorId;
        this.maxPeopleQty = maxPeopleQty;
        this.currentPeopleQty = 0;
        this.currentFloor = 1;
        this.floorQty = floorQty;
        elevatorQueue = new LinkedList<>();
    }


    public synchronized void addToQueue(int destinationFloor){
         int newWeightage = Math.abs(currentFloor - destinationFloor), positionIndex = 0;

         for (Integer call : elevatorQueue) {
             int currentWeightage = Math.abs( currentFloor - call);
             if (newWeightage < currentWeightage){
                 break;
             }
             positionIndex++;
         }

         elevatorQueue.add(positionIndex, destinationFloor);
    }

    // press button to call the elevator from outside of elevator
    public synchronized void externalElevatorCallButton(int callFloor){
         System.out.println("Elevator id:" + elevatorId + " was called from floor No." + callFloor + "!");

         // if elevator is overloaded
        if (currentPeopleQty == maxPeopleQty) {
            elevatorQueue.addLast(callFloor);
            return;
        }

         if (elevatorQueue.isEmpty()){
             elevatorQueue.addFirst(callFloor);
             return;
         }
         addToQueue(callFloor);
    }

    // press floor number button inside elevator
    public synchronized void internalElevatorCallButton(int callFloor){
        if (currentPeopleQty == 0) {return;}

        System.out.println("Elevator was commanded to go to the floor No." + callFloor + "!");
        if (elevatorQueue.isEmpty()) {
            elevatorQueue.addFirst(callFloor);
            return;
        }

        addToQueue(callFloor);
    }

    public synchronized boolean passengerEnter() {
        if (currentPeopleQty == maxPeopleQty) {
            return false;
        } else {
            System.out.println("Passenger No." + (++currentPeopleQty) + " entered an elevator with id: " + elevatorId);
            return true;
        }
    }

    public synchronized boolean passengerExit() {
        if (currentPeopleQty == 0) {
            return false;
        }else{
            currentPeopleQty--;
            System.out.println("Passenger exited an elevator with id: " + elevatorId + ". Remaining passengers: " + currentPeopleQty);
            return true;
        }
    }

    public void work(){
         if (elevatorQueue.isEmpty()){
             return;
         }

         if (currentFloor == elevatorQueue.peekFirst()){
             elevatorQueue.removeFirst();
             return;
         }

         System.out.println("The elevator with id: " + elevatorId + " is moving. Current floor: " + currentFloor);

         if(currentFloor < elevatorQueue.peekFirst()){
             currentFloor++;
         }else if(currentFloor > elevatorQueue.peekFirst()){
             currentFloor--;
         }
         System.out.println("Current floor: " + currentFloor + " -> Destination: " + elevatorQueue.peekFirst());

          try{
              Thread.sleep(1000);
          }catch(InterruptedException e){
              e.printStackTrace();
          }
    }


    public void run() {
        while (true) {
            if (elevatorQueue.isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
            work();
        }

    }
}
