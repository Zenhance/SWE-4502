namespace Quiz_2.Decorators;

public class VirusScanProcessor : IImageProcessor
{
    private readonly IImageProcessor _imageProcessor;

    public VirusScanProcessor(IImageProcessor imageProcessor)
    {
        _imageProcessor = imageProcessor;
    }

    public byte[] ProcessImage(byte[] image)
    {
        Console.WriteLine("Scanning image for viruses...");
        image = _imageProcessor.ProcessImage(image);
        return ScanForViruses(image);
    }

    private byte[] ScanForViruses(byte[] image)
    {
        // Simulate virus scanning
        return image; // Return scanned image
    }
}
