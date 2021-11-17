package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Insumos {

    private int id;
    private String[] Insumos ={"Carlitos duty","Mario Kart 7","San Andrea"};
    private int[] precios ={30000,38000,25000};
    private int stock;

    public Insumos()
    {
    }

    public Insumos(int id, String[] insumos, int[] precios, int stock) {
        this.id = id;
        Insumos = insumos;
        this.precios = precios;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return Insumos;
    }

    public void setInsumos(String[] insumos) {
        Insumos = insumos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumos insumos = (Insumos) o;
        return id == insumos.id && stock == insumos.stock && Arrays.equals(Insumos, insumos.Insumos) && Arrays.equals(precios, insumos.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, stock);
        result = 31 * result + Arrays.hashCode(Insumos);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    @Override
    public String toString() {
        return "Insumos{" +
                "id=" + id +
                ", Insumos=" + Arrays.toString(Insumos) +
                ", precios=" + Arrays.toString(precios) +
                ", stock=" + stock +
                '}';
    }
}
