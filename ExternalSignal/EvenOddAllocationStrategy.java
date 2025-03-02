package ExternalSignal;

import Elevator.ElevatorController;

import java.util.List;

public class EvenOddAllocationStrategy implements ExternalSignalAllocationStrategy {

    List<ElevatorController> elevatorControllers;

    public EvenOddAllocationStrategy(List<ElevatorController> elevatorControllers) {
        this.elevatorControllers = elevatorControllers;
    }

    @Override
    public int allocateLift(int targetFloor) {
        // Some strategy to be written
        return 1;
    }
}
