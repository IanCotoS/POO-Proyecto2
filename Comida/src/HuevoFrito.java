public class HuevoFrito extends IngredienteDecorador{

    public HuevoFrito(Hamburguesa newHamburguesa) {
        super(newHamburguesa);
    }

    @Override
    public String getDescripcion() {
        return tempHamburguesa.getDescripcion() + " + Huevo frito";
    }

    @Override
    public double getPrecio() {
       return tempHamburguesa.getPrecio() + Precios.PRECIO_HUEVO_FRITO;
    }
}
