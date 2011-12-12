package uk.ac.shef.dcs.oak.leccy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * An electricity reading - assuming university type format
 * 
 * @author sat
 * 
 */
public class Reading
{
   String MPAN;
   String meter;
   String utility;
   long time;
   int reading;

   static DateFormat df = new SimpleDateFormat("d MMMM yyy HH:mm");

   public Reading(String line)
   {
      String[] elems = line.split(",");
      if (elems.length != 9)
         System.err.println("Error in reading the line");

      MPAN = elems[0];
      meter = elems[1];
      utility = elems[2];

      try
      {
         time = df.parse(elems[3] + " " + elems[4].split("-")[0]).getTime();
      }
      catch (ParseException e)
      {
         System.err.println("Cannot parse date: " + elems[3] + " -> " + elems[4].split("-")[0]);
         e.printStackTrace();
         System.exit(1);
      }

   }
}
