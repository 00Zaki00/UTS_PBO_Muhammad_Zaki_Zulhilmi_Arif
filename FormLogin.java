import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FormLogin extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Form Login");

        // Layout grid
        GridPane gridPane = new GridPane();
        
        // Elemen UI
        Label labelUsername = new Label("Username:");
        TextField txtUsername = new TextField();
        Label labelPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();
        Button btnLogin = new Button("Login");

        // Load gambar
        Image image = new Image("file:E:/Phoenix.png"); // Ganti dengan nama file dan ekstensi yang sesuai
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100); // Atur lebar gambar
        imageView.setFitHeight(100); // Atur tinggi gambar
        imageView.setPreserveRatio(true); // Mempertahankan rasio gambar

        // Tambah ke gridPane
        gridPane.add(imageView, 0, 0, 2, 1); // Menambahkan gambar ke grid
        gridPane.add(labelUsername, 0, 1);
        gridPane.add(txtUsername, 1, 1);
        gridPane.add(labelPassword, 0, 2);
        gridPane.add(txtPassword, 1, 2);
        gridPane.add(btnLogin, 1, 3);

        btnLogin.setOnAction(e -> {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            
            // Cek login sederhana (untuk demo)
            if (username.equals("admin") && password.equals("1234")) {
                new FormInputData().start(new Stage()); // Buka form input data
                primaryStage.close(); // Tutup login form
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username atau password salah!");
                alert.show();
            }
        });

        // Set scene dan tampilkan
        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
