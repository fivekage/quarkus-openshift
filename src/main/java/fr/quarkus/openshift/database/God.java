package fr.quarkus.openshift.database;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "God")
public class God extends PanacheEntity {

    @Column(name = "name")
    public String name;
    @Column(name = "place")
    public String place;
    @Column(name = "country")
    public String country;
    @Column(name = "idDivinityGroup")
    public int idDivinityGroup;

    public God() {
    }

    public God(String name, String place, String country, int divinityGroup) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");

        this.name = name;
        this.place = place;
        this.country = country;
        this.idDivinityGroup = divinityGroup;
    }

    @Transactional
    public static God findByName(String name) {
        return find("name", name).firstResult();
    }

    @Transactional
    public static List<God> findDivinityGroup(DivinityGroup divinityGroup) {
        return list("idDivinityGroup", divinityGroup.id);
    }

    @Transactional
    public static List<God> listAll() {
        return God.findAll().list();
    }

    @Transactional
    public static void delete(String name) {
        delete("name", name);
    }

    public static void add(String name, String place, String country, int divinityGroup) {
        God god = new God(name, place, country, divinityGroup);
        add(god);
    }

    @Transactional
    public static void add(God god) {
        try {
            god.persist();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}