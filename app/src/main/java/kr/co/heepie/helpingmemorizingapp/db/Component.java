package kr.co.heepie.helpingmemorizingapp.db;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.RealmClass;

/**
 * Created by Hee_Ju.M on 2017-05-05.
 */

@RealmClass
public class Component extends RealmObject {
//    @PrimaryKey
//    private int id;

    private String name;
    private String description;

    private RealmList<Component> list = new RealmList<Component>();

    @Index
    private String componentType;

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public Component() {
    }

    public Component(String name, String type) {
        this.name = name;
        this.componentType = type;
    }

    public Component add(Component obj) {
        list.add(obj);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public int getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public RealmList<Component> getList() {
        return list;
    }

    public String getComponentType() {
        return componentType;
    }

    // Builder Pattern
    public static class ComponentBuilder {
        private Component component;

        public ComponentBuilder() {
            component = new Component();
        }

        public static ComponentBuilder startBuild() {
            return new ComponentBuilder();
        }

        public ComponentBuilder setType(String type) {
            component.setComponentType(type);
            return this;
        }

        public ComponentBuilder setName(String name) {
            component.setName(name);
            return this;
        }

        public ComponentBuilder setDescription(String description) {
            component.setDescription(description);
            return this;
        }

        public Component finishBuild() {
            return component;
        }
    }
}
