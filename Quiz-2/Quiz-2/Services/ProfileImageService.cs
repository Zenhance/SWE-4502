namespace Quiz_2.Services;

public class ProfileImageService
{
    private readonly IImageProcessor _imageProcessor;
    public ProfileImageService(IImageProcessor imageProcessor) 
    {
        _imageProcessor = imageProcessor;
    }

    public void ProcessAndSendImage(string imagePath, string recipient)
    {
        var image = ReadImage(imagePath);

        image = _imageProcessor.ProcessImage(image);

        SendImage(image, recipient);
    }
    
    private byte[] ReadImage(string imagePath)
    {
        Console.WriteLine("Reading image from file...");
        return new byte[] { }; 
    }

    private void SendImage(byte[] image, string recipient)
    {
        Console.WriteLine($"Sending image to {recipient}...");
    }
}