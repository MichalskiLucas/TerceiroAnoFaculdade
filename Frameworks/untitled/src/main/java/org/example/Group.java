package org.example;

import java.util.ArrayList;
import java.util.List;

public class Group implements Component{

    List<Component> components = new ArrayList<>();

    public void add (Component component){
        components.add(component);
    }

    public void render (){
        for (Component component: components) {
            component.render();
        }
    }


    public void move() {
        for (Component component: components) {
            component.move();
        }
    }

}
