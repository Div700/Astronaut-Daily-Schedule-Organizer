/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astronaut_schedule;

/**
 *
 * @author Divyansh
 */
public class Astronaut implements Observer
{
    private String name;
    private String id;
    private String role;
    
    public Astronaut(String name,String id,String role)
    {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void update(String notification) 
    {
        System.out.println("Recieved message by "+name+": "+notification);
    }
    
}
