package ec.springboot.controller;

import ec.springboot.service.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class RankController {

    private final Rank rankService;

    @Autowired
    public RankController(Rank rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/grade/{score}")
    public Map<String, String> getGrade(@PathVariable int score) {
        Map<String, String> response = new HashMap<>();
        response.put("grade", rankService.getGrade(score));
        return response;
    }

    @GetMapping("/rank/{score}")
    public Map<String, Integer> getRank(@PathVariable int score) {
        Map<String, Integer> response = new HashMap<>();
        response.put("rank", rankService.getRank(score));
        return response;
    }

    @GetMapping("/grade-rank/{score}")
    public Map<String, Object> getGradeAndRank(@PathVariable int score) {
        Map<String, Object> response = new HashMap<>();
        response.put("grade", rankService.getGrade(score));
        response.put("rank", rankService.getRank(score));
        return response;
    }
}
