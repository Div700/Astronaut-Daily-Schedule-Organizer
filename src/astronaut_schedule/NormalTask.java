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
public class NormalTask extends Task
{
    String taskID;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private int priority;

    public NormalTask(LocalTime startTime,LocalTime endTime,int priority,String description,String taskid)
    {
        this.taskID = taskid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getPriority() {
        return priority;
    }


    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    @Override
    public String toString() {
        return "Task{" + "taskID=" + taskID + ", description=" + description + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
    
    @Override
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
    void setpriority(int priority)
    {
        this.priority=priority;
    }

    @Override
    void seDescription(String description) 
    {
        this.description=description;
    }

    @Override
    void setEndTime(LocalTime newEndTime) 
    {
        this.endTime=newEndTime;
    }
}
