package fr.quarkus.openshift.database;

public enum DivinityGroup {
    Foudre(1),
    Mer(2),
    Enfers(3),
    Guerre(4);

    public final int id;

    private DivinityGroup(int id) {
        this.id = id;
    }
}
