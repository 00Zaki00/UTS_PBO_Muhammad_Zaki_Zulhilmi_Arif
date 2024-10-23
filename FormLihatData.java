import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormLihatData extends Stage {
    
    public FormLihatData() {
        setTitle("Data Kendaraan");
        
        VBox vbox = new VBox();
        ListView<String> listView = new ListView<>();
        
        listView.getItems().addAll(
            "Plat: B1234XX, Jenis: Mobil, Model: Avanza", 
            "Plat: B5678YY, Jenis: Motor, Mesin: 150cc"
        );
        
        vbox.getChildren().add(listView);
        
        Scene scene = new Scene(vbox, 300, 200);
        setScene(scene);
    }
}
