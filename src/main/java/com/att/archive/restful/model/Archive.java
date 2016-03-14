package com.att.archive.restful.model;

/**
 * data archive is class model
 * @author ebrima
 */
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.solr.core.mapping.Dynamic;


@Document
public class Archive extends BaseArchive{
    private byte[]  compressedData;
    private String dataFormat;
    private String compressedType;  
    @Dynamic
    @Field("dynamicMappedField_*")
    private Set<Map<String,Object>> composites;

    public Archive() {
        super();
        composites = new HashSet();
    }

    public byte[] getCompressedData() {
        return compressedData;
    }

    public void setCompressedData(byte[] compressedData) {
        this.compressedData = compressedData;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public String getCompressedType() {
        return compressedType;
    }

    public void setCompressedType(String compressedType) {
        this.compressedType = compressedType;
    }

    public Set<Map<String, Object>> getComposites() {
        return composites;
    }

    public void setComposites(Set<Map<String, Object>> composites) {
        this.composites = composites;
    }
    
    public void addComposite(Map<String, Object> composite){
       this.composites.add(composite);
    }
    
    public void addComposites(Set<Map<String, Object>> objects){
       this.composites.addAll(objects);
    }
}
