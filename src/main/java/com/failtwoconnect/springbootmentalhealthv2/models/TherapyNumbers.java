package com.failtwoconnect.springbootmentalhealthv2.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "numbers", schema = "therapyv2")
public class TherapyNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "anxiety")
    private int anxiety;
    @Column(name = "depression")
    private int depression;
    @Column(name = "self_harm")
    private int selfHarm;
    @Column(name = "energy_level")
    private int energyLevel;
    @Column(name = "craving")
    private int craving;
    @Column(name = "impulse")
    private int impulse;
    @Column(name = "physical_harm")
    private boolean physicalHarm;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public TherapyNumbers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }

    public int getDepression() {
        return depression;
    }

    public void setDepression(int depression) {
        this.depression = depression;
    }

    public int getSelfHarm() {
        return selfHarm;
    }

    public void setSelfHarm(int selfHarm) {
        this.selfHarm = selfHarm;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public int getCraving() {
        return craving;
    }

    public void setCraving(int craving) {
        this.craving = craving;
    }

    public int getImpulse() {
        return impulse;
    }

    public void setImpulse(int impulse) {
        this.impulse = impulse;
    }

    public boolean isPhysicalHarm() {
        return physicalHarm;
    }

    public void setPhysicalHarm(boolean physicalHarm) {
        this.physicalHarm = physicalHarm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
