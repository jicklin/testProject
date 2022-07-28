package test.mybatis;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {


    @Delete({
            "delete from account",
            "where acct_id = #{acctId,jdbcType=BIGINT}"
    })
    int deleteAccountByPK(Long acctId);

    @Insert({
            "insert into account (acct_id, cust_id, ",
            "acct_name, contract_no, ",
            "remove_tag, open_date, ",
            "remove_date)",
            "values (#{acctId,jdbcType=BIGINT}, #{custId,jdbcType=BIGINT}, ",
            "#{acctName,jdbcType=VARCHAR}, #{contractNo,jdbcType=VARCHAR}, ",
            "#{removeTag,jdbcType=VARCHAR}, #{openDate,jdbcType=TIMESTAMP}, ",
            "#{removeDate,jdbcType=TIMESTAMP})"
    })
    int insertAccount(Account record);

    @Select({
            "select",
            "acct_id, cust_id, acct_name, contract_no, remove_tag, open_date, remove_date",
            "from account",
            "where acct_id = #{acctId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="acct_id", property="acctId", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="cust_id", property="custId", jdbcType=JdbcType.BIGINT),
            @Result(column="acct_name", property="acctName", jdbcType=JdbcType.VARCHAR),
            @Result(column="contract_no", property="contractNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="remove_tag", property="removeTag", jdbcType=JdbcType.VARCHAR),
            @Result(column="open_date", property="openDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="remove_date", property="removeDate", jdbcType=JdbcType.TIMESTAMP)
    })
    Account selectByPrimaryKey(Long acctId);
}
