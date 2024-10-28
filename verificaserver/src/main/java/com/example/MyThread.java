package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class MyThread extends Thread 
{

    private Socket s;

    public MyThread(Socket s) 
    {
        this.s = s;
    }

    public void run() 
    {

        System.out.println("Qualcuno si è collegato");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String stringaRicevuta;
            String risposta = "";
            ArrayList <String> note = new ArrayList();

            do 
            {

                stringaRicevuta = in.readLine(); //stringa ricevuta dal client

                System.out.println("La sringa ricevuta: " + stringaRicevuta);


                if (stringaRicevuta.equals("!")) 
                {
                    risposta = "!";
                    out.writeBytes(risposta + "\n");
                    break;
                }

                else if (stringaRicevuta.equals("?")) 
                {
                    for (String object : note) 
                    {
                        risposta = object;
                        System.out.println("Risposta: " + risposta);
                        out.writeBytes(risposta + "\n");
                    }
                    out.writeBytes("@" + "\n");

                    // for (int i = 0; i < note.size(); i++) 
                    // {
                    //     risposta = note.get(i);
                    //     out.writeBytes(risposta + "\n");  

                    // }

                    // risposta = "@";                   
                    
                }

                else if (stringaRicevuta.equals(null))
                {

                }

                else {
                    note.add(stringaRicevuta);
                    out.writeBytes("OK" + "\n");

                }

            } while (!stringaRicevuta.equals("!"));

            s.close();
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
