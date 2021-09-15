package com.farasatnovruzov.retrofit1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Valute {
    @SerializedName("@attributes")
    @Expose
    public Attributes_2 attributes2;
    @SerializedName("Nominal")
    @Expose
    public String nominal;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Value")
    @Expose
    public String value;
}
