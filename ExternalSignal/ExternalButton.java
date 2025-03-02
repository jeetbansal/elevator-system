package ExternalSignal;

import SignalDispatcher.SignalDispatcher;
public class ExternalButton {

    private SignalDispatcher signalDispatcher;

    private ExternalSignalAllocationStrategy externalSignalAllocationStrategy;

    public ExternalButton(SignalDispatcher signalDispatcher, ExternalSignalAllocationStrategy externalSignalAllocationStrategy) {
        this.signalDispatcher = signalDispatcher;
        this.externalSignalAllocationStrategy = externalSignalAllocationStrategy;
    }

    public void pressButton(int targetFloor) {
        int liftId = externalSignalAllocationStrategy.allocateLift(targetFloor);
        signalDispatcher.sendRequest(liftId, targetFloor);
    }

}
