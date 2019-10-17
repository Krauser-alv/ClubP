public class Note
{
    private int id;
    private String titulo;
    private String descripcion;
    private String fecha;
    
    Note()
    {
       
    }
    
    public void setId(int id){this.id=id;
    }
    public void setTitulo(String titulo){this.titulo=titulo;
    }
    public void setDescripcion(String descripcion){this.descripcion=descripcion;
    }
    public void setFecha(String fecha){this.fecha=fecha;
    }
    public int getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
        }
        public String getDescripcion(){
        return descripcion;
        }
        public String getFecha(){
        return fecha;
        }
        
    /**
    public String toString(){
        return String.format("%-10s %1d %5s %5s %5s %n %5s","ID ",id," Titulo: ", titulo, "descrpción: ",descripcion);
    }
    **/
}
