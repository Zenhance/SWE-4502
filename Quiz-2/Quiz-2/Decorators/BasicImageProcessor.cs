namespace Quiz_2.Decorators;

public class BasicImageProcessor : IImageProcessor
{
    public byte[] ProcessImage(byte[] image)
    {
        // In the basic processor, there's no modification
        return image;
    }
}