/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao.implement;

import test.dao.DataDao;
import test.model.Data;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author rzkypprtm
 */
public class DataDaoImplement extends HibernateUtility implements DataDao {

    @Override
    public List<Object[]> getData(int pageNumber, int pageSize, String sort, String query, String filter) {
        String sql = "";
        if (filter.equalsIgnoreCase("All") ){
            sql = "select * from test"
                   + " order by " + sort
                   + " limit " + pageNumber + ", " + pageSize;
        }else{
            sql = "select * from test where  title like '%" + query + "%' "
                + " and status='" + filter +"' "
                + " order by " + sort
                + " limit " + pageNumber + ", " + pageSize;
        }
        Query executable = createNativeQuery(sql);
        return executable.list();                                
    }

    @Override   
    public List<Data> getTotalData() {
        String sql = "select model from test model";
        Query executable = createQuery(sql);
        return executable.list();
    }
    
}
