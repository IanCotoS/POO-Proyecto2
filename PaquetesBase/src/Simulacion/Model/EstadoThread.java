package Simulacion.Model;

public class EstadoThread extends Thread{
    
    private boolean activo;

    EstadoThread(){
        activo = true;
    }

    public void setEstado(boolean estado){
        activo = estado;
    }

    public boolean getEstado(){
        return activo;
    }

    @Override
    public void run(){
        while (true){
            if (activo){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
