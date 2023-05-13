public class HamburguesaBase implements Hamburguesa{

    @Override
    public String getDescripcion() {
        return "Pan + Carne";
    }

    @Override
    public double getPrecio() {
        return Precios.PRECIO_PAN + Precios.PRECIO_CARNE;
    }
    
}
