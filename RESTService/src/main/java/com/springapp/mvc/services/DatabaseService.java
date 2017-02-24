package com.springapp.mvc.services;

import com.springapp.mvc.dao.TableDao;
import com.springapp.mvc.models.TableRow;
import com.springapp.mvc.models.TableHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    private TableDao tableDao;

    public int executeUpdate(String sqlQuery){
        return tableDao.executeUpdate(sqlQuery);
    }

    public List<TableRow> getRows(String sqlQuery){
        return tableDao.getRows(sqlQuery);
    }

    public List<TableHeader> getColumnNames(String sqlQuery){
        return tableDao.getColumnNames(sqlQuery);
    }
}
