package top.banner.demo.controller;

import org.springframework.web.bind.annotation.*;
import top.banner.demo.entity.Experiment;
import top.banner.demo.service.ExperimentService;
import top.banner.demo.service.exception.Result;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: XGL
 */
@RestController
public class ExperimentController {
    @Resource
    private ExperimentService experimentService;


    /**
     * 发布实验
     *
     * @param map
     * @return
     */
    @PostMapping("/experiments")
    public Experiment create(@RequestBody Map<String, ?> map) {
        return experimentService.create(map);
    }

    /**
     * 实验列表
     */
    @GetMapping("/experiments")
    public List<Experiment> list(@RequestAttribute(required = false) Integer teacherId) {
        return experimentService.list(teacherId);
    }

    /**
     * 学生加入实验
     */
    @PostMapping("/experiments/{id}/{studentId}")
    public Experiment addExperiment(@PathVariable Integer id, @PathVariable Integer studentId) {
        return experimentService.addExperiment(id, studentId);
    }

    /**
     * 删除实验
     *
     * @param id
     */
    @DeleteMapping("/experiments/{id}")
    public Result deleteExperiments(@PathVariable Integer id) {
        return experimentService.deleteExperiments(id);
    }
}
