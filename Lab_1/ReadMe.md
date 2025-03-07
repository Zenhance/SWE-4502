# Ridoo

A Java Console Application for Ride Sharing.
This is a simple design project more of a lab-task
for the course `Design Patterns` at `Islamic University of
Technology (IUT), Bangladesh`.

## Features
- [x] Register a new user
- [x] Request a ride with a specific car type
  - [x] CarPool
  - [x] Luxury Car
  - [x] Bike
- [x] Accept a ride request
- [x] Start a ride
- [x] End a ride
- [x] Rate a ride
- [x] Payment Through Different Methods
  - [x] Cash
  - [x] Credit Card
  - [x] Digital Wallet
  - [x] Card

## File Structure
```
Ridoo
├── src
│   ├── Application
│   │   ├── DemoSleep.java
│   │   ├── Driver.java
│   │   ├── Rider.Java
│   │   ├── Trip.java
│   │   
│   ├── Factory
│   │   ├── PaymentFactory.java
│   │   ├── RiderFactory.java
│   │   ├── TripFactory.java
│   │   ├── RatingFactory.java
│   │
│   ├── Manager
│   │   ├── DriverManager.java
│   │   
│   ├── Payment
│   │   ├── CashPayment.java
│   │   ├── CardPayment.java
│   │   ├── WalletPayment.java
│   │   ├── PaypalPayment.java
│   │   ├── Payment.java <<Interface>>
│   │
│   ├── RideType
│   │   ├── BikeRide.java
│   │   ├── CarPool.java
│   │   ├── LuxuryCar.java
│   │   ├── RideType.java <<Interface>>
│   │
│   ├── Main.Java
│
├── ReadMe.md
```