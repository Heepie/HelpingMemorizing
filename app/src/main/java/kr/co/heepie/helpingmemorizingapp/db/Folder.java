package kr.co.heepie.helpingmemorizingapp.db;

import java.lang.annotation.Annotation;

import io.realm.RealmList;
import io.realm.annotations.RealmModule;

/**
 * Created by Hee_Ju.M on 2017-05-05.
 */

public class Folder extends Component implements RealmModule {
    private String description;
    private RealmList<Component> list = new RealmList<Component>();

    public Folder(String name) {
        super(name);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Folder add(Component item) {
        list.add(item);
        return this;
    }

    public RealmList<Component> getList() {
        return list;
    }

    @Override
    public boolean library() {
        return false;
    }

    @Override
    public boolean allClasses() {
        return false;
    }

    @Override
    public Class<?>[] classes() {
        return new Class<?>[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }



    // Builder Pattern
    public static class FolderBuilder {
        private Folder folder;

        public FolderBuilder() {
            folder = new Folder("basic_name");
        }

        public static FolderBuilder startBuild() {
            return new FolderBuilder();
        }

        public FolderBuilder setName(String name) {
            folder.setName(name);
            return this;
        }

        public FolderBuilder setDescription(String description) {
            folder.setDescription(description);
            return this;
        }

        public Folder finishBuild() {
            return folder;
        }
    }
}
