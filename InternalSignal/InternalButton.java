package InternalSignal;

import SignalDispatcher.SignalDispatcher;

public class InternalButton {

    private SignalDispatcher signalDispatcher;

    public InternalButton(SignalDispatcher signalDispatcher) {
        this.signalDispatcher = signalDispatcher;
    }

    public void pressButton(int liftId, int targetFloor) {
        signalDispatcher.sendRequest(liftId, targetFloor);
    }
}
