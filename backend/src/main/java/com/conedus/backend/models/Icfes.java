package com.conedus.backend.models;

public class Icfes implements Comparable<Icfes>{
  private int año;
  private int global;
  private int matematicas;
  private int lectura;
  private int sociales;
  private int ciencias;
  private int ingles;

  public Icfes(int año, int global, int matematicas, int lectura, int sociales, int ciencias, int ingles) {
    
        this.año = año;
        this.global = global;
        this.matematicas = matematicas;
        this.lectura = lectura;
        this.sociales = sociales;
        this.ciencias = ciencias;
        this.ingles = ingles;
    }
  
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }
    public int getGlobal() {
        return global;
    }
    public void setGlobal(int global) {
        this.global = global;
    }
    public int getMatematicas() {
        return matematicas;
    }
    public void setMatematicas(int matematicas) {
        this.matematicas = matematicas;
    }
    public int getLectura() {
        return lectura;
    }
    public void setLectura(int lectura) {
        this.lectura = lectura;
    }
    public int getSociales() {
        return sociales;
    }
    public void setSociales(int sociales) {
        this.sociales = sociales;
    }
    public int getCiencias() {
        return ciencias;
    }
    public void setCiencias(int ciencias) {
        this.ciencias = ciencias;
    }
    public int getIngles() {
        return ingles;
    }
    public void setIngles(int ingles) {
        this.ingles = ingles;
    }
    @Override

    public int compareTo(Icfes otro) {
        return Integer.compare(this.año, otro.año);
    }
  
}
