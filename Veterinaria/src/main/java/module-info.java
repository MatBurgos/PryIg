module com.veterinaria.veterinaria {
    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.persistence;
    requires java.sql;     
    opens com.veterinaria.veterinaria to javafx.fxml;
    exports com.veterinaria.veterinaria;
    requires org.hibernate.orm.core;
    requires java.base;
      
}
