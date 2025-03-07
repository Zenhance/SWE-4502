using Lab_7.Facade;

class Program
{
    public static void Main()
    {
        NotificationFacade notificationFacade = new NotificationFacade();
        notificationFacade.ShowNotification();
    }
}