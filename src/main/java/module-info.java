module com.mawkish.claybrookrms {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.bson;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.driver.core;


    opens com.mawkish.claybrookrms to javafx.fxml;
    exports com.mawkish.claybrookrms;
    opens com.mawkish.claybrookrms.login to javafx.fxml;
    exports com.mawkish.claybrookrms.login;
}