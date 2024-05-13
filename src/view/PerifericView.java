package view;


import java.util.ArrayList;

import model.Periferic;

public class PerifericView 
{
    public String render(Periferic p)
    {
        String res = "";
        if(p.getId()==null)
            res+="Sono una periferica non ancora nel db,";
        else
            res+="Sono una periferica del db con id "+p.getId()+",";

        return res+" tipo "+p.getType()+", modello "+p.getModel()+" e prezzo"+p.getPrice();
    }

    public String render(ArrayList<Periferic> periferics)
    {
        String res = "Lista di periferiche: ";
        
        for(Periferic p : periferics)
            res+="\n"+render(p);
        
        return res;
    }
}
