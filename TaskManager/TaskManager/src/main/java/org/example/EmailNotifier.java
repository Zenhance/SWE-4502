package org.example;

class EmailNotifier implements Observer {
    public void notify(String message) {
        System.out.println("Email sent: " + message);
    }
}
