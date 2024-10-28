package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

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
            String risposta = "null";

            do 
            {

                stringaRicevuta = in.readLine(); //stringa ricevuta dal client

                if (stringaRicevuta.equals("!")) 
                {

                }

                if (stringaRicevuta.equals("?")) 
                {

                }

                if (stringaRicevuta.equals("@")) 
                {

                }

                System.out.println("La sringa ricevuta: " + stringaRicevuta);

                out.writeBytes(risposta + "\n"); //stringa da rimandare indietro al client

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
