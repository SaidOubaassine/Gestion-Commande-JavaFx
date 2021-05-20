module gestiondeCommande {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;
	requires mysql.connector;


	
	opens application to javafx.graphics, javafx.fxml, javafx.base,javafx.controls;
	opens controller to javafx.graphics, javafx.fxml, javafx.base,javafx.controls, mysql.connector;
	opens connecte to javafx.graphics, javafx.fxml, javafx.base,javafx.controls;
}
