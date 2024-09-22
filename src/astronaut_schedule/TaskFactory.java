/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astronaut_schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Divyansh
 */
public class TaskFactory
{
    private static int no_normal_tasks;
    static InputStreamReader read= new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(read);
    public static Task getTask(String mode) throws IOException
    {
        if(!mode.equals("emergency"))
        {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Enter start time of task (only enter the time in hh:mm format)");
        String start = br.readLine();
        System.out.println("Enter end time of task (only enter the time in hh:mm format)");
        String end = br.readLine();
        try {
            // Parse the time
            LocalTime startTime = LocalTime.parse(start, timeFormatter);
            LocalTime endTime = LocalTime.parse(end, timeFormatter);

                    // Use a default date, e.g., today
                    
            System.out.println("Enter the priority level of the task");
            int priority = Integer.parseInt(br.readLine());
            if(priority==1)
            {
                throw new IllegalArgumentException();
            }
            System.out.println("Enter the description for the task");
            String description = br.readLine();
            no_normal_tasks++;
            return new NormalTask(startTime,endTime,priority,description,"NT"+startTime);
            } 
        catch (DateTimeParseException e) 
        {
        System.out.println("Error: Invalid time format: " + e.getMessage());
        return null;
        }  
        catch(IllegalArgumentException i)
        {
            System.out.println("Can not give emergency priority to normal tasks! Dont misuse the system");
            return null;
        }
        }
        else
        {
            System.out.println("Enter the emergency task asap!!");
            String description = br.readLine();
            return new EmergencyTask(description);
        }
    }
}
