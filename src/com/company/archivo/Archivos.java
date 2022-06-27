package com.company.archivo;

import com.company.model.Animal;
import com.company.model.Cliente;

import java.io.*;
import java.util.ArrayList;

public class Archivos {

    public void sobreescribirArchivoClientes(String archivo, Cliente cliente) {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(cliente);

            objectOutputStream.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarClienteAlFinal(String archivo, Cliente nuevo) {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            int recorrer = 1;
            Cliente aux = null;

            while(recorrer == 1) {
                aux = (Cliente) objectInputStream.readObject();
                clientes.add(aux);
            }
            objectInputStream.close();
        }
        catch(ClassCastException e) {

        }
        catch(EOFException e) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(archivo);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);

                for(int i = 0; i < clientes.size(); i++) {
                    objectOutputStream.writeObject(clientes.get(i));
                }
                objectOutputStream.writeObject(nuevo);

                objectOutputStream.close();
            }
            catch(IOException E) {
                E.printStackTrace();
            }
            catch(Exception E) {
                E.printStackTrace();
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrar(String archivo) {
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            int lectura = 1;
            Cliente cliente = null;

            while(lectura == 1) {
                cliente = (Cliente) objectInputStream.readObject();
                System.out.println(cliente.toString());
            }

            objectInputStream.close();
        }
        catch (ClassCastException e) {
            System.out.println("Clase Incorrecta.");
        }
        catch(EOFException e) {
            System.out.println("Fin del Archivo.");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void agregarAnimales(String archivo,int idCliente, Animal animal) {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Cliente cliente = null;
        Cliente nuevoAnimal = null;
        ArrayList<Cliente> listaClientes1 = new ArrayList<>();
        ArrayList<Cliente> listaClientes2 = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            int lectura = 1;
            boolean flag = false;

            while(lectura == 1) {
                cliente = (Cliente)objectInputStream.readObject();
                if(cliente.getId() != idCliente && flag == false) {
                    listaClientes1.add(cliente);
                }
                else if(cliente.getId() == idCliente) {
                    nuevoAnimal = cliente;
                    nuevoAnimal.addAnimal(animal);
                    flag = true;
                }
                else if(cliente.getId() != idCliente && flag == true) {
                    listaClientes2.add(cliente);
                }
            }
            objectInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(int i = 0; i < listaClientes1.size(); i++) {
                objectOutputStream.writeObject(listaClientes1.get(i));
            }

            objectOutputStream.writeObject(nuevoAnimal);

            for(int j = 0; j < listaClientes2.size(); j++) {
                objectOutputStream.writeObject(listaClientes2.get(j));
            }

            objectOutputStream.close();

        }
        catch (ClassCastException e) {
            System.out.println("Clase Incorrecta.");
        }
        catch(EOFException e) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(archivo);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);

                for(int i = 0; i < listaClientes1.size(); i++) {
                    objectOutputStream.writeObject(listaClientes1.get(i));
                }

                objectOutputStream.writeObject(nuevoAnimal);

                for(int j = 0; j < listaClientes2.size(); j++) {
                    objectOutputStream.writeObject(listaClientes2.get(j));
                }

                objectOutputStream.close();
            }
            catch(IOException E) {
                E.printStackTrace();
            }
            catch(Exception E) {
                e.printStackTrace();
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int devolverUltimoID(String archivo) {
        int id = -1;
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            int lectura = 1;
            Cliente aux = null;

            while(lectura == 1) {
                aux = (Cliente)objectInputStream.readObject();
                id = aux.getId();
            }

            objectInputStream.close();
        }
        catch (ClassCastException e) {
            System.out.println("Clase Incorrecta.");
        }
        catch(EOFException e) {
            System.out.println("Fin del Archivo.");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    public ArrayList<Cliente> devolverClientes(String archivo) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);

            int lectura = 1;
            while(lectura == 1) {
                listaClientes.add((Cliente)objectInputStream.readObject());
            }
            objectInputStream.close();
        }
        catch (ClassCastException e) {
            System.out.println("Clase Incorrecta.");
        }
        catch(EOFException e) {
            System.out.println("Fin del Archivo.");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
}
