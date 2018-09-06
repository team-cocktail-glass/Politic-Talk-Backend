package com.java_team_project.politictalk.controller.account;

import com.java_team_project.politictalk.json.AccountLongin;
import com.java_team_project.politictalk.model.account.Account;
import com.java_team_project.politictalk.model.account.AccountRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value = "Account", tags = "Account")
public class Login {
    @Autowired
    private AccountRepository accountRepository;

    @ApiOperation(value = "Log in", notes = "Log in")
    @RequestMapping(value = "/account/login", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Account ID", required = true, dataType = "string", paramType = "json"),
            @ApiImplicitParam(name = "password", value = "Account password", required = true, dataType = "string", paramType = "json")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "login success")
    })
    public String login(@RequestBody @Valid final AccountLongin accountLongin) {
        Account account = accountRepository.findOne(accountLongin.getId());
        if(account.getPassword() == accountLongin.getPassword()){
            return account.getId();
        }
        else{
            return "Fail";
        }
    }
}
