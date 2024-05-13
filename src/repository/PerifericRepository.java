package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.Computer;
import model.Periferic;

public class PerifericRepository 
{
    private Database db;

    public PerifericRepository (Database db)
    {
        this.db = db;
    }

    public ArrayList<Periferic> select()
    {
        
        return select("1=1");//condizione di identità, sempre vera
    }

    public Periferic select(int id)
    {
        return select("id="+id).get(0);//condizione di identità, sempre vera
    }

    public ArrayList<Periferic> select(String condizione)
    {
        ArrayList<String> rows = db.select("SELECT * FROM periferics WHERE "+condizione);
        ArrayList<Periferic> res = new ArrayList<>();

        for(String row : rows)
            res.add(new Periferic(row));//creo nuova Periferic e la aggiungo alla lista

        return res;
    }  


    /**
     * Legge dal db le stanze figlie e le collega
     * @param father
     */
    public void link(Computer father)
    {
        ArrayList<String> rows = db.select("SELECT * FROM periferics JOIN computers ON computers.id=periferics.computer_id WHERE computers.id="+father.getId());

        for(String row : rows)
            father.addPeriferic(new Periferic(row));//prendi il padre, aggiungi alle sue stanze una nuova stanza creata convertendo la riga letta da db
    }

      /**
     * Legge dal db le stanze figlie e le collega
     * @param father
     */
    public void link(ArrayList<Computer> fathers)
    {
        for(Computer father : fathers)
            link(father);
    }
}
