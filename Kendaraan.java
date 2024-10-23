public class Kendaraan {
    private String platNomor;
    private String jenisKendaraan;

    public Kendaraan(String platNomor, String jenisKendaraan) {
        this.platNomor = platNomor;
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }
}
