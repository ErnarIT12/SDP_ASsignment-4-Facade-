# CarWashSystem

A Java car wash simulation using the Facade pattern. `Main` calls only `CarWashFacade.washCar()`, which coordinates four subsystems: water, soap, brushes, and dryer.

A wash uses 50 liters of water and 100 milliliters of soap. The subsystems track whether the car is wet, soaped, cleaned, and rinsed, and check the order of operations. They remain independent of the facade and can also be used directly.

## Clean Code Principles

- **Meaningful names:** Methods such as `applySoap()` and `rinseCar()` explain their purpose. Resource names include their units.
- **Single Responsibility:** Each subsystem handles its own operation and state. The facade only coordinates the process.
- **Encapsulation:** Private fields protect resource amounts and progress from direct changes.
- **Small public API:** The client starts the complete process with `washCar()` without managing the subsystems.
- **Small methods:** Each method performs one clear action, making the code easy to follow.
- **Error handling:** Invalid amounts, insufficient resources, and incorrect operation order produce exceptions. Both supplies are checked before starting.
- **Named constants:** Water and soap doses are defined once instead of repeating numbers.

The facade resets progress in `finally` after each wash attempt while keeping the remaining supplies. Direct clients reset the three stateful subsystems before the next car.
