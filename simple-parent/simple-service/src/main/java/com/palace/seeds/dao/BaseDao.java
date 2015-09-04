package com.palace.seeds.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import com.palace.seeds.helper.TableConst;


@Repository
public class BaseDao implements IBaseDao{
	
	@Resource(name="dataSource")
	private DataSource dataSource;
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	 
	public int execute(String sql){
		return jdbcTemplate.update(sql);
	}
	//查询根据sql查询一行内容放入到map中
	public Map<String,Object> queryForMap(String sql,Object ...args){
		if(TableConst.SHOWSQL)
			showSql(sql,args);
		return jdbcTemplate.queryForMap(sql, args);
	}
	//根据sql查询多行,每一行放入到一个map中
	public List<Map<String,Object>> queryForListMap(String sql,Object ...args){
		if(TableConst.SHOWSQL)
			showSql(sql,args);
		return jdbcTemplate.queryForList(sql,args);
	}
	 //根据表名称和id获取一行内容放入到map中
	public Map<String,Object> findById(String tableName,String id){
		 return findById(tableName,id,"");
	}
	//根据id，表名称和指定列名称查询一行数据放入到map中
	public Map<String,Object> findById(String tableName,String id,String ...columns){
		boolean flag=false;
		StringBuilder sb= new StringBuilder(" select ");
		for(int i=0;i<columns.length;i++){
			flag=true;
			sb.append(columns[i]).append(",");
		}
		String sql=sb.toString();
		if(flag)
			sql=sql.substring(0,sql.length()-1);
		else{
			sql+="* ";
		}
		if(TableConst.SHOWSQL)
			showSql(sql+" from "+tableName+" where id="+id, "");
		return jdbcTemplate.queryForMap(sql+" from "+tableName+" where id="+id);
	}
/*	public Map<String,Object> getPage(String totalSql,String objSql,Object ...args){
		Map<String,Object> map=new java.util.HashMap<String, Object>();
		map.put(ConstVal.TOTAL,queryForLong(totalSql,args));
		map.put(ConstVal.ROWS,queryForListMap(objSql, args));
		return map;
	}*/

	//根据sql和多个条件查询唯一值，且值得类型是long
	 public Long queryForLong(String sql,Object ...args){
		 return queryForObj(sql,Long.class, args);
	 }
	 
	public <T>  Object queryForObj(String sql,ResultSetExtractor<T> r){
		 return  this.jdbcTemplate.query(sql,r);
	}
	public  <T> T queryForObj(String sql,Class<T> returnType , Object ...args){
		Connection con = DataSourceUtils.getConnection(dataSource);
		PreparedStatement ps=null;
		try {
			if(TableConst.SHOWSQL)
				showSql(sql, args);
			ps = con.prepareStatement(sql);
			fillArgs(ps, args);
			if(ps.execute()){
				java.sql.ResultSet rs = ps.getResultSet(); 
				ResultSetMetaData resMetaData = rs.getMetaData();
				if (resMetaData.getColumnCount() > 1) {
					throw new RuntimeException("返回的列个数为："+resMetaData.getColumnCount());
				}
				Object obj=null;
				while(rs.next())
					obj= JdbcUtils.getResultSetValue(rs,1,returnType);
				return (T) obj;//注意null 没有和条件匹配的结果等。
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DataSourceUtils.releaseConnection(con, dataSource);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	//根据表名称，sql和条件更新一行数据的值
	public Integer update(String tableName,String sql,String condition){
		StringBuilder sb=new StringBuilder();
		sb.append("update ").append(tableName).append(" set ").append(sql).append(" where ").append(condition);
		if(TableConst.SHOWSQL)
			showSql(sb.toString(),"");
		return jdbcTemplate.update(sb.toString());
	}
	
	private void fillArgs(PreparedStatement ps,Object ...args){
			try {
				for(int i=0;i<args.length;i++){
					ps.setObject(i+1,args[i]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	private void showSql(String sql,Object...args){
		if(args!=null){
			for(int i=0;i<args.length;i++){
				sql=sql+":::::para"+i+"="+args[i];
			}
			System.out.println(sql);
		}
	}

	//根据map中的参数名称和值生成插入语句
	public boolean getInsertSql(Map<String,Object> params){
		StringBuilder sb=new StringBuilder();
		sb.append("insert into ").append(params.get(TableConst.TABLENAME)).append(" (");
		Object[] objPara=new Object[params.size()];
		StringBuilder tmpSb=new StringBuilder(" values(");
		int i=0;
		for(Map.Entry<String,Object> entry: params.entrySet()){
			sb.append(entry.getKey()).append(",");
			tmpSb.append("?,");
			 objPara[i]=entry.getValue();
			 i++;
		}
		
		String sql=sb.toString();
		sql=sql.substring(0,sql.length()-1)+") "+tmpSb.toString().substring(0,tmpSb.toString().length()-1)+")";
		params.put(TableConst.SQL, sql);
		params.put(TableConst.SQLPARAMS,objPara);
		return true;
	}
	
	//根据插入语句执行插入动作
	public Long insert(String sql,Object...args){
		Connection con=null;
		PreparedStatement ps=null;
		try {
			if(TableConst.SHOWSQL)
				showSql(sql,args);
			con = dataSource.getConnection();
			ps= con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			fillArgs(ps, args);
			if(ps.execute()){
				return (Long)JdbcUtils.getResultSetValue(ps.getResultSet(),1,Long.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DataSourceUtils.releaseConnection(con, dataSource);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0l;
	}
	
	public Long save(Map<String,Object> params) {
		getInsertSql(params);
		return insert((String)params.get(TableConst.SQL),(Object[])params.get(TableConst.SQLPARAMS));
	}
}
