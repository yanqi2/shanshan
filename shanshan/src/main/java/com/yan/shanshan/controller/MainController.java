package com.yan.shanshan.controller;

import com.yan.shanshan.dto.OptionDTO;
import com.yan.shanshan.model.Option;
import com.yan.shanshan.service.OperationService;
import com.yan.shanshan.service.OptionService;
import com.yan.shanshan.service.SourceService;
import com.yan.shanshan.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController()
public class MainController {
    @Autowired
    private OptionService optionService;

    @Autowired
    private OperationService operationService;

    @Autowired
    private SourceService sourceService;

    @PostMapping("/operate")
    public boolean operate(Integer id, String txt) {
        Option option = optionService.get(id);
        sourceService.update(option.getScore());
        optionService.touch(id);
        operationService.add(1, DateTimeUtil.getDateTimeAsString(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss")
                + "：" + option.getTitle() + "，" + (option.getScore() > 0 ? "+" : "") + option.getScore() + " 分; 备注：" + txt);
        return true;
    }

    @PostMapping("/option/delete")
    public boolean deleteOption(Integer id) {
        Option option = optionService.get(id);
        try {
            optionService.delete(id);
            operationService.add(2, DateTimeUtil.getDateTimeAsString(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss")
                    + "：删除了" + option.getTitle() + "（" + option.getScore() + " 分)");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/option/update")
    public boolean addOption(@RequestBody OptionDTO dto) {
        Option option = optionService.get(dto.getId());
        try {
            optionService.update(dto.getId(), dto.getTitle(), dto.getScore());
            operationService.add(2, DateTimeUtil.getDateTimeAsString(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss")
                    + "：修改了" + dto.getTitle() + "（" + dto.getScore() + " 分)，修改前：" + option.getTitle() + "（" + option.getScore() + " 分");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/option/add")
    public boolean updateOption(@RequestBody OptionDTO dto) {
        optionService.add(dto.getTitle(), dto.getScore());
        operationService.add(2, DateTimeUtil.getDateTimeAsString(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss")
                + "：添加了" + dto.getTitle() + "（" + dto.getScore() + " 分)");
        return true;
    }
}
