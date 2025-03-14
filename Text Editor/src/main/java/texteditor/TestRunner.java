package texteditor;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Running TextEditor Unit Tests...");
        
        // Run TextEditorTest
        Result result = JUnitCore.runClasses(TextEditorTest.class);
        
        // Print failures
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        
        // Print summary
        System.out.println("Tests run: " + result.getRunCount());
        System.out.println("Failures: " + result.getFailureCount());
        System.out.println("Tests successful: " + result.wasSuccessful());
    }
} 