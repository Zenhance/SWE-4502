using System;
using System.Collections.Generic;

public class Logger
{
    private List<string> logs = new();

    public void Log(string message)
    {
        string logEntry = $"[{DateTime.Now:yyyy-MM-dd HH:mm:ss}] {message}";
        logs.Add(logEntry);
    }

    public List<string> GetLogs() => logs;
}