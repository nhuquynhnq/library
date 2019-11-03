package org.o7planning.sbjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.o7planning.sbjdbc.mapper.Authormapper;
import org.o7planning.sbjdbc.model.author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class AuthorDao extends JdbcDaoSupport {
	@Autowired
    public AuthorDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
	public List<author> getAuthor() {
		
        // Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
        String sql = Authormapper.BASE_SQL;
        Object[] params = new Object[] {};
        Authormapper mapper = new Authormapper();
        List<author> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }
}

