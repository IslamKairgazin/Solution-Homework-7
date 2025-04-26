package part2;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        Random random = new Random();

        Aircraft[] aircrafts = new Aircraft[10];

        for (int i = 0; i < 10; i++) {
            int fuel = random.nextInt(100) + 1;
            if (i % 3 == 0) {
                aircrafts[i] = new PassengerPlane("PassengerPlane-" + i, fuel);
            } else if (i % 3 == 1) {
                aircrafts[i] = new CargoPlane("CargoPlane-" + i, fuel);
            } else {
                aircrafts[i] = new Helicopter("Helicopter-" + i, fuel);
            }
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(() -> {
            Aircraft aircraft = aircrafts[random.nextInt(aircrafts.length)];
            if (aircraft.getFuelLevel() < 20) {
                aircraft.send("MAYDAY", tower);
                tower.requestLanding(aircraft);
            } else {
                if (random.nextBoolean()) {
                    tower.requestLanding(aircraft);
                    System.out.println(aircraft.getId() + " requesting landing.");
                } else {
                    tower.requestTakeoff(aircraft);
                    System.out.println(aircraft.getId() + " requesting takeoff.");
                }
            }
            tower.processQueues();
        }, 0, 2, TimeUnit.SECONDS);

        executor.schedule(() -> {
            executor.shutdown();
            System.out.println("Simulation ended.");
        }, 30, TimeUnit.SECONDS);
    }
}
