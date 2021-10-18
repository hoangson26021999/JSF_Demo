package synergix.jsf_demo_2;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.inject.Named;

public class PhaseListener implements javax.faces.event.PhaseListener {
    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        System.out.println("After phase" + phaseEvent.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        System.out.println("Before phase" + phaseEvent.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
