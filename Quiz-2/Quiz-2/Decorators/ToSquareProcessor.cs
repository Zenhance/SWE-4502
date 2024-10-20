namespace Quiz_2.Decorators;

public class ToSquareProcessor : IImageProcessor
{
    private readonly IImageProcessor _imageProcessor;

    public ToSquareProcessor(IImageProcessor imageProcessor)
    {
        _imageProcessor = imageProcessor;
    }

    public byte[] ProcessImage(byte[] image)
    {
        Console.WriteLine("Resizing image to 1:1 aspect ratio...");
        image = _imageProcessor.ProcessImage(image);
        return ResizeImage(image);
    }

    private byte[] ResizeImage(byte[] image)
    {
        // Simulate resizing the image to 4:3 aspect ratio
        return image; // Return resized image
    }
}