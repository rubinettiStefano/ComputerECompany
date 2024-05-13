package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.Computer;
import model.Periferic;

public class DatabaseHandler 
{
    private Database db = new Database("config.txt");
    private ComputerRepository cRepo = new ComputerRepository(db);
    private PerifericRepository pRepo = new PerifericRepository(db);

    /**
     * Restituisce tutti i computer sul db, compresi di periferiche
     * @return
     */
    public ArrayList<Computer> readComputer()
    {
        ArrayList<Computer> res = cRepo.select();//leggo computer senza periferiche
        pRepo.link(res);//collego ai computer tutte le periferiche
        return res;//li restituisco
    }

    public ArrayList<Computer> readComputer(String condition)
    {
        ArrayList<Computer> res = cRepo.select(condition);//leggo computer senza periferiche
        pRepo.link(res);//collego ai computer tutte le periferiche
        return res;//li restituisco
    }

    public Computer readComputer(int id)
    {
        Computer res = cRepo.select(id);//leggo computer senza periferiche
        pRepo.link(res);//collego ai computer tutte le periferiche
        return res;//li restituisco
    }

    public ArrayList<Periferic> readPeriferic()
    {
        ArrayList<Periferic> res = pRepo.select();//leggo computer senza periferiche
        cRepo.link(res);//collego ai computer tutte le periferiche
        return res;//li restituisco
    }

    public ArrayList<Periferic> readPeriferic(String condition)
    {
        ArrayList<Periferic> res = pRepo.select(condition);//leggo computer senza periferiche
        cRepo.link(res);//collego ai computer tutte le periferiche
        return res;//li restituisco
    }

    public Periferic readPeriferic(int id)
    {
        Periferic res = pRepo.select(id);//leggo computer senza periferiche
        cRepo.link(res);//collego ai computer tutte le periferiche
        return res;//li restituisco
    }

    public void insertComputer(Computer c)
    {
        cRepo.insert(c);
    }

    public void insertComputer(ArrayList<Computer> computers)
    {
        cRepo.insert(computers);
    }

    public void insertPeriferic(Periferic p)
    {
        pRepo.insert(p);
    }

    public void insertPeriferic(ArrayList<Periferic> periferics)
    {
        pRepo.insert(periferics);
    }

    public void updateComputer(Computer c)
    {
        cRepo.update(c);
    }

    public void updateComputer(ArrayList<Computer> computers)
    {
        cRepo.update(computers);
    }

    public void updatePeriferic(Periferic p)
    {
        pRepo.update(p);
    }

    public void updatePeriferic(ArrayList<Periferic> periferics)
    {
        pRepo.update(periferics);
    }

    public void deletePeriferic(Periferic p)
    {
        pRepo.delete(p);
    }

    public void deletePeriferic(int id)
    {
        pRepo.delete(id);
    }

    public void deletePeriferic(ArrayList<Periferic> periferics)
    {
        pRepo.delete(periferics);
    }

    public void deleteComputer(Computer c)
    {
        cRepo.delete(c);
        pRepo.delete(c.getPeriferics());
    }

    public void deleteComputer(int id)
    {
        cRepo.delete(id);//cancello computer con id passato come parametro
        //quando voglio cancellare un computer per id non ho le sue periferiche
        ArrayList<Periferic> toDelete = pRepo.select("computer_id="+id);
        //leggo tramite query con WHERE dal db le sue Periferiche

        pRepo.delete(toDelete);//le cancello
    }

    public void deleteComputer(ArrayList<Computer> computers)
    {
        cRepo.delete(computers);

        for(Computer c: computers)
            pRepo.delete(c.getPeriferics());
    }
}
