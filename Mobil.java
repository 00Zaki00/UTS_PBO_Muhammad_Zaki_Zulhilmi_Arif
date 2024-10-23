public class Mobil extends Kendaraan {
    private String model;

    public Mobil(String platNomor, String model) {
        super(platNomor, "Mobil");
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
