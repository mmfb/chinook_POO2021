package com.iade.chinook_EIT2.models.views;

//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iade.chinook_EIT2.models.Genre;

public interface TrackView {
    int getId();
    String getName();
    double getPrice();
    String getMediaType();
    @JsonIgnore
    String getGenre();
    default Genre getGenreType() {
      for (Genre g : Genre.values()) {
         if (getGenre().equals(g.toString())) {
             return g;
         }
      }
      return Genre.Other;
  };

  // With this code Spring Boot automatically transforms the String in the enuneration
  // The String values must match the names of the constants in the enumeration
  // That means there must be an enumeration value for each value on the column
  /* 
     @Enumerated(EnumType.STRING)
     Genre getGenre();
  */
  // The other way Spring Boot does automatic conversion is
  // @Enumerated(EnumType.ORDINAL)
  // This way the column in the database must have numbers (usually the id)
  // Spring Boot will use the order of the constants (number 3 corresponds to the 3rd value)
  // We need to have as many enumeration values as the largest number and we need to maintain the order
   

}
