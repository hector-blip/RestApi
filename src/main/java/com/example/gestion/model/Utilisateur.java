package com.example.gestion.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String User_name;
    private String User_password;
    private String User_email;

        // Getters and Setters
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getUserName() {
            return User_name;
        }
    
        public void setUserName(String userName) {
            this.User_name = userName;
        }
    
        public String getUserPassword() {
            return User_password;
        }
    
        public void setUserPassword(String userPassword) {
            this.User_password = userPassword;
        }
    
        public String getUserEmail() {
            return User_email;
        }
    
        public void setUserEmail(String userEmail) {
            this.User_email = userEmail;
        }
}
