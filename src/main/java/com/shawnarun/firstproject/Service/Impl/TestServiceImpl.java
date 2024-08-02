package com.shawnarun.firstproject.Service.Impl;

import com.shawnarun.firstproject.Service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    public String getMessage() {
        return "Welcome to Developers Stack";
    }

}
