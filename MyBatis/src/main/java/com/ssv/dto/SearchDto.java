package com.ssv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchDto {
	private int page;
	private int pageSize;
	private String nameSearch;
}
