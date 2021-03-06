package com.snsoft.dao.mappers;

import com.snsoft.dao.entities.Ccode;
import com.snsoft.dao.entities.CcodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    long countByExample(CcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int deleteByExample(CcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String ccode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int insert(Ccode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int insertSelective(Ccode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    List<Ccode> selectByExampleWithBLOBs(CcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    List<Ccode> selectByExample(CcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    Ccode selectByPrimaryKey(String ccode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Ccode record, @Param("example") CcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") Ccode record, @Param("example") CcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Ccode record, @Param("example") CcodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Ccode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(Ccode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccode
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Ccode record);
}