import java.io.*;

class nodo{
	
	int num=0;
 	String nombre="";
 	nodo sig;
 	
 	void llenar_nodo(nodo nodo_nuevo,int num,String nomb){
 		
 		nodo_nuevo.num=num;
 		nodo_nuevo.nombre=nomb;
 		nodo_nuevo.sig=null;
 	} 
}

class lista{
	nodo l;
    
    void insertar_nodo(int num,String nomb){
        
        nodo nodo_nuevo= new nodo();
        nodo_nuevo.llenar_nodo(nodo_nuevo,num,nomb);
        
        if (l!=null){
        	nodo_nuevo.sig=l;
        }
       	
       	l=nodo_nuevo;
    }

    public String leer_archivo(int num,String nomb) {

    	try {
            
            File archi;
            FileReader lectorArchivo;
            archi = new File("archivo.txt");
            lectorArchivo = new FileReader(archi);
            String l;
            
            try (BufferedReader br = new BufferedReader(lectorArchivo)) {
                
                l = "";
                String aux = "";
                
                try {
                    while (aux != null) {
                        aux = br.readLine();
                        String[] corte = aux.split(",");
                        if (aux != null) {
                            l = l + aux + "\n";
                        } else {
                            break;
                        }
                        try {
                            num=Integer.parseInt(corte[0]);
                            nomb=corte[1];
                            insertar_nodo(num,nomb);
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ab) {
                            System.out.println("Atencion: Revise El Archivo archivo.txt:");
                        }
                    }
                } catch (NullPointerException ab) {
                }
            }
            // archi.delete();
            lectorArchivo.close();
            return l;
        
        } catch (IOException a) {
            System.out.println("Error:" + a.getMessage());
        }
        
        return null;
    }

    void mostrar(nodo aux){
    	
    	if (aux!=null){
    		System.out.println (aux.num+" "+aux.nombre);
       		mostrar(aux.sig);
       	}
    }
}

public class Main{
 
	public static void main (String[] args)throws Exception {

		lista obj= new lista();
 		obj.leer_archivo(0,null);
 		obj.mostrar(obj.l);
 
 	}
}
