using System;
using System.Collections.Generic;
using TaskManager.Commands;
namespace TaskManager.Services;

public class Logger
{
    private readonly List<string> _logs = new List<string>();

    public void LogCommand(Command command)
    {
        var logEntry=$"{command.Timestamp}: {command.Description}";
        _logs.Add(logEntry);
    }
    public IEnumerable<string> GetLogs()
    {
        return _logs;
    }
}