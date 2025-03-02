package Elevator;

import LiftModels.Display;
import LiftModels.LiftMovement;

public class ElevatorCar {

    private int id;
    private LiftMovement liftMovement;
    private Display display;
    private int currentFloor;

    public int getId() {
        return id;
    }

    public void setLiftMovement(LiftMovement liftMovement) {
        this.liftMovement = liftMovement;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public LiftMovement getLiftMovement() {
        return liftMovement;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
