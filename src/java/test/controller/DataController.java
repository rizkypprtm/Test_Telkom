/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.controller;

import com.google.gson.Gson;
import test.service.DataService ;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rzkypprtm
 */
@Controller
public class DataController {
    
    @Autowired
    DataService dataService;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    String onLoadIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    String getData(int pageNumber, int pageSize, String sort, String query, String filter){
        Map map = dataService.getData(pageNumber, pageSize, sort, query,  filter  );
        return new Gson().toJson(map);
    }
    
}
