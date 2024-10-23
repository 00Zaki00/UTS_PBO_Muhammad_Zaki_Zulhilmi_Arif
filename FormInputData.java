import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FormInputData extends Application {
    private List<Kendaraan> kendaraanList = new ArrayList<>(); // Menyimpan daftar kendaraan
    private ListView<String> listViewKendaraan = new ListView<>(); // ListView untuk menampilkan kendaraan

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Form Input Data Bengkel");

        // GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        // Label Selamat Datang
        Label welcomeLabel = new Label("Selamat datang di Bengkel Phoenix");
        GridPane.setConstraints(welcomeLabel, 0, 0, 2, 1); // Span across 2 columns

        // Input Plat Nomor
        Label platNomorLabel = new Label("Plat Nomor:");
        GridPane.setConstraints(platNomorLabel, 0, 1);
        TextField platNomorInput = new TextField();
        GridPane.setConstraints(platNomorInput, 1, 1);

        // Input Keperluan (Servis, Ganti Oli, dll)
        Label keperluanLabel = new Label("Keperluan:");
        GridPane.setConstraints(keperluanLabel, 0, 2);
        ComboBox<String> keperluanInput = new ComboBox<>();
        keperluanInput.getItems().addAll("Servis", "Ganti Oli", "Tune Up", "Ganti Ban");
        GridPane.setConstraints(keperluanInput, 1, 2);

        // Input Bagian Kendaraan (Mesin, Rem, Suspensi, dll)
        Label bagianLabel = new Label("Bagian Kendaraan:");
        GridPane.setConstraints(bagianLabel, 0, 3);
        ComboBox<String> bagianInput = new ComboBox<>();
        bagianInput.getItems().addAll("Mesin", "Rem", "Suspensi", "Kaki-Kaki");
        GridPane.setConstraints(bagianInput, 1, 3);

        // Pilihan Metode Pembayaran (RadioButton)
        Label pembayaranLabel = new Label("Metode Pembayaran:");
        GridPane.setConstraints(pembayaranLabel, 0, 4);
        ToggleGroup pembayaranGroup = new ToggleGroup();
        RadioButton tunaiButton = new RadioButton("Tunai");
        RadioButton nonTunaiButton = new RadioButton("Non-Tunai");
        tunaiButton.setToggleGroup(pembayaranGroup);
        nonTunaiButton.setToggleGroup(pembayaranGroup);
        GridPane.setConstraints(tunaiButton, 1, 4);
        GridPane.setConstraints(nonTunaiButton, 1, 5);

        // Pilihan Waktu Pengambilan (DatePicker)
        Label tanggalLabel = new Label("Tanggal Pengambilan:");
        GridPane.setConstraints(tanggalLabel, 0, 6);
        DatePicker tanggalPengambilan = new DatePicker();
        GridPane.setConstraints(tanggalPengambilan, 1, 6);

        // Pilihan Layanan Tambahan (CheckBox)
        Label layananTambahanLabel = new Label("Layanan Tambahan:");
        GridPane.setConstraints(layananTambahanLabel, 0, 7);
        CheckBox TambahanginBox = new CheckBox("Tambah Angin");
        CheckBox polesBox = new CheckBox("Poles");
        GridPane.setConstraints(TambahanginBox, 1, 7);
        GridPane.setConstraints(polesBox, 1, 8);

        // Tombol Simpan
        Button simpanButton = new Button("Simpan");
        GridPane.setConstraints(simpanButton, 1, 9);
        simpanButton.setOnAction(e -> {
            String platNomor = platNomorInput.getText();
            String keperluan = keperluanInput.getValue();
            String bagian = bagianInput.getValue();
            RadioButton selectedPembayaran = (RadioButton) pembayaranGroup.getSelectedToggle();
            String pembayaran = selectedPembayaran != null ? selectedPembayaran.getText() : "Tidak Dipilih";
            String tanggal = tanggalPengambilan.getValue() != null ? tanggalPengambilan.getValue().toString() : "Tidak Dipilih";
            boolean TambahAngin = TambahanginBox.isSelected();
            boolean poles = polesBox.isSelected();

            // Buat objek Mobil atau Motor berdasarkan input
            Kendaraan kendaraan;
            if (keperluan.equals("Servis") || keperluan.equals("Tune Up")) {
                kendaraan = new Mobil(platNomor, "Avanza"); // Contoh menambahkan mobil
            } else {
                kendaraan = new Motor(platNomor, "150cc"); // Contoh menambahkan motor
            }

            // Tambahkan kendaraan ke list dan update ListView
            kendaraanList.add(kendaraan);
            listViewKendaraan.getItems().add(kendaraan.getInfo());

            // Reset form input
            platNomorInput.clear();
            keperluanInput.setValue(null);
            bagianInput.setValue(null);
            pembayaranGroup.selectToggle(null);
            tanggalPengambilan.setValue(null);
            TambahanginBox.setSelected(false);
            polesBox.setSelected(false);
        });

        // ListView untuk menampilkan data kendaraan yang sudah disimpan
        Label lihatDataLabel = new Label("Data Kendaraan yang Tersimpan:");
        GridPane.setConstraints(lihatDataLabel, 0, 10);
        GridPane.setConstraints(listViewKendaraan, 0, 11, 2, 1); // Span across 2 columns

        // Tambah semua elemen ke grid
        gridPane.getChildren().addAll(
            welcomeLabel, platNomorLabel, platNomorInput, keperluanLabel, keperluanInput, bagianLabel, bagianInput,
            pembayaranLabel, tunaiButton, nonTunaiButton, tanggalLabel, tanggalPengambilan, layananTambahanLabel,
            TambahanginBox, polesBox, simpanButton, lihatDataLabel, listViewKendaraan
        );

        // Tampilkan scene
        Scene scene = new Scene(gridPane, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
