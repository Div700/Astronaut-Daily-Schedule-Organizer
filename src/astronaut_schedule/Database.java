/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package astronaut_schedule;

import java.time.LocalTime;
import java.util.TreeMap;

/**
 *
 * @author Divyansh
 */
public interface Database 
{
    Task insert(Task t); //for inserting tasks 
    void delete(String id); //for deleting tasks
    void update(String id,LocalTime updatedEndTime,String newDescription,int updatedPriority); //for updating tasks
    void read(); //for reading or viewing tasks
    void viewPriority(int priority); //for viewing tasks based on priority
}
