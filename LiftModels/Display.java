package LiftModels;

import LiftModels.LiftMovement;

public class Display {

    int currentFloor;
    LiftMovement liftMovement;

    public Display() {
        currentFloor = 0;
        liftMovement = LiftMovement.IDLE;
    }

}
