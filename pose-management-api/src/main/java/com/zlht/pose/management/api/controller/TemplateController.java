package com.zlht.pose.management.api.controller;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zlht.pose.management.api.service.TemplateServicesI;
import com.zlht.pose.management.api.utils.Result;
import com.zlht.pose.management.dao.entity.Template;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "模板管理", description = "模板管理")
public class TemplateController extends BaseController {

    private static final Logger logger = LogManager.getLogger(TemplateController.class);
    @Autowired
    TemplateServicesI templateServices;


    /**
     * 查询模板信息
     *
     * @return template
     */
    @ApiOperation(value = "查询模板", notes = "查询模板")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "小程序审核进度(0已部署，1审核中)", dataTypeClass = int.class),
            @ApiImplicitParam(name = "pageNum", value = "页数(默认1)", dataTypeClass = int.class),
            @ApiImplicitParam(name = "pageSize", value = "页大小(默认10)", dataTypeClass = int.class),
            @ApiImplicitParam(name = "keyword", value = "模板名", dataTypeClass = String.class)
    })
    @GetMapping(value = "/getTemplate")
    @ResponseStatus(HttpStatus.OK)
    public Result<Template> queryTemplateList(@RequestParam(required = false, defaultValue = "-1") int status,
                                              @RequestParam(required = false, defaultValue = "1") int pageNum,
                                              @RequestParam(required = false, defaultValue = "10") int pageSize,
                                              @RequestParam(required = false) String keyword) {

        Result result = checkPageParams(pageNum, pageSize);
        if (!result.checkResult()) {
            return result;
        }
        return templateServices.queryTemplateList(pageNum, pageSize, status, keyword);
    }

    /**
     * 创建模板
     *
     * @return Template
     */
    @ApiOperation(value = "创建模板", notes = "创建模板")
    @PostMapping(value = "/createTemplate")
    @ResponseStatus(HttpStatus.OK)
    @JsonIgnoreProperties(value = "id")
    public Result<Template> createTemplate(@RequestBody Template template) {
        Map<String, Object> map = templateServices.createTemplate(template);
        return returnDataList(map);
    }

    /**
     * 更新模板
     *
     * @return Template
     */
    @ApiOperation(value = "更新模板", notes = "更新模板")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "需要更新的模板ID", required = true, dataTypeClass = int.class)
    })
    @PutMapping(value = "/updateTemplate")
    @ResponseStatus(HttpStatus.OK)
    public Result<Template> updateTemplate(@RequestParam int id,
                                           @RequestBody Template template) {
        Map<String, Object> map = templateServices.updateTemplate(id, template);
        return returnDataList(map);
    }

    /**
     * 删除模板
     *
     * @return Template
     */
    @ApiOperation(value = "删除模板", notes = "删除模板")
    @DeleteMapping(value = "/deleteTemplate")
    @ResponseStatus(HttpStatus.OK)
    public Result<Template> deleteTemplate(@RequestParam int id) {
        Map<String, Object> map = templateServices.deleteTemplate(id);
        return returnDataList(map);
    }
}
