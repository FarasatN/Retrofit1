package com.farasatnovruzov.retrofit1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.xml.sax.ext.Attributes2;

import java.util.List;

public class ValType {

    @SerializedName("@attributes")
    @Expose
    public Attributes_2 attributes2;
    @SerializedName("Valute")
    @Expose
    public List<Valute> valute = null;
}
