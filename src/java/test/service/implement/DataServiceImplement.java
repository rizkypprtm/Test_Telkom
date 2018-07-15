/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.service.implement;

import test.dao.DataDao;
import test.model.Data;
import test.service.DataService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rzkypprtm
 */
public class DataServiceImplement implements DataService {

    @Autowired
    DataDao DatasDao;
    
    @Override
    public Map getData (int pageNumber, int pageSize, String sort, String query, String filter) {
        List<Map> listData = new ArrayList<>();
        pageNumber = pageNumber - 1;
        int newPageNumber = pageNumber * pageSize;
        int newPageSize = pageSize + pageNumber;
        List<Object[]> listModel = DatasDao.getData(newPageNumber, newPageSize, sort, query, filter);
        int count = 0;
        for (Object[] datas : listModel){
            Map map = new HashMap();
            map.put("id", Integer.parseInt(datas[0].toString()));
            map.put("title", datas[1].toString());
            map.put("price", Integer.parseInt(datas[2].toString()));
            map.put("status", datas[3].toString());
            count +=1;
            listData.add(map);
        }
        
        int totalData = 0;
        int totalPages = count / pageSize;
        if (totalPages < 1){
            totalPages = 1;
        }
        Map meta = new HashMap();
        meta.put("page", pageNumber + 1);
        meta.put("size", pageSize);
        meta.put("count", count);
        meta.put("totalPages", totalPages);
        meta.put("totalData", totalData);
        Map response = new HashMap();
        if ( listData.size() > 0 ){
            response.put("status", "success");
            response.put("code", 200);
        }else{
            response.put("status", "Data Not Found");
            response.put("code", 404);
        }
        
        response.put("data", listData);
        response.put("meta", meta);
        return response;
    }    
}
