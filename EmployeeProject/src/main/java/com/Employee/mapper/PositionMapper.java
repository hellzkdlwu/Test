package com.Employee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Employee.dto.PositionDTO;

@Mapper
public interface PositionMapper {

	List<PositionDTO> selectAllPosition();

}
