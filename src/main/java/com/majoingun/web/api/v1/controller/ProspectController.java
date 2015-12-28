package com.majoingun.web.api.v1.controller;

import com.majoingun.domain.Prospect;
import com.majoingun.service.ProspectService;
import com.majoingun.web.api.v1.mapper.ProspectTransportMapper;
import com.majoingun.web.api.v1.transport.ProspectTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
public class ProspectController {

    @Autowired
    private ProspectService prospectService;

    @Autowired
    private ProspectTransportMapper mapper;

    @RequestMapping(value = "/api/majoingun/v1/prospects", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody Response saveNewProspect(@RequestBody ProspectTransport prospectTransport){
        Prospect prospect = mapper.map(prospectTransport);
        prospectService.saveNewProspect(prospect);

        return Response.status(Response.Status.CREATED)
                .entity("Save new prospect successfully")
                .build();
    }
}

