package hu.flowacademy.flowtaskmanager.models;

public class Task {

    private Long id;

    private Type type;



    enum Type {
        JAVA,
        JAVASCRIPT,
        SPRING,
        ANGULAR,
        LINUX,
        DATABASE
    }
}
