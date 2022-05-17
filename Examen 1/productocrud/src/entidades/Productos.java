package entidades;

public class Productos {
    private String prod_id;
    private String prod_nombre;
    private double prod_precio_vta;
    private double prod_precio_compra;
    private String prod_tipo;
    private String prod_codigo;
    

    public double getProd_precio_compra() {
        return prod_precio_compra;
    }

    public void setProd_precio_compra(double prod_precio_compra) {
        this.prod_precio_compra = prod_precio_compra;
    }
    
    public double getProd_precio_vta() {
        return prod_precio_vta;
    }

    public void setProd_precio_vta(double prod_precio_vta) {
        this.prod_precio_vta = prod_precio_vta;
    }

    public String getProd_tipo() {
        return prod_tipo;
    }

    public void setProd_tipo(String prod_tipo) {
        this.prod_tipo = prod_tipo;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public String getProd_codigo() {
        return prod_codigo;
    }

    public void setProd_codigo(String prod_codigo) {
        this.prod_codigo = prod_codigo;
    }
    
    




}