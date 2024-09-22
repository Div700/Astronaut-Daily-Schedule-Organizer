/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package astronaut_schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Divyansh
 */
public class Astronaut_Schedule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        ScheduleManager manager = ScheduleManager.getSingleManager();
        InputStreamReader read= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(read);
        System.out.println("Enter the number of astronauts in the spaceship: ");
        int number_astronauts = Integer.parseInt(br.readLine());
        List<Astronaut> astronauts;
        String name,id,role;
        for(int i=0;i<number_astronauts;i++)
        {
            System.out.println("Enter name of astronaut");
            name = br.readLine();
            System.out.println("Enter id of astronaut");
            id = br.readLine();
            System.out.println("Enter role of astronaut");
            role = br.readLine();
            Astronaut a = new Astronaut(name,id,role);
            manager.addObserver(a);
        }
        int choice = 1;
        String mode;
        String start,end;
        
        while(choice!=0)
        {
            System.out.println("Enter 1 to add a task\n Enter 2 to view today's schedule\n Enter 3 to view tasks based on priority \nEnter 4 to delete a task\n Enter 5 to update an existing task\n Enter 0 to exit");
            choice = Integer.parseInt(br.readLine());
            switch(choice)
            {
                case 0:
                break;
                case 1:
                    System.out.println("Enter the mode of task: enter normal for a normal task and emergency for an emergency task");
                    mode = br.readLine();
                    Task t = TaskFactory.getTask(mode);
                    System.out.println(t);
                    if(t!=null)
                    manager.addTask(t);
                    
                break;
                
                case 2:
                    manager.viewSchedule();
                break;
                
                case 3:
                    System.out.println("Enter the priority tasks you want to see");
                    int p = Integer.parseInt(br.readLine());
                    manager.viewforPriority(p);
                break;
                
                case 4:
                    manager.viewSchedule();
                    System.out.println("Enter the task id to be removed");
                    manager.removeTask(br.readLine());
                break;
                
                case 5:
                    System.out.println("Enter the task id to be updated");
                    manager.update(br.readLine());
                break;
                default:
                    System.out.println("Wrong chocie");
            }
        }
    }
    
}
