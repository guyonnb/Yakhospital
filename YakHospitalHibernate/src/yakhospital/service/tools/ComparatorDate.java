/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service.tools;

import java.util.Calendar;
import yakhospital.hibernate.Soin;
/**
 *
 * @author Emilie
 */
public class ComparatorDate {
    
    public static int compareDateDebut(Soin s1, Soin s2)
    {
        return s1.getDate_debut_soin().compareTo(s2.getDate_debut_soin());
    }
    
    public static int compareDateFin(Soin s1, Soin s2)
    {
        return s1.getDate_fin_soin().compareTo(s2.getDate_fin_soin());
    }
    
    // renvoie la difference en minutes entre 2 dates
    public static int calculateDifference(Calendar date1, Calendar date2)
    {
        int tempDifference = 0;
        int difference = 0;
        Calendar earlier = Calendar.getInstance();
        Calendar later = Calendar.getInstance();

        if (date1.compareTo(date2) < 0)
        {
            earlier.setTime(date1.getTime());
            later.setTime(date2.getTime());
        }
        else
        {
            earlier.setTime(date2.getTime());
            later.setTime(date1.getTime());
        }

        while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR))
        {
            tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
            difference += (tempDifference * 1440);

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }

        if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR))
        {
            tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
            difference += (tempDifference * 1440);

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }
        
        if (earlier.get(Calendar.HOUR_OF_DAY) != later.get(Calendar.HOUR_OF_DAY))
        {
            tempDifference = later.get(Calendar.HOUR_OF_DAY) - earlier.get(Calendar.HOUR_OF_DAY);
            difference += (tempDifference * 60);

            earlier.add(Calendar.HOUR_OF_DAY, tempDifference);
        }
        
        if (earlier.get(Calendar.MINUTE) != later.get(Calendar.MINUTE))
        {
            tempDifference = later.get(Calendar.MINUTE) - earlier.get(Calendar.MINUTE);
            difference += tempDifference;

            earlier.add(Calendar.MINUTE, tempDifference);
        }

        return difference;
}

}
    
