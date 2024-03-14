package com.hostel.admin.service.serviceImpl;

import com.hostel.admin.dto.RequestDto;
import com.hostel.admin.entity.Request;
import com.hostel.admin.repository.RequestRepo;
import com.hostel.admin.service.RequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RequestRepo requestRepo;

    @Override
    public RequestDto createRequest(Request requestDto) {
        Request request = modelMapper.map(requestDto, Request.class);
        request.setFeedback("none");
        Request savedRequest = requestRepo.saveAndFlush(request);
        RequestDto requestCreated = modelMapper.map(savedRequest, RequestDto.class);
        return requestCreated;
    }

    public List<RequestDto> getRequest() {
        List<Request> requests = requestRepo.findAll();
        List<RequestDto> requestDtos = requests.stream().map(request -> modelMapper.map(request, RequestDto.class)).collect(Collectors.toList());
        return requestDtos;
    }

    public RequestDto getRequestById(Long id) {
        Optional<Request> request = requestRepo.findById(id);
        RequestDto requestDto = modelMapper.map(request, RequestDto.class);
        return requestDto;
    }

    @Override
    public void removeRequest(Long id) {
        requestRepo.deleteById(id);
    }

    @Override
    public RequestDto addFeedback(Long id, String feedback) {
        Optional<Request> getRequest = requestRepo.findById(id);
        Request request = getRequest.get();
        request.setFeedback(feedback);
        request = requestRepo.saveAndFlush(request);
        RequestDto requestDto = modelMapper.map(request, RequestDto.class);
        return requestDto;
    }
}
