package com.zy.entity;
import java.io.Serializable;
/***
*   
*/
public class TestGen implements Serializable {
    //
    private String id;
    //
    private String codeId;
    //
    private String name;
    //get set 方法
    public void setId (String  id){
        this.id=id;
    }
    public  String getId(){
        return this.id;
    }
    public void setCodeId (String  codeId){
        this.codeId=codeId;
    }
    public  String getCodeId(){
        return this.codeId;
    }
    public void setName (String  name){
        this.name=name;
    }
    public  String getName(){
        return this.name;
    }
}
