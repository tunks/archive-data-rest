
package com.att.archive.restful.model;

/**
 * Document Searchable Interface containing field names
 * @author ebrimatunkara
 */
public interface Searchable {
  String ID_FIELD = "s_id";
  String NAME_FIELD = "_name_";
  String TYPE_FIELD = "_type_";
  String DATE_FIELD = "created_date";
  String TEXT_FIELD = "_t";
  String NUMERIC_FIELD = "_d";
}
