# RestaurantKitchenSTR

## Assignment 5 – Strategy Pattern

This project demonstrates the Strategy design pattern
in a Restaurant Kitchen system.

The project contains two strategy families:

1. Cooking Strategy
2. Delivery Strategy

---

## Family 1 – Cooking Strategy

Cooking strategies calculate cooking time
using different algorithms.

### CookingStrategy
Defines the common cooking algorithm interface.

### NormalCookingStrategy
Calculates standard cooking time.

### FastCookingStrategy
Calculates cooking time using faster preparation rules.

### BatchCookingStrategy
Groups orders into batches for cooking.

### CookingContext
Executes the selected cooking strategy.

### CookingStrategySelector
Selects a cooking strategy using the order count.

---

## Family 2 – Delivery Strategy

Delivery strategies select a suitable courier
using different conditions.

### DeliveryStrategy
Defines the common courier selection interface.

### NearestDeliveryStrategy
Selects a courier using delivery distance.

### LeastBusyDeliveryStrategy
Selects a courier using courier availability.

### TrafficAwareDeliveryStrategy
Selects a courier using traffic information.

### DeliveryContext
Executes the selected delivery strategy.

### DeliveryStrategySelector
Selects a delivery strategy using current conditions.

---

## External Data Source

### TrafficDataSource
Defines access to traffic information.

### SimulatedTrafficDataSource
Provides simulated traffic information.

TrafficAwareDeliveryStrategy uses TrafficDataSource
instead of directly accessing external data.

Tests can provide fixed traffic values.

---

## Runtime Strategy Switching

Both contexts receive a strategy through the constructor.

The strategy can be replaced at runtime
using the setStrategy() method.

Example:

CookingContext context =
new CookingContext(new NormalCookingStrategy());

context.setStrategy(new FastCookingStrategy());

---

## Automatic Selection

Selectors automatically choose suitable strategies.

CookingStrategySelector uses the number of orders.

DeliveryStrategySelector uses traffic level
plus courier availability.

Conditional selection logic exists in Selector classes,
not inside Context classes.

---

## Why Strategy Pattern?

Strategy is suitable because the system contains
multiple interchangeable algorithms.

Each algorithm implements a common interface.

The Context delegates work to the selected strategy.

A strategy can be replaced at runtime.

New strategies can be added without changing
the Context.

This supports the Open/Closed Principle.

---

## Strategy vs State

Strategy represents interchangeable algorithms
selected for a task.

State represents behavior based on an object's
internal state.

This project needs algorithm selection,
so Strategy is more suitable.

---

## Strategy vs Template Method

Template Method normally uses inheritance
to define an algorithm structure.

Strategy uses composition.

Each algorithm is placed in a separate class
behind a common interface.

Strategy also makes runtime replacement simple.

---

## Testing

JUnit 5 is used for testing.

Tests cover every cooking strategy.

Tests cover every delivery strategy.

Tests cover Selector rules.

A parameterized test checks multiple
CookingStrategy implementations.

Traffic tests use fixed traffic values.

---

## Git Refactoring

The Cooking family demonstrates refactoring
from conditional logic to Strategy.

Before refactoring:
https://github.com/AbdrTabyn/RestaurantKitchenSTR/commits/master/

After refactoring:
https://github.com/AbdrTabyn/RestaurantKitchenSTR/commit/0058a3b9af2baa8d524c0c20225d8857f160f99c
The same behavior is verified before
plus after refactoring.

---

## Main

Main.java demonstrates:

- Same input with different strategies
- Automatic strategy selection
- Manual strategy selection
- Runtime strategy switching
