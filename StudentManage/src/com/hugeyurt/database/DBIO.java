package com.hugeyurt.database;
import java.sql.ResultSet;

public interface DBIO 
{
   public abstract Object toObject(ResultSet rs);
   
}
