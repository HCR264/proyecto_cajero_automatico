public class Billete {
    private float denominacion;
    private int cantidad;

    // Constructor
    public Billete(float denominacion, int cantidad) {
        this.denominacion = denominacion;
        this.cantidad = cantidad;
    }

    // Setters
    public void setDenominacion(int denominacion) {
        this.denominacion = denominacion;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Getters
    public float getDenominacion() {
        return this.denominacion;
    }
    public int getCantidad() {
        return this.cantidad;
    }

    @Override
    public String toString() {
        return String.format("Billete de %s: %d", this.denominacion, this.cantidad);
    }
}
