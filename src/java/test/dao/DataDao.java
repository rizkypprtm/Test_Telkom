/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import test.model.Data;
import java.util.List;

/**
 *
 * @author rzkypprtm
 */
public interface DataDao {
    public List<Object[]> getData(int pageNumber, int pageSize, String sort, String query, String filter);
    public List<Data> getTotalData();
}
