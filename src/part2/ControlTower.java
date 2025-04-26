package part2;

import java.util.LinkedList;
import java.util.Queue;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private boolean runwayAvailable = true;

    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println("ControlTower receives message from " + sender.getId() + ": " + msg);

        if (msg.equals("MAYDAY")) {
            System.out.println("⚠️ EMERGENCY! Clearing runway for " + sender.getId());
            landingQueue.add(sender);
            runwayAvailable = true;
            notifyAllAircraftsHold(sender);
        }
    }

    private void notifyAllAircraftsHold(Aircraft emergencyAircraft) {
        for (Aircraft a : landingQueue) {
            if (!a.equals(emergencyAircraft)) {
                a.receive("Hold position. Emergency in progress.");
            }
        }
        for (Aircraft a : takeoffQueue) {
            a.receive("Hold position. Emergency in progress.");
        }
    }

    @Override
    public boolean requestRunway(Aircraft aircraft) {
        if (!runwayAvailable) {
            System.out.println(aircraft.getId() + " must wait, runway is busy.");
            return false;
        }

        runwayAvailable = false;

        System.out.println("🛬 Runway granted to: " + aircraft.getId());
        return true;
    }

    public void aircraftLandedOrTakenOff() {
        runwayAvailable = true;
    }

    public void requestLanding(Aircraft aircraft) {
        landingQueue.add(aircraft);
    }

    public void requestTakeoff(Aircraft aircraft) {
        takeoffQueue.add(aircraft);
    }

    public void processQueues() {
        if (runwayAvailable) {
            if (!landingQueue.isEmpty()) {
                Aircraft aircraft = landingQueue.poll();
                requestRunway(aircraft);
                System.out.println(aircraft.getId() + " has landed.");
                aircraftLandedOrTakenOff();
            } else if (!takeoffQueue.isEmpty()) {
                Aircraft aircraft = takeoffQueue.poll();
                requestRunway(aircraft);
                System.out.println(aircraft.getId() + " has taken off.");
                aircraftLandedOrTakenOff();
            }
        }
    }
}
