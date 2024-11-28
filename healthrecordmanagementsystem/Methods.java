package healthrecordmanagementsystem;

public class Methods {
   private String id;
   private String pName;
   private String age;
   private String gender;
   private String idDoc;
   private String dName;
   private String status;
   private String app;

   public Methods(String id, String pName, String age, String gender, String idDoc, String dName, String status, String app){
       this.id = id;
       this.pName = pName;
       this.age = age;
       this.gender = gender;
       this.idDoc = idDoc;
       this.dName = dName;
       this.status = status;
       this.app = app;
   }

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getidDoc() {
        return idDoc;
    }

    public void setidDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
   
 
}
