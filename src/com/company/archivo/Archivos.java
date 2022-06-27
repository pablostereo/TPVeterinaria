package com.company.archivo;

import com.company.model.Animal;
import com.company.model.Cliente;

import java.io.*;
import java.util.ArrayList;

public class Archivos {
    public Archivos() {
    }

    public void sobreescribirArchivoClientes(String archivo, Cliente cliente) {
        ObjectOutputStream objectOutputStream = null;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cliente);
            objectOutputStream.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public void cargarClienteAlFinal(String archivo, Cliente nuevo) {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ArrayList clientes = new ArrayList();

        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);
            boolean recorrer = true;
            Cliente aux = null;

            while(recorrer) {
                aux = (Cliente)objectInputStream.readObject();
                clientes.add(aux);
            }

            objectInputStream.close();
        } catch (ClassCastException var11) {
        } catch (EOFException var12) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(archivo);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);

                for(int i = 0; i < clientes.size(); ++i) {
                    objectOutputStream.writeObject(clientes.get(i));
                }

                objectOutputStream.writeObject(nuevo);
                objectOutputStream.close();
            } catch (IOException var9) {
                var9.printStackTrace();
            } catch (Exception var10) {
                var10.printStackTrace();
            }
        } catch (FileNotFoundException var13) {
            var13.printStackTrace();
        } catch (IOException var14) {
            var14.printStackTrace();
        } catch (Exception var15) {
            var15.printStackTrace();
        }

    }

    public void mostrar(String archivo) {
        ObjectInputStream objectInputStream = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);
            boolean lectura = true;
            Cliente cliente = null;

            while(lectura) {
                cliente = (Cliente)objectInputStream.readObject();
                System.out.println(cliente.toString());
            }

            objectInputStream.close();
        } catch (ClassCastException var6) {
            System.out.println("Clase Incorrecta.");
        } catch (EOFException var7) {
            System.out.println("Fin del Archivo.");
        } catch (FileNotFoundException var8) {
            var8.printStackTrace();
        } catch (IOException var9) {
            var9.printStackTrace();
        } catch (Exception var10) {
            var10.printStackTrace();
        }

    }

    public void agregarAnimales(String archivo, int idCliente, Animal animal) {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Cliente cliente = null;
        Cliente nuevoAnimal = null;
        ArrayList<Cliente> listaClientes1 = new ArrayList();
        ArrayList listaClientes2 = new ArrayList();

        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);
            boolean lectura = true;
            boolean flag = false;

            while(true) {
                while(lectura) {
                    cliente = (Cliente)objectInputStream.readObject();
                    if (cliente.getId() != idCliente && !flag) {
                        listaClientes1.add(cliente);
                    } else if (cliente.getId() == idCliente) {
                        nuevoAnimal = cliente;
                        cliente.addAnimal(animal);
                        flag = true;
                    } else if (cliente.getId() != idCliente && flag) {
                        listaClientes2.add(cliente);
                    }
                }

                objectInputStream.close();
                FileOutputStream fileOutputStream = new FileOutputStream(archivo);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);

                int j;
                for(j = 0; j < listaClientes1.size(); ++j) {
                    objectOutputStream.writeObject(listaClientes1.get(j));
                }

                objectOutputStream.writeObject(nuevoAnimal);

                for(j = 0; j < listaClientes2.size(); ++j) {
                    objectOutputStream.writeObject(listaClientes2.get(j));
                }

                objectOutputStream.close();
                break;
            }
        } catch (ClassCastException var17) {
            System.out.println("Clase Incorrecta.");
        } catch (EOFException var18) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(archivo);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);

                int j;
                for(j = 0; j < listaClientes1.size(); ++j) {
                    objectOutputStream.writeObject(listaClientes1.get(j));
                }

                objectOutputStream.writeObject(nuevoAnimal);

                for(j = 0; j < listaClientes2.size(); ++j) {
                    objectOutputStream.writeObject(listaClientes2.get(j));
                }

                objectOutputStream.close();
            } catch (IOException var15) {
                var15.printStackTrace();
            } catch (Exception var16) {
                var18.printStackTrace();
            }
        } catch (FileNotFoundException var19) {
            var19.printStackTrace();
        } catch (IOException var20) {
            var20.printStackTrace();
        } catch (Exception var21) {
            var21.printStackTrace();
        }

    }

    public int devolverUltimoID(String archivo) {
        int id = -1;
        ObjectInputStream objectInputStream = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);
            boolean lectura = true;

            for(Cliente aux = null; lectura; id = aux.getId()) {
                aux = (Cliente)objectInputStream.readObject();
            }

            objectInputStream.close();
        } catch (ClassCastException var7) {
            System.out.println("Clase Incorrecta.");
        } catch (EOFException var8) {
            System.out.println("Fin del Archivo.");
            return id;
        } catch (FileNotFoundException var9) {
            var9.printStackTrace();
        } catch (IOException var10) {
            var10.printStackTrace();
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        return id;
    }

    public ArrayList<Cliente> devolverClientes(String archivo) {
        ArrayList<Cliente> listaClientes = new ArrayList();
        ObjectInputStream objectInputStream = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            objectInputStream = new ObjectInputStream(fileInputStream);
            boolean lectura = true;

            while(lectura) {
                listaClientes.add((Cliente)objectInputStream.readObject());
            }

            objectInputStream.close();
        } catch (ClassCastException var6) {
            System.out.println("Clase Incorrecta.");
        } catch (EOFException var7) {
            System.out.println("Fin del Archivo.");
        } catch (FileNotFoundException var8) {
            var8.printStackTrace();
        } catch (IOException var9) {
            var9.printStackTrace();
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        return listaClientes;
    }
}
