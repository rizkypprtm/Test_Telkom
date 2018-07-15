/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.service;

import java.util.Map;

/**
 *
 * @author rzkypprtm
 */
public interface DataService {
    public Map getData(int pageNumber, int pageSize, String sort, String query, String filter);
}
