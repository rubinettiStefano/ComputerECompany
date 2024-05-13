package model;

public class Periferic 
{
    //SCOPE DI CLASSE   (STATIC)
    //Proprietà

    //Metodi


    //SCOPE DI OGGETTO
    //Proprietà
    private Integer id,price;
    private String type,model;

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
    }


    public Periferic(Integer id, Integer price, String type, String model) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.model = model;
    }

    public Periferic(String csv) {
        String[] parts = csv.split(",");
        this.id = Integer.parseInt(parts[0]);
        this.price = Integer.parseInt(parts[1]);;
        this.type = parts[2];
        this.model = parts[3];
    }

    //Metodi ACCESSORI

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //OTHER
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


}
