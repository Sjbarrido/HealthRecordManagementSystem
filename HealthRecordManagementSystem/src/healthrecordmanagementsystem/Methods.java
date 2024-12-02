package healthrecordmanagementsystem;

// Class to represent methods and attributes for a health record
public class Methods {

   // Private fields to store information about a health record
   private String id; // Patient ID
   private String pName; // Patient name
   private String age; // Patient age
   private String gender; // Patient gender
   private String idDoc; // Doctor ID
   private String dName; // Doctor name
   private String status; // Patient's health status
   private String app; // Appointment information

   // Constructor to initialize the health record attributes
   public Methods(String id, String pName, String age, String gender, String idDoc, String dName, String status, String app) {
       this.id = id; // Set patient ID
       this.pName = pName; // Set patient name
       this.age = age; // Set patient age
       this.gender = gender; // Set patient gender
       this.idDoc = idDoc; // Set doctor ID
       this.dName = dName; // Set doctor name
       this.status = status; // Set patient health status
       this.app = app; // Set appointment information
   }

   // Getter and Setter for Doctor ID
   public String getIdDoc() {
       return idDoc; // Return the doctor ID
   }

   public void setIdDoc(String idDoc) {
       this.idDoc = idDoc; // Update the doctor ID
   }

   // Getter and Setter for Status
   public String getStatus() {
       return status; // Return the patient's health status
   }

   public void setStatus(String status) {
       this.status = status; // Update the patient's health status
   }

   // Getter and Setter for Appointment
   public String getApp() {
       return app; // Return the appointment information
   }

   public void setApp(String app) {
       this.app = app; // Update the appointment information
   }

   // Getter and Setter for Patient ID
   public String getId() {
       return id; // Return the patient ID
   }

   public void setId(String id) {
       this.id = id; // Update the patient ID
   }

   // Getter and Setter for Patient Name
   public String getpName() {
       return pName; // Return the patient name
   }

   public void setpName(String pName) {
       this.pName = pName; // Update the patient name
   }

   // Getter and Setter for Age
   public String getAge() {
       return age; // Return the patient age
   }

   public void setAge(String age) {
       this.age = age; // Update the patient age
   }

   // Getter and Setter for Gender
   public String getGender() {
       return gender; // Return the patient gender
   }

   public void setGender(String gender) {
       this.gender = gender; // Update the patient gender
   }

   // Getter and Setter for Doctor Name
   public String getdName() {
       return dName; // Return the doctor name
   }

   public void setdName(String dName) {
       this.dName = dName; // Update the doctor name
   }
}
