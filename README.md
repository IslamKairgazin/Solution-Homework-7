# Solution Homework 7: Iterator and Mediator Patterns

## Part 1 – Streaming Service Binge Mode

This part implements the **Iterator** design pattern for a TV series structure.

- **Episode**: Represents a single episode with a title and runtime.
- **Season**: Stores episodes and supports multiple traversal orders:
  - Normal order (SeasonIterator)
  - Reverse order (ReverseSeasonIterator)
  - Shuffle order with fixed seed (ShuffleSeasonIterator)
- **Series**: Contains multiple seasons.
- **BingeIterator**: Chains episodes across all seasons to allow continuous watching.

The `Season` class implements `Iterable<Episode>`, allowing use of `for-each` loops.

**Why Iterator Pattern?**  
Iterator hides the internal structure of collections and provides a consistent way to traverse episodes, regardless of how they are stored (ArrayList, LinkedList, etc).

---

## Part 2 – Airport Tower Simulator

This part implements the **Mediator** design pattern for aircraft communication.

- **Aircraft (abstract)**: Base class for all aircraft (PassengerPlane, CargoPlane, Helicopter).
- **TowerMediator (interface)**: Defines communication methods.
- **ControlTower**: Manages landing and takeoff queues, handles emergencies (MAYDAY).
- Aircraft send messages through the control tower instead of communicating directly.

**Why Mediator Pattern?**  
Mediator centralizes complex communication logic between aircraft and prevents direct dependencies between them.

---

## Conclusion

This project demonstrates the practical use of two important design patterns: Iterator and Mediator.

In Part 1, the Iterator pattern allows flexible and uniform traversal over different internal collections, enabling the UI to interact with episodes without depending on how they are stored.

In Part 2, the Mediator pattern effectively manages complex communication between multiple aircraft, reducing coupling and centralizing control logic inside the Control Tower.

Using these patterns improves modularity, maintainability, and scalability of the application.  
However, a potential downside is that additional abstraction layers can increase project complexity and require more careful design planning.
