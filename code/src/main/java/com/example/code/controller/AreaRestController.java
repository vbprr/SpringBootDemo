package com.example.code.controller;


import com.example.code.DTO.AreaDTO;
import com.example.code.entity.Area;
import com.example.code.service.IPlAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller class for our application.
 */

@RestController
@RequestMapping("/api/area")
public class AreaRestController {

  @Autowired
  IPlAreaService areaService;

  /**
   * Persists an entry into the area table.
   * @param area
   * @return
   */
  @PostMapping("")
  public ResponseEntity saveArea(@RequestBody Area area) {
    return  new ResponseEntity(areaService.create(area), HttpStatus.CREATED);
  }

  /**
   * Returns the area name for the provided postalcode.
   * @param pincode
   * @return
   */
  @GetMapping("/{pincode}")
  public ResponseEntity<Area> getArea(@PathVariable long pincode) {
    Area area = areaService.getArea(pincode);
    if (area == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(area, HttpStatus.FOUND);
  }

  /**
   * Gets the list of areas that fall within the given postal codes ( both inclusive).
   * Request url format : localhost:8080/api/area/{start_postalCode}/{End_postalCode}
   * Example url : localhost:8080/api/area/0/9
   * Output would be list of areas sorted in alphabetical order and count of number of characters
   * of all the area names
   * @param start
   * @param end
   * @return
   */
  @GetMapping("{start}/{end}")
  public AreaDTO getAreasBetween(@PathVariable long start, @PathVariable long end) {
    return areaService.findAreasInRange(start,end);
  }
}
