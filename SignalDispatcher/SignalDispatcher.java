package SignalDispatcher;

import Elevator.ElevatorController;

import java.util.List;
import java.util.Optional;

public class SignalDispatcher {

    private List<ElevatorController> elevatorControllers;

    public SignalDispatcher(List<ElevatorController> elevatorControllers) {
        this.elevatorControllers = elevatorControllers;
    }

    public void sendRequest(int liftId, int targetFloor) {
        Optional<ElevatorController> targetElevatorController = elevatorControllers.stream()
                .filter(elevatorController -> elevatorController.getElevatorCar().getId() == liftId)
                .findFirst();
        targetElevatorController.ifPresent(elevatorController -> elevatorController.addRequest(targetFloor));
    }
}
