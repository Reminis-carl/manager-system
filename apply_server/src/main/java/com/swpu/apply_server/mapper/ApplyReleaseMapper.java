package com.swpu.apply_server.mapper;

import com.swpu.apply_server.domain.Apply;
import com.swpu.apply_server.vo.ApplyVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ApplyReleaseMapper {

    /**
     * 查询所有应用信息
     * @return
     */
    @Select("SELECT id,apply_name,icon,apply_system,description,state,create_time,update_time FROM apply where (state='1' or state = '-2' or state = '2') limit #{page},#{limit}")
    List<Apply> findAllApply(ApplyVo applyVo);

    /**
     * 查询所有应用数量
     * @return
     */
    @Select("select count(1) from apply where (state='1' or state = '-2' or state = '2')")
    int countAllApply();

    /**
     * 通过应用名称查询
     * @return
     */
    @Select("select id,apply_name,icon,apply_system,description,state,create_time,update_time from apply where apply_name = #{applyName} and (state='1' or state = '-2' or state = '2') limit #{page},#{limit}")
    List<Apply> findByApplyName(String applyName, @Param("page") Integer page, @Param("limit") Integer limit);

    /**
     * 通过应用名称查询应用条数
     * @param applyName
     * @return
     */
    @Select("select count(1) from apply where apply_name = #{applyName} and (state='1' or state = '-2' or state = '2') ")
    int countFindApplyByName(String applyName);
    /**
     * 通过应用系统查询
     * @param applySystem
     * @return
     */
    @Select("select id,apply_name,icon,apply_system,description,state,create_time,update_time from apply where apply_system = #{applySystem} and (state='1' or state = '-2' or state = '2')  limit #{page},#{limit}")
    List<Apply> findByApplySystem(String applySystem,@Param("page") Integer page,@Param("limit") Integer limit);
    /**
     * 通过应用系统查询应用条数
     * @param applySystem
     * @return
     */
    @Select("select count(1) from apply where apply_system = #{applySystem} and (state='1' or state = '-2' or state = '2') ")
    int countFindApplyBySystem(String applySystem);
    /**
     * 应用名称和应用系统查询
     * @param applyName
     * @param applySystem
     * @return
     */
    @Select("select id,apply_name,icon,apply_system,description,state,create_time,update_time from apply where apply_name = #{applyName} and apply_system = #{applySystem} and (state='1' or state = '-2' or state = '2')  limit #{page},#{limit}")
    List<Apply> findByAppNameAndBySystem(String applyName,String applySystem,@Param("page") Integer page,@Param("limit") Integer limit);

    /**
     * 通过应用系统查询和应用名称应用条数
     * @param applySystem
     * @return
     */
    @Select("select count(1) from apply where apply_name = #{applyName} and apply_system = #{applySystem} and (state='1' or state = '-2' or state = '2') ")
    int countFindApplyByNameAndSystem(String applyName,String applySystem);

    /**
     * 应用发布
     * @param id
     */
    @Update("update apply set state = '2' where id = #{id}")
    void release(String id);

    /**
     * 应用下架
     * @param id
     */
    @Update("update apply set state = '-2' where id = #{id}")
    void soldOut(String id);

    /**
     * 查看应用状态
     * @param id
     * @return
     */
    @Select("select state from apply where id = #{id}")
    String applyState(String id);
}
