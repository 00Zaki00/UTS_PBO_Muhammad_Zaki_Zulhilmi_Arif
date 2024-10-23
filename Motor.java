public class Motor extends Kendaraan {
    private String tipeMesin;

    public Motor(String platNomor, String tipeMesin) {
        super(platNomor, "Motor");
        this.tipeMesin = tipeMesin;
    }

    public String getTipeMesin() {
        return tipeMesin;
    }

    public void setTipeMesin(String tipeMesin) {
        this.tipeMesin = tipeMesin;
    }
}
