package top.banner.demo.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import top.banner.demo.entity.Experiment;
import top.banner.demo.entity.ExperimentSchedule;
import top.banner.demo.entity.Student;
import top.banner.demo.entity.dao.ExperimentDao;
import top.banner.demo.entity.dao.StudentDao;
import top.banner.demo.entity.dao.TeacherDao;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: XGL
 */
@Service
public class ExperimentService {

    @Resource
    private TeacherDao teacherDao;
    @Resource
    private ExperimentDao experimentDao;
    @Resource
    private StudentDao studentDao;

    /**
     * 发布实验
     *
     * @param map
     * @return
     */
    @Transactional
    public Experiment create(Map<String, ?> map) {
        Experiment experiment = new Experiment();
        //设置实验老师
        Integer teacherId = Integer.valueOf(map.get("teacherId").toString());
        experiment.setTeacher(teacherDao.getOne(teacherId));
        //设置实验教室
        experiment.setClassRoom(map.get("classRoom").toString());
        experiment.setTitle(map.get("title").toString());
        experiment.setContent(map.get("content").toString());
        if (map.containsKey("data"))
            experiment.setData(map.get("data").toString());

        return experimentDao.save(experiment);
    }

    /**
     * 实验列表
     *
     * @param teacherId
     * @return
     */
    @Transactional(readOnly = true)
    public List<Experiment> list(Integer teacherId) {
        if (teacherId == null) {
            return experimentDao.findAll(Sort.by("id").descending());
        }
        return experimentDao.findByTeacherId(teacherId);
    }

    /**
     * 学生加入实验
     *
     * @param id
     * @param studentId
     * @return
     */
    @Transactional
    public Experiment addExperiment(Integer id, Integer studentId) {
        //todo 先检查是否已经加过实验

        Experiment experiment = experimentDao.findById(id).get();
        Student student = studentDao.getOne(studentId);
        ExperimentSchedule experimentSchedule = new ExperimentSchedule();
        experimentSchedule.setExperiment(experiment);
        experimentSchedule.setStudent(student);

        Map<Student, ExperimentSchedule> schedule = experiment.getSchedule();

        schedule.put(student, experimentSchedule);
        return experimentDao.save(experiment);
    }
}


