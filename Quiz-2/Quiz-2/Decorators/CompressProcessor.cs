namespace Quiz_2.Decorators;

public class CompressProcessor : IImageProcessor
{
    private readonly IImageProcessor _imageProcessor;

    public CompressProcessor(IImageProcessor imageProcessor)
    {
        _imageProcessor = imageProcessor;
    }

    public byte[] ProcessImage(byte[] image)
    {
        Console.WriteLine("Compressing image...");
        image = _imageProcessor.ProcessImage(image);
        return CompressImage(image);
    }

    private byte[] CompressImage(byte[] image)
    {
        // Simulate image compression
        return image; // Return compressed image
    }
}