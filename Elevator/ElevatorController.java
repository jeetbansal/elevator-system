package Elevator;

import LiftModels.LiftMovement;

import java.util.Collections;
import java.util.PriorityQueue;

public class ElevatorController {

    ElevatorCar elevatorCar;
    PriorityQueue<Integer> moveUp;
    PriorityQueue<Integer> moveDown;

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        moveUp = new PriorityQueue<>();
        moveDown = new PriorityQueue<>(Collections.reverseOrder());
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void runLift() {
        // If lift is idle, and requests are there (default is up if both have requests, ideally should be through timestamps)
        if (elevatorCar.getLiftMovement().equals(LiftMovement.IDLE)) {
            if (!moveUp.isEmpty()) {
                elevatorCar.setLiftMovement(LiftMovement.UP);
                runLift();
            }
            else if (!moveDown.isEmpty()) {
                elevatorCar.setLiftMovement(LiftMovement.DOWN);
                runLift();
            }
        }

        // If lift is going up
        else if (elevatorCar.getLiftMovement().equals(LiftMovement.UP)) {
            while (!moveUp.isEmpty()) {
                int nextFloor = moveUp.poll();
                System.out.println("Moving up to floor " + nextFloor);
                System.out.println("Reached floor " + nextFloor);
                elevatorCar.setCurrentFloor(nextFloor);
            }
            if (!moveDown.isEmpty()) {
                elevatorCar.setLiftMovement(LiftMovement.DOWN);
                runLift();
            }
            else {
                elevatorCar.setLiftMovement(LiftMovement.IDLE);
            }
        }

        // If lift is going down
        else if (elevatorCar.getLiftMovement().equals(LiftMovement.DOWN)) {
            while (!moveDown.isEmpty()) {
                int nextFloor = moveDown.poll();
                System.out.println("Going down to floor " + nextFloor);
                System.out.println("Reached floor " + nextFloor);
                elevatorCar.setCurrentFloor(nextFloor);
            }
            if (!moveUp.isEmpty()) {
                elevatorCar.setLiftMovement(LiftMovement.UP);
                runLift();
            }
            else {
                elevatorCar.setLiftMovement(LiftMovement.IDLE);
            }
        }
    }

    public void addRequest(int targetFloor) {
        LiftMovement currentMovement = elevatorCar.getLiftMovement();

        // If lift is going up
        if (currentMovement.equals(LiftMovement.UP)) {
            // If target floor is yet to come
            if (targetFloor > elevatorCar.getCurrentFloor()) {
                moveUp.add(targetFloor);
            }
            // If target floor is down
            else {
                moveDown.add(targetFloor);
            }
        }

        // If lift is going down
        else if (currentMovement.equals(LiftMovement.DOWN)) {
            // If target floor is yet to come
            if (targetFloor < elevatorCar.getCurrentFloor()) {
                moveDown.add(targetFloor);
            }
            // If target floor is up
            else {
                moveUp.add(targetFloor);
            }
        }

        // If lift is idle
        else {
            // If target floor is up
            if (targetFloor > elevatorCar.getCurrentFloor()) {
                moveUp.add(targetFloor);
            }
            // If target floor is down
            else {
                moveDown.add(targetFloor);
            }
            runLift();
        }
    }
}
