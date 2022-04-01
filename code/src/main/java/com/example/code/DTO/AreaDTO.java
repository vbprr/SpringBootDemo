package com.example.code.DTO;

import com.example.code.entity.Area;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * DTO object for area. This has list of areas and the number of characters of the area names
 * present in the list of areas.
 */
public class AreaDTO  {
  List<Area> areas;
  long numberOfCharacters;
}
