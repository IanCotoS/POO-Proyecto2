package ModelSalon;

public class FactoryMesas {
    public static int cantMesas=10; // filas matriz 
    public static Mesas[][] getMesas() {
        Mesas[][] mesas = new Mesas[cantMesas/2][cantMesas/2];
        int cont = 0;
        for (int i=0; i< cantMesas/2; i++){
            for (int j=0; j< cantMesas/2; j++){
                mesas[i][j] = new Mesas(cont,i,j);
                cont++;
            }
        }
        return mesas;
    }

}
