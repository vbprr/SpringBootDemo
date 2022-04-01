package com.example.code.service;

import com.example.code.DTO.AreaDTO;
import com.example.code.entity.Area;

/**
 * Service interface for Area
 */
public interface IPlAreaService {

  Area create(Area area);
  Area getArea(long pincode);
  AreaDTO findAreasInRange(long start,long end);
}
