package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.Computer;
import model.Periferic;

public class ComputerRepository 
{

    private Database db;

    public ComputerRepository (Database db)
    {
        this.db = db;
    }

    public ArrayList<Computer> select()
    {
        
        return select("1=1");//condizione di identità, sempre vera
    }

    public Computer select(int id)
    {
        return select("id="+id).get(0);//condizione di identità, sempre vera
    }

    public ArrayList<Computer> select(String condizione)
    {
        ArrayList<String> rows = db.select("SELECT * FROM computers WHERE "+condizione);
        ArrayList<Computer> res = new ArrayList<>();

        for(String row : rows)
            res.add(new Computer(row));//creo nuova Periferic e la aggiungo alla lista

        return res;
    }  

     /**
     * Legge dal db la casa padre e la collega
     * @param father
     */
    public void link(Periferic son)
    {
        ArrayList<String> rows = db.select("SELECT * FROM computers JOIN periferics ON computers.id=periferics.computer_id WHERE periferics.id="+son.getId());

        Computer h = new Computer(rows.get(0));//converto l'unica riga letta
        h.addPeriferic(son);//le collego
    }

   
    public void link(ArrayList<Periferic> sons)
    {
        ArrayList<Integer> computers_id = new ArrayList<>();

        for(Periferic r : sons)
        {
            if(!computers_id.contains(r.getComputer_id()))
                computers_id.add(r.getComputer_id());
        }

        String valoriIn =   computers_id
                            .toString()
                            .replace("[", "(")
                            .replace(", ", ",")
                            .replace("]", ")");

        ArrayList<Computer> computers = select("id IN "+valoriIn);
        for(Computer h : computers)//scorri tutte le case
        {
            for(Periferic r : sons)//per ogni casa scorri tutte le stanze
            {
                if(r.getComputer_id().equals(h.getId()))//se PREDICATO JOIN TRUE, periferics.FK = computers.PK
                    h.addPeriferic(r);//collega
            }
        }
    }

}
