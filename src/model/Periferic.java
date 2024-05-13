package model;

import java.util.HashSet;

public class Periferic 
{
    //SCOPE DI CLASSE   (STATIC)
    //Proprietà
    private static HashSet<String> VALIDTYPES = new HashSet<>();
    //Metodi
    private static void exit()
    {
        System.out.println("Periferica non valida, termino programma");
        System.exit(-1);
    }


    //BLOCCO DI INIZIALIZZAZIONE STATIC
    //un blocco di codice che viene eseguito alla CREAZIONE della CLASSE

    //quando facciamo partire un progetto
    //prima di eseguire la prima riga del main
    //Java crea le CLASSI
    //"COSTRUTTORE" per la Classe
    //lo utilizziamo per dare valori alle proprietà STATIC
    static
    {
        VALIDTYPES.add("monitor");
        VALIDTYPES.add("keyboard");
        VALIDTYPES.add("mouse");
        VALIDTYPES.add("headset");
        VALIDTYPES.add("controller");
    }

    //SCOPE DI OGGETTO
    //Proprietà
    private Integer id,price;
    private String type,model;

    //RIFERIMENTO AL PADRE, serve a JAVA
    private Computer computer;
    //CHIAVE ESTERNA, serve al db
    private Integer computer_id;

    //Metodi
    //COSTRUTTORI

    //OVERLOAD di un Metodo
    //POLIMORFISMO dei Metodi
    //Un metodo può avere diverse versioni di se stesso
    //il programma è in grado di distinguerle in base ai parametri passati
    public Periferic(){}

    public Periferic(Integer price, String type, String model) {
        this.price = price;
        this.type = type;
        this.model = model;

        if(!isValid())
            exit();
    }


    public Periferic(Integer id, Integer price, String type, String model) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.model = model;
        if(!isValid())
            exit();
    }

    public Periferic(String csv) {
        String[] parts = csv.split(",");
        this.id = Integer.parseInt(parts[0]);
        this.price = Integer.parseInt(parts[1]);;
        this.type = parts[2];
        this.model = parts[3];
        if(!isValid())
            exit();
    }

    //Metodi ACCESSORI

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if(!hasValidId())
            exit();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
        if(!hasValidPrice())
            exit();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if(!hasValidType())
            exit();
    }

    public String getModel() {
        return model;
    }

    //this è l'oggetto su cui il metodo viene invocato
    //this.model è LA PROPRIETÀ model dell'oggetto
    public void setModel(String model) {
        this.model = model;
        if(!hasValidModel())
            exit();
    }

    

    public Computer getComputer() 
    {
        return computer;
    }

    //VOGLIAMO IMPOSTI ANCHE LA CHIAVE ESTERNA
    public void setComputer(Computer computer) 
    {
        this.computer       = computer;
        this.computer_id    = computer.getId();
    }

    public Integer getComputer_id() 
    {
        return computer_id;
    }

    public void setComputer_id(Integer computer_id) 
    {
        this.computer_id = computer_id;
    }

    //OTHER
    public boolean isValid()
    {
        return hasValidId() && hasValidPrice() && hasValidModel() && hasValidType();
    }

    public boolean hasValidId()
    {
        return id==null || id>0;
    }

    public boolean hasValidPrice()
    {
        return price!=null && price>0;
    }

    public boolean hasValidModel()
    {
        return model!=null && !model.isBlank();
    }

    //I VALORI DI TYPE ACCETTABILI sono solo:
    //keyboard, mouse, monitor, headset, controller
    public boolean hasValidType()
    {
        return type!=null  && VALIDTYPES.contains(type);
    }

    //generazione query
    public String writeInsertQuery()
    {
        return  "INSERT INTO periferics (price,type,model) VALUES ([price],'[type]','[model]')"
                .replace("[price]", price+"")// "INSERT INTO periferics (price,type,model) VALUES (10,'[type]','[model]')"
                .replace("[type]", type)// "INSERT INTO periferics (price,type,model) VALUES (10,'mouse','[model]')"
                .replace("[model]",model);// "INSERT INTO periferics (price,type,model) VALUES (10,'mouse','trust classico')"
    }

    public String writeUpdateQuery()
    {
        return  "UPDATE periferics set price=[price],type= '[type]',model='[model]' WHERE id=[id])"
                .replace("[price]", price+"")
                .replace("[type]", type)
                .replace("[model]",model)
                .replace("[id]",id+"");
    }

    public String writeDeleteQuery()
    {
        return  "DELETE FROM periferics WHERE id="+id;
    }

}
