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
abstract public class Task 
{
    static final String spaceship = "Apollo11";
    
        public String getDescription() 
        {
        return "These are the compulsory tasks";
        }

    abstract public LocalTime getStartTime();
    abstract public LocalTime getEndTime();
    abstract public int getPriority();
    abstract public String getTaskID();
    abstract void setpriority(int priority);
    abstract void seDescription(String description);
    abstract void setEndTime(LocalTime newEndTime);
    abstract void saveTasks();
}
