package com.hostel.admin.service;

import com.hostel.admin.dto.RequestDto;
import com.hostel.admin.entity.Request;

import java.util.List;

public interface RequestService {
    RequestDto createRequest(Request requestDto);

    List<RequestDto> getRequest();

    RequestDto getRequestById(Long id);

    void removeRequest(Long id);

    RequestDto addFeedback(Long id, String feedback);
}

