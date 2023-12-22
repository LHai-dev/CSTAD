package com.henghai.productmanagement.api.image;

import org.apache.ibatis.jdbc.SQL;

public class ImageProvider {
   public String buildSelectSql(){
       return new
               SQL(){{
                   SELECT("*");
                   FROM("images");
               }}.toString();
   }
}
