package com.example.daina.mapper;

import com.example.daina.entity.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:36 2019/3/17
 */
@Repository
public interface ParkingLotMapper {
    List<ParkingLot> getParkingLotByPage();
    Integer getParkingLotCount();
}
