package GUI;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
    Configuration is saved in file as a number of Strings:
 */

public class Configuration implements Serializable {
    private static final long serialVersionUID = 42L;
    private String sourceFileLocation;
    private String targetFileLocation;
    private String databaseFileLocation;
    private String tableName;
    private String removeCharacters;

    public String getSourceFileLocation() {
        return sourceFileLocation;
    }

    public void setSourceFileLocation(String sourceFileLocation) {
        this.sourceFileLocation = sourceFileLocation;
    }

    public String getTargetFileLocation() {
        return targetFileLocation;
    }

    public void setTargetFileLocation(String targetFileLocation) {
        this.targetFileLocation = targetFileLocation;
    }

    public String getDatabaseFileLocation() {
        return databaseFileLocation;
    }

    public void setDatabaseFileLocation(String databaseFileLocation) {
        this.databaseFileLocation = databaseFileLocation;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRemoveCharacters() {
        return removeCharacters;
    }

    public void setRemoveCharacters(String removeCharacters) {
        this.removeCharacters = removeCharacters;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(this.sourceFileLocation).append('\n').
                append(this.targetFileLocation).append('\n').append(this.databaseFileLocation).
                append('\n').append(this.tableName).append('\n').append(this.removeCharacters).toString();
    }

    public void writeToFile(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("Config.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(this);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream("Config.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Configuration newConfiguration = (Configuration)objectInputStream.readObject();

            this.databaseFileLocation = newConfiguration.getDatabaseFileLocation();
            this.removeCharacters = newConfiguration.getRemoveCharacters();
            this.sourceFileLocation = newConfiguration.getSourceFileLocation();
            this.targetFileLocation = newConfiguration.getTargetFileLocation();
            this.tableName = newConfiguration.getTableName();

            objectInputStream.close();
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
