package com.example.daina.mapper;

import com.example.daina.entity.Driveway;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:50 2019/3/23
 */
@Repository
public interface DrivewayMapper {

    List<Driveway> getDrivewayList(@Param("drivewayStatus") String drivewayStatus, @Param("drivewayName") String drivewayName);
}
