package com.example.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/**
 * Entity class for Area.
 * We have created a single class to hold postal code and area name to simplify things.
 * We went in with an assumption that two places cannot have the same postal code.Hence postal code
 * is a primary key in this case.
 * There can be a scenario where in two areas(mostly in different cities) can have different postal
 * codes. Hence we did not have any unique constraint on area field.
 * We had the default transalation of java feild name to column name. In this case, the table name
 * would be area and column names would be Postal_code and areaName.
 */
public class Area {
  @Id
  long postCode;
  String areaName;
}
