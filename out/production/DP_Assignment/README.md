# Smart Home System Project

## Overview

This project involves developing a modular system for home automation that reacts to changes in the environment. Your task is to implement several components that work together without direct dependencies on each other, ensuring maintainability and flexibility.

## Project Structure

Each feature is represented as a GitHub issue to be completed:

### Issue #1: Core System Framework

Implement the foundational architecture that enables components to communicate with each other indirectly. This should include:

- A mechanism for components to register interest in environmental state changes
- A central state management system that notifies interested components
- A data structure to hold environmental measurements and states

### Issue #2: Motion Detection

Create a component that:
- Monitors and responds to motion data
- Tracks location and time of detected movements
- Logs activity and analyzes patterns to identify normal vs. suspicious behavior

### Issue #3: Light Management

Create a component that:
- Responds to ambient light levels
- Adjusts lighting based on room occupancy
- Supports different "scenes" for various activities (reading, movie watching, etc.)

### Issue #4: Temperature Control

Create a component that:
- Monitors current temperature
- Activates heating or cooling based on target temperatures
- Implements hysteresis to prevent rapid cycling of HVAC systems

### Issue #5: Energy Consumption Tracking

Create a component that:
- Monitors real-time power usage
- Calculates usage statistics over time
- Identifies unusual consumption patterns

### Issue #6: Voice Command System

Create a component that:
- Processes natural language commands
- Translates commands into system state changes
- Maintains a history of processed commands

### Issue #7: Remote Access App

Create a component that:
- Displays the current state of the home environment
- Generates notifications for important events
- Allows remote control of home systems

## Assignment Requirements

For this assignment, you need to implement **only the unit tests** for each feature. You should create comprehensive test cases that verify:

1. Components respond correctly to environment changes
2. Components maintain proper internal state
3. Business logic works as expected

Your tests should use mocking where appropriate to isolate the components being tested.

## Development Guidelines

- Each feature should be developed and tested independently
- Components should not directly reference each other's implementation details
- Focus on testing the API contracts between components

## Submission

Submit your solution as a Git repository containing:
- Class definitions showing the API contracts between components
- Complete unit tests for each feature
