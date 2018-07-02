package com.java_team_project.politictalk.controller;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@Api(value = "Recall", tags = "Recall")
public class Recall {
    public HashMap<String, Object> getPoliticians(@RequestParam String region, @RequestParam String position, @RequestParam String name){
        /*
        정치인 목록을 DB에서 끌어와 리스폰스 해줌
         */
        HashMap<String, Object> politicianList = new HashMap<>();
        return politicianList;
    }

    @ApiOperation(value = "Post Discontent", notes = "Post Discontent")
    @RequestMapping(value = "/recall/discontent", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "region", value = "politician region", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "position", value = "politician position", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "politician name", required = false, dataType = "String", paramType = "query")
    })
    public UUID postDiscontent(){
        /*
        불만 게시글을 DB에 저장하고 UUID를 리턴함
         */
        UUID discontentId = UUID.randomUUID();
        return discontentId;
    }

    @ApiOperation(value = "Get Discontent", notes = "Get Discontent")
    @RequestMapping(value = "/recall/discontent", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String, Object> getDiscontent(@RequestParam UUID discontentId){
        /*
        불만 게시글 id를 받아 DB에서 찾아서 게시글에 대한 내용을 리턴함
         */
        HashMap<String, Object> discontent = new HashMap<>();
        return discontent;
    }

    @ApiOperation(value = "Get Discontent List", notes = "Get Discontent List")
    @RequestMapping(value = "/recall/discontent_list", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String, Object> getDiscontentList(@RequestParam String politicianId){
        /*
        정치인 id를 받아 그 정치인에 대한 불만 게시글 목록을 리턴함
         */
        HashMap<String, Object> discontentList = new HashMap<>();
        return discontentList;
    }

    @ApiOperation(value = "Discontent Opinion", notes = "Add Discontent Opinion")
    @RequestMapping(value = "/recall/opinion", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UUID discontentOpinion(){
        /*
        의견을 받고 의견을 DB에 등록 후 의견 uuid 를 리턴함
         */
        UUID opinionId = UUID.randomUUID();
        return opinionId;
    }

    @ApiOperation(value = "Vote Discontent", notes = "Vote Discontent")
    @RequestMapping(value = "/recall/vote", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void voteDiscontent(){
        /*
        찬성 및 반대 DB 저장
         */
    }
}
