/**
 * Stores information about a place including its name, municipality ,province and population .
 * Mpho hadebe
 * HDBMPH001
 * 19/03/2026
 */
public class PlaceNameEntry{
      private String placename;
      private String municipality;
      private String province;
      private int population;

      /**
       * construct a new placeNameEntry with the specified details.
       * @param  placename
       * @param  municipality
       * @param  province
       * @param poulation 
       * 
       */
      public PlaceNameEntry(String placename ,String municipality, String province, int population){
        this.placename = placename;
        this.municipality =  municipality;
        this.province = province;
        this.population = population;

      }

      //getters and setters
      public void setMunicipality(String muni){
        this.municipality = muni ;

      }

      public void setPlaceName(String placename){
        this.placename = placename  ;

      }
      public void setProvince(String province){
        this.province = province;

      }

      public void setPopulation(int population ){
        this.population = population ;

      }

      //getters
       public String getMunicipality(){
        return this.municipality ;

      }

      public String  getPlaceName(){
        return this.placename   ;

      }
      public String  getProvince(String province){
        return this.province ;

      }

      public int getPopulation(int population ){
        return this.population  ;

      }

      public String toString(){
        return this.placename + ", " + this.municipality+ ", "+ this.province+ ", "+this.population + ".";
      }

      
      
      
}
