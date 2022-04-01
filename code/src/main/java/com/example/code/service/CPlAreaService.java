package com.example.code.service;

import com.example.code.DTO.AreaDTO;
import com.example.code.entity.Area;
import com.example.code.repository.IPlAreaRepository;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for area.
 */
@Service
public class CPlAreaService implements IPlAreaService{
  @Autowired
  IPlAreaRepository areaRepository;

  /**
   * Persists area in to the DB
   * @param area
   * @return
   */
  @Override
  public Area create(Area area) {
    return areaRepository.save(area);
  }

  /**
   * Returns the area for a particular pincode.
   * @param pincode
   * @return
   */
  @Override
  public Area getArea(long pincode) {
    return areaRepository.findByPostCode(pincode);
  }

  /**
   * Returns AreaDTO object with list of areas in between start and end postal codes ( both inclusive)
   * Calculates the number of characters in the area names and sets it to the field in AreaDTO.
   * @param start
   * @param end
   * @return
   */
  @Override
  public AreaDTO findAreasInRange(long start, long end) {
    AreaDTO areaDTO = new AreaDTO();
    List<Area> areas = areaRepository.findWithinRange(start,end);
    areas.sort(Comparator.comparing(Area::getAreaName));
    areaDTO.setAreas(areas);
    areaDTO.setNumberOfCharacters(areas.stream().mapToInt(p -> p.getAreaName().length()).sum());
    return areaDTO;
  }
}
