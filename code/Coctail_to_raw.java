package com.company;

public class Coctail_to_raw extends BaseModel {
    int id_cocktail;
    int id_method;

    public Coctail_to_raw(){
    }

    public Coctail_to_raw (int id_cocktail, int id_method){
        this.id_cocktail = id_cocktail;
        this.id_method = id_method;

    }

    public int getId_cocktail() {
        return id_cocktail;
    }

    public void setId_cocktail(int id_cocktail) {
        this.id_cocktail = id_cocktail;
    }

    public int getId_method() {
        return id_method;
    }

    public void setId_method(int id_method) {
        this.id_method = id_method;
    }
}
