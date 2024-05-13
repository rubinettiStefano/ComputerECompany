package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Computer 
{

    private Integer id,ramSize,mmaSize,price;
    private String mmaType,cpu,gpu;
    
    //nel padre la relazione è determinata da una LISTA di FIGLI
    private ArrayList<Periferic> periferics = new ArrayList<>();//VALORI DI DEFAULT, vengono impostati prima di eseguire la prima riga del costruttore

    //FANNO PARTE DEL CONTESTO DI ESECUZIONE DI UN METODO (valori a disposizione del metodo)
    //implicitamente this -> oggetto su cui il metodo è stato richiamato
    //implicitamente la classe in cui il metodo è -> metodi e proprietà static
    //esplicitamente i parametri passati
    public void addPeriferic(Periferic p)
    {
        this.periferics.add(p);
        p.setComputer(this);
    }

    //TODO
    //VALIDATE ramSize con i valori 4,8,16,32,64
    //mmaSize con i valori 128,256,512,1000,2000
    //cpu con intel i3,intel i5, intel i7, intel i9, ryzen 3, ryzen 5, ryzen 7, ryzen 9
    //gpu sono infite, quindi non validatela se non  come una qualsiasi string
    //mmaType -> ssd,hdd,emmc
    public Computer(){}

    public Computer(Integer id, Integer ramSize, Integer mmaSize, Integer price, String mmaType, String cpu,
            String gpu) 
    {
        //this.periferics = new ArrayList<>();
        this.id = id;
        this.ramSize = ramSize;
        this.mmaSize = mmaSize;
        this.price = price;
        this.mmaType = mmaType;
        this.cpu = cpu;
        this.gpu = gpu;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getRamSize() {
        return ramSize;
    }
    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
    }
    public Integer getMmaSize() {
        return mmaSize;
    }
    public void setMmaSize(Integer mmaSize) {
        this.mmaSize = mmaSize;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getMmaType() {
        return mmaType;
    }
    public void setMmaType(String mmaType) {
        this.mmaType = mmaType;
    }
    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public String getGpu() {
        return gpu;
    }
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    
    
    private Integer getTotalPerifericsPrice()
    {
        Integer res = 0;

        for(Periferic p : periferics)
            res+=p.getPrice();

        return res;
    }

    public Integer getTotalPrice()
    {
        return getTotalPerifericsPrice()+price;
    }

    /**
     * Un computer è utilizzabile quando ha come periferiche almeno una keyboard, un mouse e un monitor
     * @return
     */
    public boolean isUsable()
    {
        //SET                (NON C'ENTRA NULLA!!11!!!! con i SETTER)
        // INSIEME                                             tanti elementi
        // di OGGETTI dello stesso tipo                        no VETTORE di String,  Periferiche, solo di un tipo
        // NON ORDINATO                                        non ho gli indici
        // NON può contenere duplicati
        // LUNGHEZZA VARIABILE                                aumenta e diminuisce inserendo o rimuovendo oggetti
        HashSet<String> perifericsTypes = new HashSet<>();//possedute

        for(Periferic p : periferics)
            perifericsTypes.add(p.getType());

        return perifericsTypes.contains("keyboard") && perifericsTypes.contains("mouse") && perifericsTypes.contains("monitor");
    }

    public ArrayList<Periferic> getPeriferics() {
        return periferics;
    }

    public void setPeriferics(ArrayList<Periferic> periferics) {
        this.periferics = periferics;
    }

    
}
