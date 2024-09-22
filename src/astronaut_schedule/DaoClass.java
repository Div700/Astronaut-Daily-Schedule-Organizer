/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astronaut_schedule;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Divyansh
 */

//complying with the principal of dependency inversion - higher module schedulemaanger does not depend directly on the lower module daoclass
public class DaoClass implements Database
{

    TreeMap<LocalTime,Task> allTasks;
    
    public DaoClass()
    {
        allTasks = new TreeMap<>();
    }
    @Override
    public Task insert(Task t) 
    {
        if(t.getPriority()==1)
        {
            allTasks.put(LocalTime.MIN, t);
            return null;
        }
        for (Map.Entry<LocalTime, Task> entry : allTasks.entrySet()) 
        {
            if(checkOverlap(t,entry.getValue()))
            {
                return entry.getValue();
            }
//           System.out.println("Key: " + entry.getKey() + ", Task: " + entry.getValue());
        }
        allTasks.put(t.getStartTime(), t);
        return null;
    }

    @Override
    public void delete(String id) 
    {
        try
        {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        id = id.substring(2);
        LocalTime startTime = LocalTime.parse(id, timeFormatter);
        
        allTasks.remove(startTime);
        }
        catch(Exception e)
        {
        System.out.println("No such task present in the schedule");
        }
    }

    @Override
    public void update(String id,LocalTime updatedEndTime,String newDescription,int updatedPriority) 
    {
        try
        {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        
        id = id.substring(2);
        LocalTime startTime = LocalTime.parse(id, timeFormatter);
        Task t =allTasks.get(startTime);
       
        if(allTasks.size()==1)
        {
            updateTask(t,updatedEndTime,newDescription,updatedPriority);
            return;
        }
        
        LocalTime nextTaskEndTime = allTasks.higherKey(startTime);
        if(updatedEndTime.isBefore(nextTaskEndTime))
        {
            updateTask(t,updatedEndTime,newDescription,updatedPriority);
            System.out.println("Task updated successfully");
        
        }
        else
            System.out.println("Sorry can not update the tasks as it overlaps");
        }
        catch(Exception e)
        {
        System.out.println("No such task present in the schedule");
        }
    }

    private void updateTask(Task t,LocalTime updatedEndTime,String newDescription,int updatedPriority)
    {
            t.seDescription(newDescription);
            t.setEndTime(updatedEndTime);
            t.setpriority(updatedPriority);
    }
    @Override
    public void read() 
    {
        for (Map.Entry<LocalTime, Task> entry : allTasks.entrySet()) 
        {
            System.out.println(entry);
        }
    }
    
    @Override
    public void viewPriority(int priority)
    {
        for (Map.Entry<LocalTime, Task> entry : allTasks.entrySet()) 
        {
            if(entry.getValue().getPriority() == priority)
            System.out.println(entry);
        }
    }
    
    private boolean checkOverlap(Task newTask,Task existingTask)
    {
        LocalTime newTaskStart = newTask.getStartTime();
        LocalTime newTaskEnd = newTask.getEndTime();
        LocalTime existingTaskStart = existingTask.getStartTime();
        LocalTime existingTaskEnd = existingTask.getEndTime();
        
        if(newTaskEnd.isBefore(existingTaskStart) || newTaskStart.isAfter(existingTaskEnd))
        {
            return false;
        }
        else
            return true;
    }
}
