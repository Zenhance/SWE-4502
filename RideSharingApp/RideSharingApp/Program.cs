// Create a rider and a driver

using RideSharingApp;
using RideSharingApp.Behaviours;
using RideSharingApp.Domain;
using RideSharingApp.Events;
using RideSharingApp.Implementations;

Rider rider = new Rider("John Doe", "john@example.com", new CreditCardPayment());
Driver driver = new Driver("Alice Smith", "alice@example.com");

// Rider requests a luxury ride
IRideType luxuryRide = new LuxuryRide();
Trip ride = rider.RequestRide(driver, luxuryRide, "Downtown", "Airport");

// Driver accepts the ride
driver.AcceptRide(ride);

// Rider changes drop-off location during the ride
rider.UpdateDropoffLocation(ride, "New Airport Terminal");

// Rider changes payment method during the ride
rider.SetPaymentMethod(ride, new PayPalPayment());

// Complete the ride
driver.CompleteRide(ride);

// Process the payment
ride.MakePayment();