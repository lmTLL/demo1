package me.zhengjie.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author groot
 * @date 2019-07-09
 */
@Data
public class DictDetailDTO implements Serializable {

    private Long id;

    /**
     * 字典标签
     */
    private String label;

    /**
     * 字典值
     */
    private String value;

    /**
     * 排序
     */
    private String sort;

    /**
     * 字典id
     */
    private String dictName;
}