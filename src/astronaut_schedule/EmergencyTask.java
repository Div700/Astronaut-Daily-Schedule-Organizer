/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astronaut_schedule;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Divyansh
 */
public class EmergencyTask extends Task
{
    String taskID;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    final int priority = 1;
    public EmergencyTask(String description)
    {
        this.startTime = LocalTime.now();
        this.taskID = "ET"+startTime;
        this.description = description;
    }
    
    public String getTaskID() {
        return taskID;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    
  void saveTasks()
    {
        try (FileWriter writer = new FileWriter("task.txt",true)) {
            writer.write("Date: "+LocalDate.now());
            writer.write(" Task Name: " + this.getDescription() );
            writer.write(" Task start time: " + this.getStartTime() + "Task end time: "+this.getEndTime());
            System.out.println("Task data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "EmergencyTask{" + "taskID=" + taskID + ", description=" + description + ", startTime=" + startTime + ", endTime=" + endTime + ", priority=" + priority + '}';
    }

    @Override
    void setpriority(int priority) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void seDescription(String description) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
