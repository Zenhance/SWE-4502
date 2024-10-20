using Quiz_2;
using Quiz_2.Decorators;
using Quiz_2.Services;

// Create the chat image service
var chatImageService = new ChatImageService(new VirusScanProcessor(new ToSquareProcessor(new CompressProcessor(new BasicImageProcessor()))));
// Process and send the image
chatImageService.ProcessAndSendImage("image.jpg", "user@example.com");


// Create the profile image service
var profileImageService = new ProfileImageService(new VirusScanProcessor(new ToSquareProcessor(new BasicImageProcessor())));
// Process and send the image
profileImageService.ProcessAndSendImage("image.jpg", "user@example.com");