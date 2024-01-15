package com.Employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Employee.dto.PositionDTO;
import com.Employee.mapper.PositionMapper;

@Service
public class positionService {
	private PositionMapper positionMapper;

	public positionService(PositionMapper positionMapper) {
		
		this.positionMapper = positionMapper;
	}

	public List<PositionDTO> selectAllPosition() {
		return positionMapper.selectAllPosition();
	}
	
	
}
